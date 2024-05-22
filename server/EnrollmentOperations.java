import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class EnrollmentOperations extends BaseClass {

    protected String id;
    protected String courseId;
    protected String studentId;

    // Static block to load the MySQL JDBC driver
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("Failed to load MySQL driver");
        }
    }

    // Default constructor
    protected EnrollmentOperations() throws RemoteException {
        super();
    }

    // Parameterized constructor
    public EnrollmentOperations(String id, String courseId, String studentId) throws RemoteException {
        super();
        this.id = id;
        this.courseId = courseId;
        this.studentId = studentId;
    }

    // Method to get database connection
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // Getter for id
    public String getId() throws RemoteException {
        return id;
    }

    // Getter for courseId
    public String getCourseId() throws RemoteException {
        return courseId;
    }

    // Getter for studentId
    public String getStudentId() throws RemoteException {
        return studentId;
    }
}

class BaseClass implements Serializable {

    private static final long serialVersionUID = 1L;

    protected static final String URL = "jdbc:mysql://localhost:3306/rmi2";
    protected static final String USERNAME = "root";
    protected static final String PASSWORD = "";
}
