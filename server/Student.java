import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Student extends UnicastRemoteObject implements StudentInterface {
    private static final String URL = "jdbc:mysql://localhost:3306/rmi2";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private String id = "n/a";
    private String name ="n/a";
    private String age="n/a";
    private String address="n/a";
    private String contactNumber="n/a";

    protected Student() throws RemoteException {
        super();
    }

    @Override
    public void displayInfo() throws RemoteException {
        System.out.println("RMI Server is running...");
    }
    
    @Override
    public String getId() throws RemoteException {
        return id;
    }

    @Override
    public String getName() throws RemoteException {
        return name;
    }

    @Override
    public String getAge() throws RemoteException {
        return age;
    }

    @Override
    public String getAddress() throws RemoteException {
        return address;
    }

    @Override
    public String getContactNumber() throws RemoteException {
        return contactNumber;
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
    

   
}
