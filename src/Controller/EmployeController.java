package Controller;

import Model.*;
import View.*;
import java.util.List;

import javax.swing.table.DefaultTableModel;


public class EmployeController {

    private final EmployeView View;
    public EmployeModel model;
    public static int id = 0;

    public EmployeController(EmployeView view, EmployeModel model) {
        this.View = view;
        this.model = model;

        View.getaddButton().addActionListener(e -> addEmploye());
        View.getdeleteButton().addActionListener(e -> deleteEmploye());
        View.getupdateButton().addActionListener(e -> updateEmploye());
        View.getdisplayButton().addActionListener(e -> displayEmploye());
    }



    private void displayEmploye() {
        List<Employe> Employes = model.displayEmploye();

        DefaultTableModel tableModel = (DefaultTableModel) EmployeView.Tableau.getModel();
        tableModel.setRowCount(0);
        for(Employe e : Employes){
            tableModel.addRow(new Object[]{e.getId(), e.getNom(), e.getPrenom(), e.getEmail(), e.getTelephone(), e.getSalaire(), e.getRole(), e.getPost()});
        }
    }

    
    // function of add Employe :

    private void addEmploye() {
        String nom = View.getNom();
        String prenom = View.getPrenom();
        String email = View.getEmail();
        String telephone = View.getTelephone();
        double salaire = View.getSalaire();
        Role role = View.getRole();
        Post poste = View.getPoste();

        View.viderChamps();
        boolean addreussi = model.addEmploye(0,nom, prenom, email, telephone, salaire, role, poste);

        if(addreussi == true){
            View.afficherMessageSucces("L'employe a bien ete ajoutee.");
            displayEmploye();
        }else{
            View.afficherMessageErreur("L'employe n'a pas ete ajoutee.");
        }
    }



    // function of delete Employe : 

    private void deleteEmploye(){
        int selectedrow = EmployeView.Tableau.getSelectedRow();

        if(selectedrow == -1){
            View.afficherMessageErreur("Veuillez selectionner une ligne.");
        }else{
            int id = (int) EmployeView.Tableau.getValueAt(selectedrow, 0);
            if(model.deleteEmploye(id)){
                View.afficherMessageSucces("L'employe a bien ete supprimer.");
                displayEmploye();
            }else{
                View.afficherMessageErreur("L'employe n'a pas ete supprimer.");
            }
        }
    }

    // function of Update :

    private void updateEmploye(){
        int selectedrow = EmployeView.Tableau.getSelectedRow();
        String nom = "";
        String prenom = "";
        String email = "";
        String telephone = "";
        double salaire = 0;
        Role role = null;
        Post poste = null;
        boolean updatereussi = false;

        if(selectedrow == -1 && View.testChampsVide()){
            View.afficherMessageErreur("Veuillez selectionner une ligne.");
        }else if(View.testChampsVide()){
            id = (int) EmployeView.Tableau.getValueAt(selectedrow, 0);
            nom = (String) EmployeView.Tableau.getValueAt(selectedrow, 1);
            prenom = (String) EmployeView.Tableau.getValueAt(selectedrow, 2);
            email = (String) EmployeView.Tableau.getValueAt(selectedrow, 3);
            telephone = (String) EmployeView.Tableau.getValueAt(selectedrow, 4);
            salaire = (double) EmployeView.Tableau.getValueAt(selectedrow, 5);
            role = (Role) EmployeView.Tableau.getValueAt(selectedrow, 6);
            poste = (Post) EmployeView.Tableau.getValueAt(selectedrow, 7);
        }
        if(!View.testChampsVide()){
            nom = View.getNom();
            prenom = View.getPrenom();
            email = View.getEmail();
            telephone = View.getTelephone();
            salaire = View.getSalaire();
            role = View.getRole();
            poste = View.getPoste();
            updatereussi = model.updateEmploye(id, nom, prenom, email, telephone, salaire, role, poste);

            if(updatereussi){
                View.afficherMessageSucces("L'employe a bien ete modifier");
                displayEmploye();
                View.viderChamps();
            }else{
                View.afficherMessageErreur("L'employe n'a pas ete modifier");
            }
        }

        View.remplaireChamps(id, nom, prenom, email, telephone, salaire, role, poste);
    }

}