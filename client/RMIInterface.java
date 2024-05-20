import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote {
    void displayInfo() throws RemoteException;
    String getId() throws RemoteException;
    String getName() throws RemoteException;
    String getAge() throws RemoteException;
    String getAddress() throws RemoteException;
    String getContactNumber() throws RemoteException;
}

