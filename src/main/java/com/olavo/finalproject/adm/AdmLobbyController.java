package com.olavo.finalproject.adm;

import com.olavo.finalproject.Main;
import com.olavo.finalproject.common.entity.EntityController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class AdmLobbyController extends EntityController {

    @FXML
    private Button btnCompany;

    @FXML
    private Button btnGame;

    @FXML
    private Button btnGenre;

    public void goToCompanyWin(ActionEvent event) {
        try {
            Main.switchScene("CompanyWin", "AdmLobbyWin");
        } catch (IOException e) {
            System.out.println("Error: AdmLobbyController.goToCompanyWin: " + e.getMessage());
            e.getCause();
        }
    }

    public void goToGenreWin(ActionEvent event) {
        try {
            Main.switchScene("GenreWin", "AdmLobbyWin");
        } catch (IOException e) {
            System.out.println("Error: AdmLobbyController.goToGenreWin: " + e.getMessage());
            e.getCause();
        }
    }

    public void goToGameWin(ActionEvent event) {
        try {
            Main.switchScene("GameWin", "AdmLobbyWin");
        } catch (IOException e) {
            System.out.println("Error: AdmLobbyController.goToGameWin: " + e.getMessage());
            e.getCause();
        }
    }

}
