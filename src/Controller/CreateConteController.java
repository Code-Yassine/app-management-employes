package Controller;

import Model.CreateConteModel;
import View.CreateConteView;


public class CreateConteController {
    private CreateConteView view;
    public CreateConteModel model;

    public CreateConteController(CreateConteView view, CreateConteModel model) {
        this.view = view;
        this.model = model;

        // view.getLoginButton().addActionListener(e -> login());
    }


    // public void login(){
    //     String username = view.getUsername();
    //     String password = view.getPassword();

    //     model.login(username, password);
    // }
}
