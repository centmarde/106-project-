import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StudentInterface extends Remote {
    void displayInfo() throws RemoteException;
    public String addStudent(String studentId, String name, int age, String address, String contactNumber) throws RemoteException;
    String getId() throws RemoteException;
    String getName() throws RemoteException;
    String getAge() throws RemoteException;
    String getAddress() throws RemoteException;
    String getContactNumber() throws RemoteException;
}
