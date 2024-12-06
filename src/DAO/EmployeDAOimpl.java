
package DAO;
import Model.Employe;
import Model.Post;
import Model.Role;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmployeDAOimpl implements EmployeDAOI {

    @Override
    public boolean addEmploye(Employe e) {
        String sql = "INSERT INTO employe (nom, prenom, email, telephone, salaire, role, poste) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = DBConnexion.getConnexion().prepareStatement(sql)) {
            stmt.setString(1, e.getNom()); 
            stmt.setString(2, e.getPrenom());
            stmt.setString(3, e.getEmail());
            stmt.setString(4, e.getTelephone());
            stmt.setDouble(5, e.getSalaire());
            stmt.setString(6, e.getRole().name());
            stmt.setString(7, e.getPost().name());
            stmt.executeUpdate();
        } catch (SQLException exception) {
            System.err.println("failed of add employe ");
            return false;
        } catch (ClassNotFoundException ex) {
            System.err.println("failed connexion with data base");
            return false;
        }
        return true;
    }

    @Override
    public void deleteEmploye(int id) {
        String sql = "DELETE FROM employe WHERE id = ?";
        try (PreparedStatement stmt = DBConnexion.getConnexion().prepareStatement(sql)) {
            stmt.setInt(1,id);
            stmt.executeUpdate();
        } catch (SQLException exception) {
            System.err.println("failed of delete employe");
        } catch (ClassNotFoundException ex) {
            System.err.println("failed connexion with data base");
        }
    }

    @Override
    public void updateEmploye(Employe e) {
        String sql = "UPDATE employe SET nom = ?, prenom = ?, email = ?, telephone = ?, salaire = ?, role = ?, poste = ? WHERE id = ?";
        try (PreparedStatement stmt = DBConnexion.getConnexion().prepareStatement(sql)) {
            stmt.setString(1, e.getNom());
            stmt.setString(2, e.getPrenom());
            stmt.setString(3, e.getEmail());
            stmt.setString(4, e.getTelephone());
            stmt.setDouble(5, e.getSalaire());
            stmt.setString(6, e.getRole().name());
            stmt.setString(7, e.getPost().name());
            stmt.setInt(8,e.getId());
            stmt.executeUpdate();
        } catch (SQLException exception) {
            System.err.println("failed of update employe");
        } catch (ClassNotFoundException ex) {
            System.err.println("failed connexion with data base");
        }
    }

    @Override
    public List<Employe> displayEmploye() {
        String sql = "SELECT * FROM employe";
        List<Employe> Employes = new ArrayList<Employe>();
        try (PreparedStatement stmt = DBConnexion.getConnexion().prepareStatement(sql)) {
            ResultSet re = stmt.executeQuery();
            while (re.next()) {
                int id = re.getInt("id");
                String nom = re.getString("nom");
                String prenom = re.getString("prenom");
                String email = re.getString("email");
                String telephone = re.getString("telephone");
                double salaire = re.getDouble("salaire");
                String role = re.getString("role");
                String poste = re.getString("poste");
                Employe e = new Employe(id,nom, prenom, email, telephone, salaire, Role.valueOf(role), Post.valueOf(poste));
                Employes.add(e);
            }
            return Employes;
        } catch (ClassNotFoundException ex) {
            System.err.println("failed connexion with data base");
            return null;
        } catch (SQLException ex) {
            System.err.println("failed of display employe");
            return null;
        }
    }

}

