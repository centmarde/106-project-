import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

    public static void main(String[] args) {
        try {
            // Create instances of your remote objects
            StudentInterface studentImpl = new Student();
            CourseInterface courseImpl = new Course();
            EnrollmentInterface enrollmentImpl = new Enrollment();

            // Bind each remote object to the RMI registry
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("StudentService", studentImpl);
            registry.rebind("CourseService", courseImpl);
            registry.rebind("EnrollmentService", enrollmentImpl);

            System.out.println("Server is ready...");
        } catch (RemoteException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
