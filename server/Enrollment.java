import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Enrollment extends EnrollmentOperations implements EnrollmentInterface {

    private static Map<String, Enrollment> enrollments = new HashMap<>();

    protected Enrollment() throws RemoteException {
        super();
    }

    public Enrollment(String id, String courseId, String studentId) throws RemoteException {
        super(id, courseId, studentId);
    }

    @Override
    public void displayEnrollment() throws RemoteException {
        System.out.println("Enrollment ID: " + id);
        System.out.println("Course ID: " + courseId);
        System.out.println("Student ID: " + studentId);
    }

    @Override
    public synchronized String addEnrollment(String id, String courseId, String studentId) throws RemoteException {
        try (Connection connection = getConnection()) {
            String insertQuery = "INSERT INTO enrollment (id, course_id, student_id) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, id);
                preparedStatement.setString(2, courseId);
                preparedStatement.setString(3, studentId);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Enrollment added: ID=" + id + ", CourseID=" + courseId + ", StudentID=" + studentId);
                    return "Enrollment added successfully.";
                } else {
                    System.out.println("Failed to add enrollment: ID=" + id + ", CourseID=" + courseId + ", StudentID=" + studentId);
                    return "Failed to add enrollment.";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}
