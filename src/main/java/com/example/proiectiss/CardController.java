package com.example.proiectiss;

import com.example.proiectiss.Controller.MessageAlert;
import com.example.proiectiss.Domain.Rezervare;
import com.example.proiectiss.Service.SuperService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CardController {
    private SuperService superService;
    private Rezervare rezervare;


    @FXML
    private javafx.scene.control.Button closeButton;

    @FXML
    private TextField textFieldNume;

    @FXML
    private TextField textFieldPrenume;

    @FXML
    private TextField textFieldCard;

    @FXML
    private TextField textFieldCVV;

    @FXML
    private DatePicker datePicker;

    @FXML
    private void closeButtonAction() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void SetService(SuperService superService, Rezervare rezervare) {
        this.superService = superService;
        this.rezervare = rezervare;
    }


    public void cumparare() {
        textFieldNume.clear();
        textFieldPrenume.clear();
        textFieldCard.clear();
        textFieldCVV.clear();

        //superService.saveRezervare(rezervare);
        //System.out.println(rezervare.getId());
        //superService.updateRezervare(rezervare.getId(),new Rezervare(rezervare.getNume(), rezervare.getPrenume(), rezervare.getLocuri(),rezervare.getPret(),"da"));
        superService.updateRezervare(Long.valueOf(rezervare.getId()), new Rezervare(rezervare.getNume(), rezervare.getPrenume(), rezervare.getLocuri(), rezervare.getPret(), "da"));
/*
        String locuri = rezervare.getLocuri();
        String[] locuri_splited = locuri.split(",");
        System.out.println(locuri_splited);


        for (String a : locuri_splited) {
            Long id = Long.valueOf(a);
            Loc l = superService.getLocByLoc(id);
            superService.updateLoc(id,new Loc(l.getLoc(),l.getLoja(),l.getRand(),"nu",l.getPret()));
        }


 */


        MessageAlert.showMessage(null, Alert.AlertType.INFORMATION, "Plata efectuata", "Rezervare efectuata cu succes!");

    }


}





