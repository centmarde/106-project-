import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIInterfaceImpl extends UnicastRemoteObject implements RMIInterface {

    protected RMIInterfaceImpl() throws RemoteException {
        super();
    }

    private String id = "rebinding to client";
    private String name ="rebinding to client";
    private String age="rebinding to client";
    private String address="rebinding to client";
    private String contactNumber="rebinding to client";

    @Override
    public void displayInfo() throws RemoteException {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Contact Number: " + contactNumber);
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
}
