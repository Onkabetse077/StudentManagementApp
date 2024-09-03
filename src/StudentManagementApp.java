import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

// Student class to hold student data
class Student {
    private String id;
    private String name;
    private int age;
    private String email;
    private String course;

    public Student(String id, String name, int age, String email, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nName: " + name + "\nAge: " + age + "\nEmail: " + email + "\nCourse: " + course;
    }

    public int getAge() {
        return age;
    }
}

public class StudentManagementApp {
    private static List<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            ShowMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    SaveStudent();
                    break;
                case 2:
                    SearchStudent();
                    break;
                case 3:
                    DeleteStudent();
                    break;
                case 4:
                    StudentReport();
                    break;
                case 5:
                    System.out.println("Exiting Application...");
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void ShowMenu() {
        System.out.println("STUDENT MANAGEMENT APPLICATION");
        System.out.println("********************************");
        System.out.println("Enter (1) to launch menu or any other key to exit");

        if (scanner.nextInt() == 1) {
            System.out.println("Please select one of the following menu items:");
            System.out.println("(1) Capture a new student.");
            System.out.println("(2) Search for a student.");
            System.out.println("(3) Delete a student.");
            System.out.println("(4) Print student report.");
            System.out.println("(5) Exit Application.");
            System.out.print("Choice: ");
        }else {
            System.out.println("Exiting Application...");
            System.exit(0);
        }

    }

    private static void SaveStudent() {
        System.out.println("CAPTURE A NEW STUDENT");
        System.out.println("************************");
        System.out.print("Enter the student id: ");
        String id = scanner.nextLine();

        System.out.print("Enter the student name: ");
        String name = scanner.nextLine();

        int age = 0;
        while (true) {
            System.out.print("Enter the student age: ");
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                if (age >= 16) {
                    break;
                } else {
                    System.out.println("Invalid age. Age must be 16 or older.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();  // Clear invalid input
            }
        }

        System.out.print("Enter the student email: ");
        String email = scanner.nextLine();

        System.out.print("Enter the student course: ");
        String course = scanner.nextLine();

        students.add(new Student(id, name, age, email, course));
        System.out.println("Student captured successfully.");
    }

    private static void SearchStudent() {
        System.out.print("Enter student id to search: ");
        String id = scanner.nextLine();
        for (Student student : students) {
            if (student.toString().contains(id)) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void DeleteStudent() {
        System.out.print("Enter student id to delete: ");
        String id = scanner.nextLine();

        System.out.println("Are you sure you want to delete the student " + id + " from the system? yes (y) to delete.");
         char choose = scanner.next().charAt(0);
        if (choose == 'y' ||choose == 'Y') {
            students.removeIf(student -> student.toString().contains(id));
            System.out.println("---------------------------------------");
            System.out.println("Student with ID: " + id +" was deleted!");
            System.out.println("---------------------------------------");
        }
    }

    private static void StudentReport() {
        System.out.println("STUDENT REPORT");
        System.out.println("************************");
        for (Student student : students) {
            System.out.println(student);
            System.out.println("************************");
        }
    }
}
