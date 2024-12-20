package org.example.trspolaba4;


import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import org.example.trspolaba4.model.User;
import org.example.trspolaba4.controller.DatabaseController;

import org.example.trspolaba4.controller.UserController;


public class HelloController {

    DatabaseController dbCtrl = new DatabaseController();

    public TableView user_table;
    public TableColumn user_id;
    public TableColumn user_name;
    public TableColumn user_password;
    public TableColumn user_roles;
    public TableColumn user_email;



    public Label user_idLabel;
    public Label user_nameLabel;
    public Label user_passwordLabel;
    public Label user_rolesLabel;
    public Label user_emailLabel;

    public TextField user_idTextField;
    public TextField user_nameTextField;
    public TextField user_passwordTextField;
    public TextField user_rolesTextField;
    public TextField user_emailTextField;
    UserController uCtrl = new UserController(dbCtrl);




    //Estate
//    public TableView estate_table;
//    public TableColumn estate_id;
//    public TableColumn estate_sellerName;
//    public TableColumn title;
//    public TableColumn estate_cost;
//    public TableColumn estate_time;
//    public ChoiceBox<User> estate_sellerChoiceBox;
//    public TextField estate_idTextField;
//    public TextField titleTextField;
//    public TextField estate_costTextField;
//    public TextField estate_timeTextField;
//    public EstateController eCtrl = new EstateController(dbCtrl);

    public void reconnect() {
        user_read();
//        estate_read();
    }


    public void initialize() {
        user_read();
        estate_read();
        user_autofill();
        estate_autofill();
    }

    //Users
    private void user_read() {
        uCtrl.read(user_table, user_id, user_name, user_email);
    }

    public void user_createButton() {
        uCtrl.create(Integer.parseInt(user_idTextField.getText()), user_nameTextField.getText(), user_mailTextField.getText());
        user_read();
    }

    public void user_updateButton() {
        uCtrl.update(Integer.parseInt(user_idTextField.getText()), user_nameTextField.getText(), user_mailTextField.getText());
        user_read();
    }

    public void user_deleteButton() {
        uCtrl.delete(Integer.parseInt(user_idTextField.getText()));
        user_read();
    }

    private void user_autofill() {
        user_table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue == null) return;
            User selectedUser = (User) newValue;
            user_idTextField.setText(String.valueOf(selectedUser.getId()));
            user_nameTextField.setText(selectedUser.getName());
            user_mailTextField.setText(selectedUser.getMail());
        });
    }

    //Estate

//    private void estate_read() {
//        eCtrl.read(estate_table, estate_id, estate_sellerName, title, estate_cost, estate_time);
//    }
//
//    private void estate_autofill() {
//        estate_table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            Estate selectedEstate = (Estate) newValue;
//            estate_idTextField.setText(String.valueOf(selectedEstate.getId()));
//            estate_sellerChoiceBox.setValue(selectedEstate.getSeller());
//            estate_sellerChoiceBox.setItems(uCtrl.getIdAndNameUsers());
//            titleTextField.setText(selectedEstate.getTitle());
//            estate_costTextField.setText(String.valueOf(selectedEstate.getCost()));
//            estate_timeTextField.setText(String.valueOf(selectedEstate.getTime()));
//            estate_read();
//        });
//    }
//
//    public void estate_createButton() {
//        eCtrl.create(Integer.parseInt(estate_idTextField.getText()), estate_sellerChoiceBox.getValue(), titleTextField.getText(), Double.parseDouble(estate_costTextField.getText()), LocalDateTime.parse(estate_timeTextField.getText()));
//        estate_read();
//    }
//
//
//    public void estate_updateButton() {
//        eCtrl.update(Integer.parseInt(estate_idTextField.getText()), estate_sellerChoiceBox.getValue(), titleTextField.getText(), Double.parseDouble(estate_costTextField.getText()), LocalDateTime.parse(estate_timeTextField.getText()));
//        estate_read();
//    }
//
//    public void estate_deleteButton() {
//        eCtrl.delete(Integer.parseInt(estate_idTextField.getText()));
//        estate_read();
//    }
}

