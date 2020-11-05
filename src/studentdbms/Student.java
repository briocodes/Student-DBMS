package studentdbms;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Student {
    private String firstname;
    private String lastname;
    private int gradeYear;
    private String studentID;
    private String courses = null;
    private int tuitionBalance = 0;
    private static int costOfCourse = 600;
    private static int id = 1000;
    private int payment;


    //TODO 3 - Constructor: Prompt user to enter student's name and year
    public Student(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student's firstname: ");
        this.firstname = scanner.nextLine();

        System.out.print("Enter student's lastname: ");
        this.lastname = scanner.nextLine();

        setGradeLevel();
        while (gradeYear<1 || gradeYear>4){
            setGradeLevel();
        }

        setStudentID();
        optionsMenu();
    }

    //TODO 4 - Generate an ID

    private void setStudentID(){
        id++;
        this.studentID = gradeYear + "" + id;
    }


    //TODO 5 - Enroll in courses
    public void enroll(){
        String course;
        do {
            System.out.print("Enter courses to enroll (Q to Quit): ");
            Scanner scanner = new Scanner(System.in);
            course = scanner.nextLine();
            if (!course.equals("Q")){
                courses = courses + "\n  " + course;
                tuitionBalance = tuitionBalance + costOfCourse;
            } else {
                break;
            }
        }while (course!="Q");
    }

    //TODO 6 - View balance
    public void viewBalance(){
        System.out.println("    TUITION BALANCE: $" + tuitionBalance);
        System.out.println("    AMOUNT PAID: $" + payment);
    }

    //TODO 7 - Pay Tuition
    public void payTuition(){
        viewBalance();
        System.out.print("Enter your payment amount: $");
        Scanner scanner = new Scanner(System.in);
        this.payment = scanner.nextInt();
        tuitionBalance = tuitionBalance - payment;
        System.out.println("\nPAYMENT CONFIRMED: \nCongratulations! You just paid your tuition");
        viewBalance();
    }

    //TODO 8 - Show Status
    public String toString(){
        return "\nSTUDENT INFO SUMMARY\nNAME: " + firstname + " " + lastname +
                "\nGRADE LEVEL: " + gradeYear + "\nSTUDENT ID: " + studentID + "\nCOURSES ENROLLED: "  + courses +
                "\nPAYMENTS MADE: $" + payment + "\nTUITION BALANCE: $" + tuitionBalance;
    }

    //TODO 9 - Added feature/Options menu
    public void optionsMenu(){
        try {
            int option;
            do {
                System.out.print("\nOPTIONS MENU\n1 - Enroll\n2 - Pay Tuition\n3 - View Balance\n4 - " +
                        "Show Status & QUIT(or Register Next Student)\nEnter an OPTION from the Menu:");
                Scanner scanner = new Scanner(System.in);
                option = scanner.nextInt();
                if (!(option <1) & !(option >4)){
                    switch (option){
                        case 1: enroll();
                            break;
                        case 2: payTuition();
                            break;
                        case 3: viewBalance();
                            break;
                        case 4: break;
                        default: System.out.println("   :::INVALID ENTRY:::");
                    }
                }else {
                    System.out.println("\n  :::INVALID ENTRY:::");
                }
            }while (option!= 4);
        }catch (InputMismatchException e){
            System.out.println("    :::INVALID INPUT:::");
            optionsMenu();
        }
    }
    public int setGradeLevel(){
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("\nACADEMIC GRADE LEVELS\n1 - Junior\n2 - Intermediate\n3 - Senior\n4 - Advanced\nEnter " +
                    "student's grade level: ");
            this.gradeYear = scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("\n  :::INVALID ENTRY:::");
        }
        return gradeYear;
    }
}
