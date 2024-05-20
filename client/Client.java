import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            RMIInterface remoteObject = (RMIInterface) registry.lookup("RMIInterface");
            remoteObject.displayInfo();

            System.out.println("Connected to the RMI server.");

            Scanner scanner = new Scanner(System.in);
            boolean exit = false;

            while (!exit) {
                System.out.println("Enter 1 to add a course, 2 to add a student, 3 to register a student for a course, or 0 to exit:");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        addCourse(remoteObject, scanner);
                        break;
                    case 2:
                        addStudent(remoteObject, scanner);
                        break;
                    case 3:
                        registerStudentForCourse(remoteObject, scanner);
                        break;
                    case 0:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }

            System.out.println("Client exiting.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addCourse(RMIInterface remoteObject, Scanner scanner) {
        try {
            System.out.println("Enter course ID:");
            String courseId = scanner.nextLine();
            System.out.println("Enter course title:");
            String courseTitle = scanner.nextLine();
            System.out.println("Enter course description:");
            String courseDescription = scanner.nextLine();
            String response = remoteObject.addCourse(courseId, courseTitle, courseDescription);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addStudent(RMIInterface remoteObject, Scanner scanner) {
        try {
            System.out.println("Enter student ID:");
            String studentId = scanner.nextLine();
            System.out.println("Enter student name:");
            String name = scanner.nextLine();
            System.out.println("Enter student age:");
            int age = scanner.nextInt();
            scanner.nextLine(); // consume newline
            System.out.println("Enter student address:");
            String address = scanner.nextLine();
            System.out.println("Enter student contact number:");
            String contactNumber = scanner.nextLine();
            String response = remoteObject.addStudent(studentId, name, age, address, contactNumber);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void registerStudentForCourse(RMIInterface remoteObject, Scanner scanner) {
        try {
            System.out.println("Enter student ID:");
            String studentId = scanner.nextLine();
            System.out.println("Enter course ID:");
            String courseId = scanner.nextLine();
            String response = remoteObject.registerStudentForCourse(studentId, courseId);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
