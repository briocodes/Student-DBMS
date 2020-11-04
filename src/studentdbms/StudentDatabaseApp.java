package studentdbms;

import java.util.Scanner;

public class StudentDatabaseApp {
    public static void main(String[] args) {
        //TODO 1 - Ask how many users we need to add to the students database
        System.out.print("Enter the number of students you wish to add to the database: ");
        Scanner scanner = new Scanner(System.in);
        int numOfStudents = scanner.nextInt();
        Student[] students = new Student[numOfStudents];

        //TODO 2 - Create n Number of new students
        for (int n=0; n<numOfStudents; n++){
            students[n] = new Student();
        }
        for (int n=0; n<numOfStudents; n++){
            System.out.println(students[n].toString());
        }
    }
}
