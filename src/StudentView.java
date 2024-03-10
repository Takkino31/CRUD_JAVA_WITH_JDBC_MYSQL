import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * StudentView
 */
public class StudentView {

    public static void main(String[] args) throws SQLException {
        StudentModel etudiant1 = new StudentModel("Shakur", "Tupac", 17);
        StudentModel etudiant2 = new StudentModel("Oumar", "Diop", 26);
        StudentModel etudiant3 = new StudentModel("Amar", "Fama", 57);
        StudentModel etudiant4 = new StudentModel("Diop", "Ndack", 9);
        StudentModel etudiant5 = new StudentModel("CBAG", "Cheikh Babacar", 10);

        StudentRepository Student = new StudentRepository();
        Student.insertStudent(etudiant1);
        Student.insertStudent(etudiant2);
        Student.insertStudent(etudiant3);
        Student.insertStudent(etudiant4);
        Student.insertStudent(etudiant5);
        ResultSet rs = Student.getAllStudents();
        while (rs.next()) {

            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            int age = rs.getInt("age");

            // Création d'une instance d'étudiant avec les données récupérées
            StudentModel studentToShow = new StudentModel(nom, prenom, age);
            System.out.println(studentToShow);
        }
        StudentModel etudiantToUpdate = new StudentModel("Ali", "Bob", 17);
        Student.updateStudent(1, etudiantToUpdate);
        Student.deleteEtudiant(2);
        rs = Student.getAllStudents();
        while (rs.next()) {
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            int age = rs.getInt("age");
            // Créer une instance d'étudiant avec les données récupérées
            StudentModel studentToShow = new StudentModel(nom, prenom, age);
            System.out.println(studentToShow);
        }

    }
}