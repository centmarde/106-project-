import java.io.File;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Client {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            StudentInterface studentRemoteObject = (StudentInterface) registry.lookup("StudentService");
            CourseInterface courseRemoteObject = (CourseInterface) registry.lookup("CourseService");
            EnrollmentInterface enrollmentRemoteObject = (EnrollmentInterface) registry.lookup("EnrollmentService");

            System.out.println("Connected to the RMI server.");
            
            Scanner scanner = new Scanner(System.in);
            boolean exit = false;

            while (!exit) {
                System.out.println("Choose an option:");
                System.out.println("1. Parse Students");
                System.out.println("2. Parse Courses");
                System.out.println("3. Parse Enrollments");
                System.out.println("4. Exit");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addStudentsFromXML(studentRemoteObject);
                        break;
                    case 2:
                        addCourseFromXML(courseRemoteObject);
                        break;
                    case 3:
                        registerStudentsForCoursesFromXML(enrollmentRemoteObject);
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose again.");
                        break;
                }
            }
            
            scanner.close();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void addStudentsFromXML(StudentInterface remoteObject) {
        try {
            File file = new File("C:/laragon/www/RMI2/storage/Students.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            NodeList studentList = document.getElementsByTagName("Student");
            for (int i = 0; i < studentList.getLength(); i++) {
                Element studentElement = (Element) studentList.item(i);
                String studentId = studentElement.getAttribute("student_id");
                String name = studentElement.getAttribute("name");
                int age = Integer.parseInt(studentElement.getAttribute("age"));
                String address = studentElement.getAttribute("address");
                String contactNumber = studentElement.getAttribute("contact_number");
                String response = remoteObject.addStudent(studentId, name, age, address, contactNumber);
                System.out.println(response);
            }
        } catch (Exception e) {
            System.err.println("Error adding student: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void registerStudentsForCoursesFromXML(EnrollmentInterface remoteObject) {
        try {
            File file = new File("C:/laragon/www/RMI2/storage/Enrollment.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            NodeList enrollmentList = document.getElementsByTagName("Enrollment");
            for (int i = 0; i < enrollmentList.getLength(); i++) {
                Element enrollmentElement = (Element) enrollmentList.item(i);
                String enrollmentId = enrollmentElement.getAttribute("Id");
                String courseId = enrollmentElement.getAttribute("course_id");
                String studentId = enrollmentElement.getAttribute("student_id");
                String response = remoteObject.addEnrollment(enrollmentId, courseId, studentId);
                System.out.println(response);
            }
        } catch (Exception e) {
            System.err.println("Error registering students for courses from XML: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void addCourseFromXML(CourseInterface remoteObject) {
        try {
            File file = new File("C:/laragon/www/RMI2/storage/Courses.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            NodeList courseList = document.getElementsByTagName("Course");
            for (int i = 0; i < courseList.getLength(); i++) {
                Element courseElement = (Element) courseList.item(i);
                String courseId = courseElement.getAttribute("course_id");
                String courseTitle = courseElement.getAttribute("course_title");
                String courseDescription = courseElement.getAttribute("course_description");
                String response = remoteObject.addCourse(courseId, courseTitle, courseDescription);
                System.out.println(response);
            }
        } catch (Exception e) {
            System.err.println("Error adding course: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
