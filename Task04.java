import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                ", grade='" + grade + '\'' +
                '}';
    }
}

class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student findStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public void saveToFile(String fileName) {
        // Implementation to save students to a file
    }

    public void loadFromFile(String fileName) {
        // Implementation to load students from a file
    }
}

public class Task04 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();

        while (true) {
            displayMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    addStudent(sms);
                    break;
                case 2:
                    removeStudent(sms);
                    break;
                case 3:
                    searchStudent(sms);
                    break;
                case 4:
                    displayAllStudents(sms);
                    break;
                case 5:
                    saveToFile(sms);
                    break;
                case 6:
                    loadFromFile(sms);
                    break;
                case 7:
                    exitApplication();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Student Management System");
        System.out.println("1. Add Student");
        System.out.println("2. Remove Student");
        System.out.println("3. Search Student");
        System.out.println("4. Display All Students");
        System.out.println("5. Save to File");
        System.out.println("6. Load from File");
        System.out.println("7. Exit");
        System.out.print("Select an option: ");
    }

    private static int getChoice() {
        int choice;
        while (true) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        return choice;
    }

    private static void addStudent(StudentManagementSystem sms) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();

        Student student = new Student(name, rollNumber, grade);
        sms.addStudent(student);
    }

    private static void removeStudent(StudentManagementSystem sms) {
        System.out.print("Enter roll number to remove: ");
        int rollToRemove = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        sms.removeStudent(rollToRemove);
    }

    private static void searchStudent(StudentManagementSystem sms) {
        System.out.print("Enter roll number to search: ");
        int rollToSearch = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        Student foundStudent = sms.findStudent(rollToSearch);
        if (foundStudent != null) {
            System.out.println("Student found: " + foundStudent);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void displayAllStudents(StudentManagementSystem sms) {
        List<Student> allStudents = sms.getAllStudents();
        if (allStudents.isEmpty()) {
            System.out.println("No students in the system.");
        } else {
            for (Student s : allStudents) {
                System.out.println(s);
            }
        }
    }

    private static void saveToFile(StudentManagementSystem sms) {
        sms.saveToFile("students.dat");
        System.out.println("Data saved to file.");
    }

    private static void loadFromFile(StudentManagementSystem sms) {
        sms.loadFromFile("students.dat");
        System.out.println("Data loaded from file.");
    }

    private static void exitApplication() {
        System.out.println("Exiting application.");
        scanner.close();
        System.exit(0);
    }
}
