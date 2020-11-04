package studentdbms;

import java.util.Scanner;

public class Student {
    private String firstname;
    private String lastname;
    private String gradeYear;
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

        System.out.print("\nACADEMIC GRADE LEVELS\n1 - Junior\n2 - Senior\n3 - Intermediate\n4 - Professional\nEnter " +
                "student's grade level: ");
        this.gradeYear = scanner.nextLine();
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
        System.out.println("TUITION BALANCE: $" + tuitionBalance);
    }

    //TODO 7 - Pay Tuition
    public void payTuition(){
        viewBalance();
        System.out.print("Enter your payment amount: $");
        Scanner scanner = new Scanner(System.in);
        this.payment = scanner.nextInt();
        tuitionBalance = tuitionBalance - payment;
        System.out.println("\nPAYMENT CONFIRMED: \nThanks for paying $" + payment + " of your total tuition");
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
        int option;
        do {
            System.out.print("\nOPTIONS MENU\n1 - Enroll\n2 - Pay Tuition\n3 - View Balance\n4 - " +
                    "Show Status (or Register Next Student)\nEnter an OPTION from the Menu:");
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
                    default: System.out.println("Invalid Entry");
                }
            }
        }while (option!= 4);
    }
}
