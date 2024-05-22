import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EnrollmentInterface extends Remote {
    void displayEnrollment() throws RemoteException;
    String getId() throws RemoteException;
    String getCourseId() throws RemoteException;
    String getStudentId() throws RemoteException;
    public String addEnrollment(String id, String courseId, String studentId) throws RemoteException;
}
