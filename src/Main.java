import Controller.*;
import DAO.*;
import Model.*;
import View.*;

public class Main {

    public static void main(String[] args) {
        EmployeView view = new EmployeView();
        EmployeDAOimpl dao = new EmployeDAOimpl();
        EmployeModel model = new EmployeModel(dao);
        new EmployeController(view, model);
    }
}