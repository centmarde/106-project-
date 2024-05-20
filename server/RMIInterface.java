import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote {
    void displayInfo() throws RemoteException;
    public String registerStudentForCourse(String studentId, String courseId) throws RemoteException;
    String addCourse(String courseId, String courseTitle, String courseDescription) throws RemoteException;
    String addStudent(String studentId, String name, int age, String address, String contactNumber) throws RemoteException;
}
