import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ConnexionDB
 */
public class ConnexionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/School";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public Connection getConnexion() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers loaded! Takkatsuka");
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur Driver FOR NAME Not FOUND");
            e.printStackTrace();
        }
        System.out.println("Connexion Reussie");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}