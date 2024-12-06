package Model;
import DAO.EmployeDAOimpl;
import java.util.List;

public class EmployeModel {
    private EmployeDAOimpl dao;
    public EmployeModel(EmployeDAOimpl dao) {
        this.dao = dao;
    }

    // funtion of add Employe :

    public boolean addEmploye(int id ,String nom, String prenom, String email, String telephone, double salaire, Role role, Post post) {
        if(salaire < 0 ){
            System.out.println("Erreur : le salaire doit etre positif.");
            return false;
        }
        if(id < 0 ){
            System.out.println("Erreur : l'id doit etre positif.");
            return false;
        }
        if(telephone.length() != 10){
            System.out.println("Erreur : le telephone doit etre 10 num.");
            return false;
        }
        if(!email.contains("@")){
            System.out.println("Erreur : le mail doit contenir le @.");
            return false;
        }

        Employe e = new Employe(id,nom, prenom, email, telephone, salaire, role, post);
        
        return dao.addEmploye(e);
    }

    // function of delete Employe :

    public  boolean deleteEmploye(int id){
        dao.deleteEmploye(id);
        return true;
    }

    // function of update Employe :

    public boolean updateEmploye(int id, String nom, String prenom, String email, String telephone, double salaire, Role role, Post post) {

        Employe e = new Employe(id,nom, prenom, email, telephone, salaire, role, post);
        dao.updateEmploye(e);
        return true;
    }

    //function of display Employe :

    public List<Employe> displayEmploye() {
        List<Employe> Employes = dao.displayEmploye();
        return Employes;
    }
}
