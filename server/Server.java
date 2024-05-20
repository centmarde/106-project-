import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server extends RMIInterfaceImpl {

    protected Server() throws RemoteException {
        super();
    }

    public static void main(String[] args) {
        try {
            Server server = new Server();
            RMIInterface stub = (RMIInterface) server;

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("RMIInterface", stub);

            System.out.println("Server is ready...");
        } catch (RemoteException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
