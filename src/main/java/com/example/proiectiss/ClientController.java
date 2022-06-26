package com.example.proiectiss;

import com.example.proiectiss.Controller.MessageAlert;
import com.example.proiectiss.Domain.Event;
import com.example.proiectiss.Domain.Loc;
import com.example.proiectiss.Domain.Rezervare;
import com.example.proiectiss.Service.SuperService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ClientController {
    ObservableList<Object> event = FXCollections.observableArrayList();
    private SuperService superService;
    @FXML
    private Label labelCumparare;

    @FXML
    private Label labelPret;

    @FXML
    private TextField textFieldCumparare;
    @FXML
    private TextField textFieldNume;
    @FXML
    private TextField textFieldPrenume;

    @FXML
    private Button cumparare;


    @FXML
    private TableView<Object> tableEvent;

    @FXML
    private TableColumn<Event, String> columnNume;

    @FXML
    private TableColumn<Event, String> columnDescriere;

    @FXML
    private TableColumn<Event, Integer> columnLocuri;

    @FXML
    private Button locButton1;
    @FXML
    private Button locButton2;
    @FXML
    private Button locButton3;
    @FXML
    private Button locButton4;
    @FXML
    private Button locButton5;
    @FXML
    private Button locButton6;
    @FXML
    private Button locButton7;
    @FXML
    private Button locButton8;
    @FXML
    private Button locButton9;
    @FXML
    private Button locButton10;
    @FXML
    private Button locButton11;
    @FXML
    private Button locButton12;
    @FXML
    private Button locButton13;
    @FXML
    private Button locButton14;
    @FXML
    private Button locButton15;
    @FXML
    private Button locButton16;
    @FXML
    private Button locButton17;
    @FXML
    private Button locButton18;
    @FXML
    private Button locButton19;
    @FXML
    private Button locButton20;
    @FXML
    private Button locButton21;
    @FXML
    private Button locButton22;
    @FXML
    private Button locButton23;
    @FXML
    private Button locButton24;
    @FXML
    private Button locButton25;
    @FXML
    private Button locButton26;
    @FXML
    private Button locButton27;
    @FXML
    private Button locButton28;
    @FXML
    private Button locButton29;
    @FXML
    private Button locButton30;
    @FXML
    private Button locButton31;
    @FXML
    private Button locButton32;
    @FXML
    private javafx.scene.control.Button closeButton;

    @FXML
    private void close() {
        Platform.exit();
    }

    public void SetService(SuperService superService) {
        this.superService = superService;
        initTabelEvent();
        initLocButtons();
        labelPret.setText("0");
    }

    @FXML
    private void closeButtonAction() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void initialize() {

        columnNume.setCellValueFactory(new PropertyValueFactory<>("Nume"));
        columnDescriere.setCellValueFactory(new PropertyValueFactory<>("Descriere"));
        columnLocuri.setCellValueFactory(new PropertyValueFactory<>("Locuri"));

        tableEvent.setItems(event);

    }

    private void initTabelEvent() {

        List<Event> zborList = StreamSupport.stream(superService.getAllEvents().spliterator(), false)
                .map(x -> {
                    Event event = new Event(x.getNume(), x.getDescriere(), x.getLocuri());
                    return event;
                })
                .collect(Collectors.toList());
        event.setAll(zborList);

    }

    public void initLocButtons() {
        if (superService.getLocByLoc(Long.valueOf(1)).getDisponibilitate().equals("da"))
            locButton1.setStyle("-fx-background-color: #aaf0d1; ");
        else
            locButton1.setStyle("-fx-background-color: #ff6347; ");
        /////
        if (superService.getLocByLoc(Long.valueOf(2)).getDisponibilitate().equals("da"))
            locButton2.setStyle("-fx-background-color: #aaf0d1; ");
        else
            locButton2.setStyle("-fx-background-color: #ff6347; ");
        /////
        if (superService.getLocByLoc(Long.valueOf(3)).getDisponibilitate().equals("da"))
            locButton3.setStyle("-fx-background-color: #aaf0d1; ");
        else
            locButton3.setStyle("-fx-background-color: #ff6347; ");
        /////
        if (superService.getLocByLoc(Long.valueOf(4)).getDisponibilitate().equals("da"))
            locButton4.setStyle("-fx-background-color: #aaf0d1; ");
        else
            locButton4.setStyle("-fx-background-color: #ff6347; ");
        /////
        if (superService.getLocByLoc(Long.valueOf(5)).getDisponibilitate().equals("da"))
            locButton5.setStyle("-fx-background-color: #aaf0d1; ");
        else
            locButton5.setStyle("-fx-background-color: #ff6347; ");
        /////
        if (superService.getLocByLoc(Long.valueOf(6)).getDisponibilitate().equals("da"))
            locButton6.setStyle("-fx-background-color: #aaf0d1; ");
        else
            locButton6.setStyle("-fx-background-color: #ff6347; ");
        /////
        if (superService.getLocByLoc(Long.valueOf(7)).getDisponibilitate().equals("da"))
            locButton7.setStyle("-fx-background-color: #aaf0d1; ");
        else
            locButton7.setStyle("-fx-background-color: #ff6347; ");
        /////
        if (superService.getLocByLoc(Long.valueOf(8)).getDisponibilitate().equals("da"))
            locButton8.setStyle("-fx-background-color: #aaf0d1; ");
        else
            locButton8.setStyle("-fx-background-color: #ff6347; ");
        /////
        if (superService.getLocByLoc(Long.valueOf(9)).getDisponibilitate().equals("da"))
            locButton9.setStyle("-fx-background-color: #aaf0d1; ");
        else
            locButton9.setStyle("-fx-background-color: #ff6347; ");
        /////
        if (superService.getLocByLoc(Long.valueOf(10)).getDisponibilitate().equals("da"))
            locButton10.setStyle("-fx-background-color: #aaf0d1; ");
        else
            locButton10.setStyle("-fx-background-color: #ff6347; ");
        /////
        if (superService.getLocByLoc(Long.valueOf(11)).getDisponibilitate().equals("da"))
            locButton11.setStyle("-fx-background-color: #aaf0d1; ");
        else
            locButton11.setStyle("-fx-background-color: #ff6347; ");
        /////
        if (superService.getLocByLoc(Long.valueOf(12)).getDisponibilitate().equals("da"))
            locButton12.setStyle("-fx-background-color: #aaf0d1; ");
        else
            locButton12.setStyle("-fx-background-color: #ff6347; ");
        /////
        if (superService.getLocByLoc(Long.valueOf(13)).getDisponibilitate().equals("da"))
            locButton13.setStyle("-fx-background-color: #aaf0d1; ");
        else
            locButton13.setStyle("-fx-background-color: #ff6347; ");
        /////
        if (superService.getLocByLoc(Long.valueOf(14)).getDisponibilitate().equals("da"))
            locButton14.setStyle("-fx-background-color: #aaf0d1; ");
        else
            locButton14.setStyle("-fx-background-color: #ff6347; ");
        /////
        if (superService.getLocByLoc(Long.valueOf(15)).getDisponibilitate().equals("da"))
            locButton15.setStyle("-fx-background-color: #aaf0d1; ");
        else
            locButton15.setStyle("-fx-background-color: #ff6347; ");
        /////
        if (superService.getLocByLoc(Long.valueOf(16)).getDisponibilitate().equals("da"))
            locButton16.setStyle("-fx-background-color: #aaf0d1; ");
        else
            locButton16.setStyle("-fx-background-color: #ff6347; ");
        /////
        if (superService.getLocByLoc(Long.valueOf(17)).getDisponibilitate().equals("da"))
            locButton17.setStyle("-fx-background-color: #aaf0d1; ");
        else
            locButton17.setStyle("-fx-background-color: #ff6347; ");
        /////
        if (superService.getLocByLoc(Long.valueOf(18)).getDisponibilitate().equals("da"))
            locButton18.setStyle("-fx-background-color: #aaf0d1; ");
        else
            locButton18.setStyle("-fx-background-color: #ff6347; ");
        /////
        if (superService.getLocByLoc(Long.valueOf(19)).getDisponibilitate().equals("da"))
            locButton19.setStyle("-fx-background-color: #aaf0d1; ");
        else
            locButton19.setStyle("-fx-background-color: #ff6347; ");
        /////
        if (superService.getLocByLoc(Long.valueOf(20)).getDisponibilitate().equals("da"))
            locButton20.setStyle("-fx-background-color: #aaf0d1; ");
        else
            locButton20.setStyle("-fx-background-color: #ff6347; ");
        /////
        if (superService.getLocByLoc(Long.valueOf(21)).getDisponibilitate().equals("da"))
            locButton21.setStyle("-fx-background-color: #aaf0d1; ");
        else
            locButton21.setStyle("-fx-background-color: #ff6347; ");
        /////
        if (superService.getLocByLoc(Long.valueOf(22)).getDisponibilitate().equals("da"))
            locButton22.setStyle("-fx-background-color: #aaf0d1; ");
        else
            locButton22.setStyle("-fx-background-color: #ff6347; ");
        /////
        if (superService.getLocByLoc(Long.valueOf(23)).getDisponibilitate().equals("da"))
            locButton23.setStyle("-fx-background-color: #aaf0d1; ");
        else
            locButton23.setStyle("-fx-background-color: #ff6347; ");
        /////
        if (superService.getLocByLoc(Long.valueOf(24)).getDisponibilitate().equals("da"))
            locButton24.setStyle("-fx-background-color: #aaf0d1; ");
        else
            locButton24.setStyle("-fx-background-color: #ff6347; ");
        /////
        if (superService.getLocByLoc(Long.valueOf(25)).getDisponibilitate().equals("da"))
            locButton25.setStyle("-fx-background-color: #aaf0d1; ");
        else
            locButton25.setStyle("-fx-background-color: #ff6347; ");
        /////
        if (superService.getLocByLoc(Long.valueOf(26)).getDisponibilitate().equals("da"))
            locButton26.setStyle("-fx-background-color: #aaf0d1; ");
        else
            locButton26.setStyle("-fx-background-color: #ff6347; ");
        /////
        if (superService.getLocByLoc(Long.valueOf(27)).getDisponibilitate().equals("da"))
            locButton27.setStyle("-fx-background-color: #aaf0d1; ");
        else
            locButton27.setStyle("-fx-background-color: #ff6347; ");
        /////
        if (superService.getLocByLoc(Long.valueOf(28)).getDisponibilitate().equals("da"))
            locButton28.setStyle("-fx-background-color: #aaf0d1; ");
        else
            locButton28.setStyle("-fx-background-color: #ff6347; ");
        /////
        if (superService.getLocByLoc(Long.valueOf(29)).getDisponibilitate().equals("da"))
            locButton29.setStyle("-fx-background-color: #aaf0d1; ");
        else
            locButton29.setStyle("-fx-background-color: #ff6347; ");
        /////
        if (superService.getLocByLoc(Long.valueOf(30)).getDisponibilitate().equals("da"))
            locButton30.setStyle("-fx-background-color: #aaf0d1; ");
        else
            locButton30.setStyle("-fx-background-color: #ff6347; ");
        /////
        if (superService.getLocByLoc(Long.valueOf(31)).getDisponibilitate().equals("da"))
            locButton31.setStyle("-fx-background-color: #aaf0d1; ");
        else
            locButton31.setStyle("-fx-background-color: #ff6347; ");
        /////
        if (superService.getLocByLoc(Long.valueOf(32)).getDisponibilitate().equals("da"))
            locButton32.setStyle("-fx-background-color: #aaf0d1; ");
        else
            locButton32.setStyle("-fx-background-color: #ff6347; ");


    }


    public void anulareCumparare() {
        labelCumparare.setText("");
        initLocButtons();
        labelPret.setText("0");
    }


    public void addTicket() {


        if (textFieldCumparare.getText().equals("")) {
            MessageAlert.showMessage(null, Alert.AlertType.INFORMATION, "Eroare!", "Completeaza locul pe care il doresti!");
        } else {

            int ok = 0;
            String text = textFieldCumparare.getText();
            String bilete = labelCumparare.getText();
            String[] bilete_splited = bilete.split(",");
            for (String b : bilete_splited)
                if (text.equals(b)) {
                    ok = 1;
                    MessageAlert.showMessage(null, Alert.AlertType.INFORMATION, "Eroare!", "Ai ales deja biletul respectiv!");
                }

            if (Integer.valueOf(text) > 32 || Integer.valueOf(text) < 1) {
                ok = 1;
                MessageAlert.showMessage(null, Alert.AlertType.INFORMATION, "Eroare!", "Alege un bilet in intervalul 1-32");
            }

            if (ok == 0) {
                Loc l = superService.getLocByLoc(Long.valueOf(text));
                {
                    if (l.getDisponibilitate().equals("da")) {
                        String textLabel = labelCumparare.getText();
                        labelCumparare.setText(textLabel + text + ",");

                        int pret = Integer.valueOf(labelPret.getText());
                        pret = pret + l.getPret();
                        labelPret.setText(Integer.toString(pret));

                    } else {
                        MessageAlert.showMessage(null, Alert.AlertType.INFORMATION, "Eroare!", "Locul nu e disponibil!");
                    }
                }
            }


        }

    }

    @FXML
    private void showPayPal() {
        try {

            if (textFieldNume.getText().equals("") || textFieldPrenume.getText().equals("")) {
                MessageAlert.showMessage(null, Alert.AlertType.INFORMATION, "Eroare!", "Completeaza toate campurile!");
            } else {
                if (labelCumparare.getText().equals("")) {
                    MessageAlert.showMessage(null, Alert.AlertType.INFORMATION, "Eroare!", "Nu ai selectat niciun loc!");
                } else {

                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/proiectiss/paypal.fxml"));

                    AnchorPane root = (AnchorPane) loader.load();

                    Stage dialogStage = new Stage();
                    dialogStage.setTitle("Paypal Pay");
                    dialogStage.initModality(Modality.WINDOW_MODAL);
                    Scene scene = new Scene(root, 1000, 600);
                    dialogStage.setScene(scene);

                    Rezervare rez = new Rezervare(textFieldNume.getText(), textFieldPrenume.getText(), labelCumparare.getText(), Integer.valueOf(labelPret.getText()), "nu");
                    superService.saveRezervare(rez);
                    Rezervare rez2 = superService.findOneRezervareByLocuri(labelCumparare.getText());
                    //System.out.println(rez.getId());


                    String locuri = rez.getLocuri();
                    String[] locuri_splited = locuri.split(",");
                    System.out.println(locuri_splited);


                    for (String a : locuri_splited) {
                        Long id = Long.valueOf(a);
                        Loc l = superService.getLocByLoc(id);
                        superService.updateLoc(id, new Loc(l.getLoc(), l.getLoja(), l.getRand(), "nu", l.getPret()));
                    }


                    PayPalController payPalController = loader.getController();
                    payPalController.SetService(superService, rez2);

                    textFieldNume.clear();
                    textFieldPrenume.clear();
                    textFieldCumparare.clear();

                    dialogStage.show();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    @FXML
    private void showCard() {
        try {

            if (textFieldNume.getText().equals("") || textFieldPrenume.getText().equals("")) {
                MessageAlert.showMessage(null, Alert.AlertType.INFORMATION, "Eroare!", "Completeaza toate campurile!");
            } else {
                if (labelCumparare.getText().equals("")) {
                    MessageAlert.showMessage(null, Alert.AlertType.INFORMATION, "Eroare!", "Nu ai selectat niciun loc!");
                } else {

                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/proiectiss/card.fxml"));

                    AnchorPane root = (AnchorPane) loader.load();

                    Stage dialogStage = new Stage();
                    dialogStage.setTitle("Paypal Pay");
                    dialogStage.initModality(Modality.WINDOW_MODAL);
                    Scene scene = new Scene(root, 1000, 600);
                    dialogStage.setScene(scene);

                    Rezervare rez = new Rezervare(textFieldNume.getText(), textFieldPrenume.getText(), labelCumparare.getText(), Integer.valueOf(labelPret.getText()), "nu");
                    superService.saveRezervare(rez);
                    Rezervare rez2 = superService.findOneRezervareByLocuri(labelCumparare.getText());

                    //System.out.println(rez.getId());


                    String locuri = rez.getLocuri();
                    String[] locuri_splited = locuri.split(",");
                    System.out.println(locuri_splited);


                    for (String a : locuri_splited) {
                        Long id = Long.valueOf(a);
                        Loc l = superService.getLocByLoc(id);
                        superService.updateLoc(id, new Loc(l.getLoc(), l.getLoja(), l.getRand(), "nu", l.getPret()));
                    }


                    CardController cardController = loader.getController();
                    cardController.SetService(superService, rez2);

                    textFieldNume.clear();
                    textFieldPrenume.clear();
                    textFieldCumparare.clear();

                    dialogStage.show();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}