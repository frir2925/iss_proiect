package com.example.proiectiss;

import com.example.proiectiss.Controller.MessageAlert;
import com.example.proiectiss.Domain.User;
import com.example.proiectiss.Service.SuperService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class LogInController {
    private SuperService superService;

    @FXML
    private TextField textFieldUsername;

    @FXML
    private TextField textFieldPassword;

    @FXML
    private javafx.scene.control.Button closeButton;

    @FXML
    private void closeButtonAction() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void logIn() {
        String username_selected = this.textFieldUsername.getText();
        String password_selected = this.textFieldPassword.getText();

        User user = superService.getUserByUsername(username_selected);
        if (user != null) {
            if (user.getPassword().equals(password_selected)) {
                if (user.getRol().equals("utilizator")) {
                    showClientApp(user.getUsername());
                } else {

                    showAdminApp(user.getUsername());
                }
            } else {
                MessageAlert.showMessage(null, Alert.AlertType.INFORMATION, "Logare esuata!", "Parola este incorecta!");
            }

        } else {
            MessageAlert.showMessage(null, Alert.AlertType.INFORMATION, "Logare esuata!", "Angajatul nu exista in baza de date!");
        }

    }


    public void register() {
        showRegister();
    }

    private void showRegister() {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/proiectiss/register.fxml"));

            AnchorPane root = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Register");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(root, 1000, 600);
            dialogStage.setScene(scene);

            RegisterController registerController = loader.getController();
            registerController.SetService(superService);

            dialogStage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void showClientApp(String username) {
        try {


            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/proiectiss/client.fxml"));

            AnchorPane root = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Welcome " + username);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(root, 1000, 600);
            dialogStage.setScene(scene);

            ClientController angajatController = loader.getController();
            angajatController.SetService(this.superService);

            dialogStage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private void showAdminApp(String username) {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/proiectiss/admin.fxml"));

            AnchorPane root = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Welcome " + username);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(root, 1000, 600);
            dialogStage.setScene(scene);

            AdminController adminController = loader.getController();
            adminController.SetService(this.superService);

            dialogStage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void SetService(SuperService superService) {
        this.superService = superService;
    }


}