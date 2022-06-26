package com.example.proiectiss;

import com.example.proiectiss.Controller.MessageAlert;
import com.example.proiectiss.Domain.Event;
import com.example.proiectiss.Domain.Loc;
import com.example.proiectiss.Domain.Rezervare;
import com.example.proiectiss.Domain.User;
import com.example.proiectiss.Service.SuperService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class AdminController {
    ObservableList<Object> event = FXCollections.observableArrayList();
    private SuperService superService;
    @FXML
    private TextField textFieldUsernameAdmin;

    @FXML
    private TextField textFieldPasswordAdmin;

    @FXML
    private TableView<Object> tableEvent;

    @FXML
    private TableColumn<Event, String> columnNume;

    @FXML
    private TableColumn<Event, String> columnDescriere;

    @FXML
    private TableColumn<Event, Integer> columnLocuri;
    @FXML
    private TextField textFieldNume;
    @FXML
    private TextField textFieldDescriere;
    @FXML
    private TextField textFieldLocuri;
    @FXML
    private javafx.scene.control.Button closeButton;

    @FXML
    private void close() {
        Platform.exit();
    }

    @FXML
    private void closeButtonAction() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void SetService(SuperService superService) {
        this.superService = superService;
        initTabelEvent();
    }

    @FXML
    public void initialize() {

        columnNume.setCellValueFactory(new PropertyValueFactory<>("Nume"));
        columnDescriere.setCellValueFactory(new PropertyValueFactory<>("Descriere"));
        columnLocuri.setCellValueFactory(new PropertyValueFactory<>("Locuri"));

        tableEvent.setItems(event);

    }

    private void initTabelEvent() {
        List<Event> eventList = StreamSupport.stream(superService.getAllEvents().spliterator(), false)
                .map(x -> {
                    Event event = new Event(x.getNume(), x.getDescriere(), x.getLocuri());
                    return event;
                })
                .collect(Collectors.toList());
        event.setAll(eventList);

    }

    public void clearEvent() {
        List<Event> result = StreamSupport.stream(superService.getAllEvents().spliterator(), false)
                .collect(Collectors.toList());
        if (result.size() == 0) {
            MessageAlert.showMessage(null, Alert.AlertType.INFORMATION, "Eroare!", "Nu exista niciun eveniment!");
        } else {
            superService.clearEvent();
            initTabelEvent();
        }
        clearRezervari();
    }

    public void addEvent() {
        List<Event> result = StreamSupport.stream(superService.getAllEvents().spliterator(), false)
                .collect(Collectors.toList());
        if (result.size() == 1) {
            MessageAlert.showMessage(null, Alert.AlertType.INFORMATION, "Eroare!", "Exista deja un event! Sterge-l pe cel actual!");
        } else {

            String nume = textFieldNume.getText();
            String descriere = textFieldDescriere.getText();


            if (nume.equals("") || descriere.equals("") || textFieldLocuri.getText().equals("")) {
                MessageAlert.showMessage(null, Alert.AlertType.INFORMATION, "Eroare!", "Completati toate datele!");
            } else {
                if (textFieldLocuri.getText().matches("^[0-9]*$")) {
                    int locuri = Integer.valueOf(textFieldLocuri.getText());
                    superService.saveEvent(nume, descriere, locuri);
                    textFieldLocuri.clear();
                    textFieldDescriere.clear();
                    textFieldNume.clear();
                    initTabelEvent();
                } else {
                    MessageAlert.showMessage(null, Alert.AlertType.INFORMATION, "Eroare!", "Nr. de locuri contine litere!");
                }

            }
        }
    }

    public void updateEvent() {
        List<Event> result = StreamSupport.stream(superService.getAllEvents().spliterator(), false)
                .collect(Collectors.toList());
        if (result.size() == 0) {
            MessageAlert.showMessage(null, Alert.AlertType.INFORMATION, "Eroare!", "Nu exista un event de updatat!");
        } else {

            String nume = textFieldNume.getText();
            String descriere = textFieldDescriere.getText();


            if (nume.equals("") || descriere.equals("") || textFieldLocuri.getText().equals("")) {
                MessageAlert.showMessage(null, Alert.AlertType.INFORMATION, "Eroare!", "Completati toate datele!");
            } else {
                if (textFieldLocuri.getText().matches("^[0-9]*$")) {
                    int locuri = Integer.valueOf(textFieldLocuri.getText());
                    Long idEvent = result.get(0).getId();
                    superService.updateEvent(idEvent, new Event(nume, descriere, locuri));
                    textFieldLocuri.clear();
                    textFieldDescriere.clear();
                    textFieldNume.clear();
                    initTabelEvent();
                } else {
                    MessageAlert.showMessage(null, Alert.AlertType.INFORMATION, "Eroare!", "Nr. de locuri contine litere!");
                }

            }
        }
    }

    public void clearRezervari() {
        Iterable<Loc> locuri = superService.getAllLocuri();

        for (Loc l : locuri) {
            superService.updateLoc(l.getId(), new Loc(l.getLoc(), l.getLoja(), l.getRand(), "da", l.getPret()));
        }

        Iterable<Rezervare> rezervari = superService.getAllRezervari();
        for (Rezervare r : rezervari) {
            superService.deleteRezervare(r.getId());
        }
    }

    public void adaugaAdmin() {

        if (textFieldPasswordAdmin.getText().equals("") || textFieldUsernameAdmin.getText().equals("")) {
            MessageAlert.showMessage(null, Alert.AlertType.INFORMATION, "Eroare!", "Completati toate datele!");
        } else {
            String username = textFieldUsernameAdmin.getText();
            String password = textFieldPasswordAdmin.getText();
            superService.saveUser(new User(username, password, "admin"));
            textFieldUsernameAdmin.clear();
            textFieldPasswordAdmin.clear();
            MessageAlert.showMessage(null, Alert.AlertType.INFORMATION, "", "Admin adaugat cu succes!");
        }


    }


}