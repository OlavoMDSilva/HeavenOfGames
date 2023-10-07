package com.olavo.finalproject.adm;

import com.olavo.finalproject.Main;
import com.olavo.finalproject.common.entity.EntityController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class AdmController extends EntityController {

    @FXML
    private Button btnConfirm;

    public void goToAdmLobby(ActionEvent event) throws IOException {
//        if (getUser().equals("Adm1234") && getPassword() == 123454) {
//            Main.switchScene("AdmLobbyWin", "AdmLoginWin");
//        }
        Main.switchScene("AdmLobbyWin", "AdmLoginWin");
    }

}
