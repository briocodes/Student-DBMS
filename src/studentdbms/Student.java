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


    //TODO 3 - Constructor: Prompt user to enter student's name and year
    public Student(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student's firstname: ");
        this.firstname = scanner.nextLine();

        System.out.print("Enter student's lastname: ");
        this.lastname = scanner.nextLine();

        System.out.print("1 - Junior\n2 - Senior\n3 - Intermediate\n4 - Professional\nEnter " +
                "student's grade level: ");
        this.gradeYear = scanner.nextLine();
        setStudentID();
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
        int payment = scanner.nextInt();
        tuitionBalance = tuitionBalance - payment;
        System.out.println("Thanks for paying $" + payment + " of your tuition");
        viewBalance();
    }

    //TODO 8 - Show Status
    public String toString(){
        return "\nSTUDENT INFO SUMMARY\nNAME: " + firstname + " " + lastname +
                "\nGRADE LEVEL: " + gradeYear + "\nSTUDENT ID: " + studentID + "\nCOURSES ENROLLED: "  + courses +
                "\nTUITION BALANCE: $" + tuitionBalance;
    }
}
