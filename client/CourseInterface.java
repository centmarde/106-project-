import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CourseInterface extends Remote {
    void displayCourse() throws RemoteException;
    String getId() throws RemoteException;
    String getTitle() throws RemoteException;
    String getDescription() throws RemoteException;
    String addCourse(String courseId, String courseTitle, String courseDescription) throws RemoteException;
}