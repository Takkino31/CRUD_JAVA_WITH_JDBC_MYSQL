import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * StudentRepository
 */
public class StudentRepository {

    public void insertStudent(StudentModel student) {
        try {
            String prepareStatementInsertion = "INSERT INTO Etudiant (nom , prenom, age) VALUES (?, ?, ?)";

            ConnexionDB connexionDB = new ConnexionDB();
            Connection connected = connexionDB.getConnexion();

            PreparedStatement preparedStatement = connected.prepareStatement(prepareStatementInsertion);

            preparedStatement.setString(1, student.getLastName());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.executeUpdate();
            connected.close();

            System.out.println("SUCCEED : Nouvel Etudiant Inséré !!!");
        } catch (SQLException e) {
            e.getSQLState();
            e.getErrorCode();
            e.printStackTrace();
        }

    }

    public ResultSet getAllStudents() {
        try {

            ConnexionDB connexionDB = new ConnexionDB();
            Connection connected = connexionDB.getConnexion();
            String prepareStatementGetALl = "SELECT * FROM Etudiant";
            PreparedStatement preparedStatement = connected.prepareStatement(prepareStatementGetALl);

            ResultSet students = preparedStatement.executeQuery();
            // connected.close();

            return students;
        } catch (SQLException e) {
            e.getSQLState();
            e.getErrorCode();
            e.printStackTrace();
        }
        return null;
    }

    public void updateStudent(int id, StudentModel student) {
        try {
            String prepareStatementInsertion = "UPDATE Etudiant SET nom = ? , prenom = ? , age = ? WHERE id = ?";

            ConnexionDB connexionDB = new ConnexionDB();
            Connection connected = connexionDB.getConnexion();

            PreparedStatement preparedStatement = connected.prepareStatement(prepareStatementInsertion);

            preparedStatement.setString(1, student.getLastName());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setInt(4, id);

            int rowsUpdated = preparedStatement.executeUpdate();
            connected.close();

            if (rowsUpdated > 0)
                System.out.println("Étudiant avec l'ID " + id + " mis à jour avec succès.");
            else
                System.out.println("Aucun étudiant trouvé avec l'ID " + id + ".");

        } catch (SQLException e) {
            e.getSQLState();
            e.getErrorCode();
            e.printStackTrace();
        }

    }

    public void deleteEtudiant(int id) {
        try {
            String prepareStatementDelete = "DELETE FROM Etudiant WHERE id = ?";

            ConnexionDB connexionDB = new ConnexionDB();
            Connection connected = connexionDB.getConnexion();

            PreparedStatement preparedStatement = connected.prepareStatement(prepareStatementDelete);

            preparedStatement.setInt(1, id);
            int rowsDeleted = preparedStatement.executeUpdate();
            connected.close();
            if (rowsDeleted > 0)
                System.out.println("Étudiant avce l'id " + id + " supprimé : ");
            else
                System.out.println("Étudiant avce l'id " + id + " non trouvé : ");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}