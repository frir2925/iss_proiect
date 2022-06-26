package com.example.proiectiss;

import com.example.proiectiss.Controller.MessageAlert;
import com.example.proiectiss.Domain.User;
import com.example.proiectiss.Service.SuperService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {
    private SuperService superService;

    @FXML
    private TextField textFieldUsername;

    @FXML
    private TextField textFieldPassword;

    @FXML
    private TextField textFieldPassword2;

    @FXML
    private javafx.scene.control.Button closeButton;

    @FXML
    private void closeButtonAction() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }


    @FXML
    public void register() {


        String username_selected = this.textFieldUsername.getText();
        String password_selected = this.textFieldPassword.getText();
        String password_selected2 = this.textFieldPassword2.getText();

        if (superService.getUserByUsername(username_selected) != null)
            MessageAlert.showMessage(null, Alert.AlertType.INFORMATION, "Registered!", "Userul deja exista");

        else {

            if (password_selected.equals(password_selected2)) {
                superService.saveUser(new User(username_selected, password_selected, "utilizator"));
                MessageAlert.showMessage(null, Alert.AlertType.INFORMATION, "Registered!", "Utilizator inregistrat");
                textFieldPassword.clear();
                textFieldUsername.clear();
                textFieldPassword2.clear();

            } else {
                MessageAlert.showMessage(null, Alert.AlertType.INFORMATION, "Registered!", "Parola nu corespunde");
            }
        }
    }


    public void SetService(SuperService superService) {
        this.superService = superService;
    }


}