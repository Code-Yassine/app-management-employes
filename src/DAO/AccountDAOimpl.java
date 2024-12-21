// package DAO;
// import java.sql.PreparedStatement;
// import java.sql.SQLException;

// import Model.Account;

// public class AccountDAOimpl implements AccountDAO{
//     @Override
//     public void CreateAccount(Account a) {
//         String sql = "INSERT INTO account (id_employe,username, password) VALUES (?,?, ?)";
//         try(PreparedStatement stmt = DBConnexion.getConnexion().prepareStatement(sql)){
//             stmt.setInt(1, a.getId_employe());
//             stmt.setString(2, a.getUsername());
//             stmt.setString(3, a.getPassword());
//             stmt.executeUpdate();
//         } catch (SQLException exception) {
//             System.err.println("failed of add employe ");
//         }
//     }
// }