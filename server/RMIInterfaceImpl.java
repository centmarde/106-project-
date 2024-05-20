import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RMIInterfaceImpl extends UnicastRemoteObject implements RMIInterface {
    private static final String URL = "jdbc:mysql://localhost:3306/rmi2";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    protected RMIInterfaceImpl() throws RemoteException {
        super();
    }

    @Override
    public void displayInfo() throws RemoteException {
        System.out.println("RMI Server is running...");
    }

    @Override
    public String addCourse(String courseId, String courseTitle, String courseDescription) throws RemoteException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String insertQuery = "INSERT INTO courses (course_id, course_title, course_description) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, courseId);
            preparedStatement.setString(2, courseTitle);
            preparedStatement.setString(3, courseDescription);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Course added: ID=" + courseId + ", Title=" + courseTitle + ", Description=" + courseDescription);
                return "Course added successfully.";
            } else {
                System.out.println("Failed to add course: ID=" + courseId + ", Title=" + courseTitle + ", Description=" + courseDescription);
                return "Failed to add course.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    @Override
    public String addStudent(String studentId, String name, int age, String address, String contactNumber) throws RemoteException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String insertQuery = "INSERT INTO students (student_id, name, age, address, contact_number) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, studentId);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, contactNumber);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student added: ID=" + studentId + ", Name=" + name + ", Age=" + age + ", Address=" + address + ", Contact Number=" + contactNumber);
                return "Student added successfully.";
            } else {
                System.out.println("Failed to add student: ID=" + studentId + ", Name=" + name + ", Age=" + age + ", Address=" + address + ", Contact Number=" + contactNumber);
                return "Failed to add student.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
    

    @Override
    public String registerStudentForCourse(String studentId, String courseId) throws RemoteException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String insertQuery = "INSERT INTO enrollment (course_id, student_id) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, courseId);
            preparedStatement.setString(2, studentId);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return "Student " + studentId + " registered for course " + courseId + " successfully.";
            } else {
                return "Failed to register student " + studentId + " for course " + courseId + ".";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}
