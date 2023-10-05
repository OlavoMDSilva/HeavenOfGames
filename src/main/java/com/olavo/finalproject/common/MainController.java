package com.olavo.finalproject.common;

import com.olavo.finalproject.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.io.IOException;

public class MainController {

    @FXML
    private Button btnClient;

    @FXML
    private Button btnAdm;

    public void goToClientWin(ActionEvent event) {
        try {
            Main.switchScene("fxml/ClientWin");
        } catch (IOException e) {
            System.out.println("ERROR: MainController.goToClientWin:" + e.getMessage());
        }
    }

    public void goToCompanyWin(ActionEvent event) {
        try {
            Main.switchScene("fxml/CompanyWin");
        } catch (IOException e) {
            System.out.println("ERROR: MainController.goToCompanyWin:" + e.getMessage());
        }
    }

}