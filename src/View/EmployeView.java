package View;

import Model.Post;
import Model.Role;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EmployeView extends JFrame {

    private JPanel General = new JPanel();
    private JPanel Display_Table = new JPanel();
    private final JPanel Forme = new JPanel();
    private JPanel panButton = new JPanel();

    private JLabel label_nom = new JLabel("Nom");
    private JLabel label_prenom = new JLabel("Prenom");
    private JLabel label_email = new JLabel("Email");
    private JLabel label_tele = new JLabel("Telephone");
    private JLabel label_salaire = new JLabel("Salaire");
    private JLabel label_role = new JLabel("Role");
    private JLabel label_poste = new JLabel("Poste");

    private JTextField text_nom = new JTextField();
    private JTextField text_prenom = new JTextField();
    private JTextField text_email = new JTextField();
    private JTextField text_tele = new JTextField();
    private JTextField text_salaire = new JTextField();

    private JComboBox<Role> roleComboBox = new JComboBox<>(Role.values());
    private JComboBox<Post> posteComboBox = new JComboBox<>(Post.values());

    private JButton addButton = new JButton("Ajouter");
    private JButton updateButton = new JButton("Modifier");
    private JButton deleteButton = new JButton("Supprimer");
    private JButton displayButton = new JButton("Afficher");

    JPanel pan0 = new JPanel(new BorderLayout());
    public static String[] columnNames = {"ID", "Nom", "Prenom", "Email", "Téléphone", "Salaire", "Role", "Poste"};
    public static DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
    public static JTable Tableau = new JTable(tableModel);

    public EmployeView() {
        setTitle("Gestion des employes");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(General);
        General.setLayout(new BorderLayout());

        General.add(Display_Table, BorderLayout.CENTER);

        Tableau.setFillsViewportHeight(true);
        Dimension preferredSize = new Dimension(900, 500);
        Tableau.setPreferredScrollableViewportSize(preferredSize);
        pan0.add(new JScrollPane(Tableau), BorderLayout.CENTER);
        Display_Table.add(pan0);

        General.add(panButton, BorderLayout.SOUTH);
        panButton.add(addButton);
        panButton.add(updateButton);
        panButton.add(deleteButton);
        panButton.add(displayButton);

        General.add(Forme, BorderLayout.NORTH);
        Forme.setLayout(new GridLayout(7, 2, 10, 10));
        Forme.add(label_nom);
        Forme.add(text_nom);
        Forme.add(label_prenom);
        Forme.add(text_prenom);
        Forme.add(label_email);
        Forme.add(text_email);
        Forme.add(label_tele);
        Forme.add(text_tele);
        Forme.add(label_salaire);
        Forme.add(text_salaire);
        Forme.add(label_role);
        Forme.add(roleComboBox);
        Forme.add(label_poste);
        Forme.add(posteComboBox);

        setVisible(true);
    }

    public String getNom() {
        return text_nom.getText();
    }

    public JTable getTable() {
        return (JTable) Display_Table.getComponent(0);
    }

    public String getPrenom() {
        return text_prenom.getText();
    }

    public String getEmail() {
        return text_email.getText();
    }

    public String getTelephone() {
        return text_tele.getText();
    }

    public double getSalaire() {
        return Double.parseDouble(text_salaire.getText());
    }

    public Role getRole() {
        return (Role) roleComboBox.getSelectedItem();
    }

    public Post getPoste() {
        return (Post) posteComboBox.getSelectedItem();
    }

    public JButton getaddButton() {
        return addButton;
    }

    public JButton getupdateButton() {
        return updateButton;
    }

    public JButton getdeleteButton() {
        return deleteButton;
    }

    public JButton getdisplayButton() {
        return displayButton;
    }

    public void afficherMessageErreur(String message) {
        JOptionPane.showMessageDialog(this, message, "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    public void afficherMessageSucces(String message) {
        JOptionPane.showMessageDialog(this, message, "Succès", JOptionPane.INFORMATION_MESSAGE);
    }

    public void viderChamps() {
        text_nom.setText("");
        text_prenom.setText("");
        text_email.setText("");
        text_tele.setText("");
        text_salaire.setText("");
        roleComboBox.setSelectedIndex(0);
        posteComboBox.setSelectedIndex(0);
    }

    public void remplaireChamps(int id, String nom, String prenom, String email, String telephone, double salaire, Role role, Post poste) {
        text_nom.setText(nom);
        text_prenom.setText(prenom);
        text_email.setText(email);
        text_tele.setText(telephone);
        text_salaire.setText(String.valueOf(salaire));
        roleComboBox.setSelectedItem(role);
        posteComboBox.setSelectedItem(poste);
    }

    public boolean testChampsVide(){
        return text_nom.getText().equals("") || text_prenom.getText().equals("") || text_email.getText().equals("") || text_tele.getText().equals("") || text_salaire.getText().equals("");
    }
}

