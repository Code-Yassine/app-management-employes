package Model;
import DAO.EmployeDAOimpl;
import DAO.HolidayDAOimpl;

import java.util.List;
import javax.swing.text.View;

public class EmployeModel {
    private EmployeDAOimpl dao;
    public EmployeModel(EmployeDAOimpl dao) {
        this.dao = dao;
    }

    // funtion of add Employe :
    public boolean addEmploye(int id ,String nom, String prenom, String email, String telephone, double salaire, Role role, Post post, int solde) {
        if(salaire < 0 ){
            System.out.println("Erreur : le salaire doit etre positif.");
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
        for(Employe e : new EmployeModel(new EmployeDAOimpl()).displayEmploye()){
            if(e.getEmail().equals(email)){
                return false;
            }
            if(e.getTelephone().equals(telephone)){
                return false;
            }
        }

        Employe e = new Employe(id,nom, prenom, email, telephone, salaire, role, post ,solde);
        
        dao.add(e);

        return true;
    }

    // function of delete Employe :
    public  boolean deleteEmploye(int id){
        for(Holiday e : new HolidayModel(new HolidayDAOimpl()).displayHoliday()){
            if(e.getId_employe()== id){
                return false;
            }
        }
        dao.delete(id);
        return true;
    }

    // function of update Employe :
    public boolean updateEmploye(int id, String nom, String prenom, String email, String telephone, double salaire, Role role, Post post , int solde) {

        Employe e = new Employe(id,nom, prenom, email, telephone, salaire, role, post,solde);
        dao.update(e);
        return true;
    }


    //function of display Employe :
    public List<Employe> displayEmploye() {
        List<Employe> Employes = dao.display();
        return Employes;
    }

    //function of update solde Employe :
    public boolean updateSolde(int id, int solde) {
        dao.updateSolde(id, solde);
        return true;
    }
}