package com.example.proiectiss;

import com.example.proiectiss.Repository.Database.EventDatabase;
import com.example.proiectiss.Repository.Database.LocDatabase;
import com.example.proiectiss.Repository.Database.RezervareDatabase;
import com.example.proiectiss.Repository.Database.UserDatabase;
import com.example.proiectiss.Service.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class Main extends Application {


    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {


        Properties props = new Properties();
        try {
            props.load(new FileReader("bd.config.properties"));
        } catch (IOException e) {
            System.out.println("Cannot find bd.config " + e);
        }


        UserDatabase userRepo = new UserDatabase(props);
        UserService userService = new UserService(userRepo);

        EventDatabase eventRepo = new EventDatabase(props);
        EventService eventService = new EventService((eventRepo));

        LocDatabase locRepo = new LocDatabase(props);
        LocService locService = new LocService(locRepo);

        RezervareDatabase rezervareRepo = new RezervareDatabase(props);
        RezervareService rezervareService = new RezervareService(rezervareRepo);

        SuperService superService = new SuperService(userService, eventService, locService, rezervareService);

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/proiectiss/login.fxml"));
            AnchorPane root = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(root));
            dialogStage.setTitle("Login");

            LogInController ctrl = loader.getController();
            ctrl.SetService(superService);

            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
