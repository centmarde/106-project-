import java.rmi.Naming;
import java.sql.Connection;
import java.sql.DriverManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.sql.PreparedStatement;


public class Client {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/rmiproject";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            RMIInterface remoteObject = (RMIInterface) registry.lookup("RMIInterface");
            remoteObject.displayInfo();

            System.out.println("Connected to the database.");

            // Parse and insert students
            System.out.println("Parsing and inserting students...");
            StudentParser studentParser = new StudentParser();
            studentParser.parseAndInsertStudents(connection, "C:/laragon/www/rmiProject/Students.xml");

            // Parse and insert courses
            System.out.println("Parsing and inserting courses...");
            CourseParser courseParser = new CourseParser();
            courseParser.parseAndInsertCourses(connection, "C:/laragon/www/rmiProject/Courses.xml");

            System.out.println("Data insertion completed.");

            connection.close();
            System.out.println("Connection closed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


abstract class DataParser {

  protected void insertData(Connection connection, String filePath, String tagName, String insertQuery, String[] attributes) {
    try {
      Document document = parseXML(filePath);
      if (document == null) return;

      System.out.println("Root element: " + document.getDocumentElement().getNodeName());
      NodeList nList = document.getElementsByTagName(tagName);
      PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

      System.out.println("----------------------------");
      for (int i = 0; i < nList.getLength(); i++) {
        Node nNode = nList.item(i);
        System.out.println("\nCurrent Element: " + nNode.getNodeName());
        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
          Element eElement = (Element) nNode;

          for (int j = 0; j < attributes.length; j++) {
            String value = eElement.getAttribute(attributes[j]);
            preparedStatement.setString(j + 1, value);
            System.out.println(attributes[j] + ": " + value);
          }

          int rowsAffected = preparedStatement.executeUpdate();
          if (rowsAffected > 0) {
            System.out.println("Data inserted successfully.");
          } else {
            System.out.println("Data insertion failed.");
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  protected Document parseXML(String filePath) {
    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse(filePath);
      document.getDocumentElement().normalize();
      return document;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}

class CourseParser extends DataParser {

  public void parseAndInsertCourses(Connection connection, String filePath) {
    String insertQuery = "INSERT INTO courses (course_id, course_title, course_description) VALUES (?, ?, ?)";
    String[] attributes = {"course_id", "course_title", "course_description"};
    insertData(connection, filePath, "Course", insertQuery, attributes);
  }
}

class StudentParser extends DataParser {

  public void parseAndInsertStudents(Connection connection, String filePath) {
    String insertQuery = "INSERT INTO students (student_id, name, age, address, contact_number) VALUES (?, ?, ?, ?, ?)";
    String[] attributes = {"student_id", "name", "age", "address", "contact_number"};
    insertData(connection, filePath, "Student", insertQuery, attributes);
  }
}
