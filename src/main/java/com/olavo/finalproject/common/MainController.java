package com.olavo.finalproject.common;

import com.olavo.finalproject.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class MainController {

    @FXML
    private Button btnClient;

    @FXML
    private Button btnAdm;

    public void goToClientWin(ActionEvent event) {
        try {
            Main.switchScene("ClientLobbyWin", "MainWin");
        } catch (IOException e) {
            System.out.println("ERROR: MainController.goToClientWin:" + e.getMessage());
        }
    }

    public void goToAdmLoginWin(ActionEvent event) {
        try {
            Main.switchScene("AdmLoginWin", "MainWin");
        } catch (IOException e) {
            System.out.println("ERROR: MainController.goToCompanyWin:" + e.getCause());
        }
    }

}