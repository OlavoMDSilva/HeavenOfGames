package com.olavo.finalproject.adm;

import com.olavo.finalproject.Main;
import com.olavo.finalproject.common.entity.EntityController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.ArrayList;

public class AdmController extends EntityController {

    @FXML
    private Label lblError;

    @FXML
    private Button btnConfirm;

    public void goToAdmLobby(ActionEvent event) {
        if (checkAdm()) {
            try {
                Main.switchScene("AdmLobbyWin", "AdmLoginWin");
            } catch (IOException e) {
                System.out.println("AdmController.goToAdmLobby: " + e.getMessage());
                System.out.println("Cause: " + e.getCause());
            }
        }
        else lblError.setText("Invalid User or Password!");
    }

    private boolean checkAdm() {
        ArrayList<AdmDTO> admList = new AdmDAO().findAll();
        String user = edtUser.getText();
        String password = pswPass.getText();
        if (!user.equals("") && !password.equals("")) {
            for (AdmDTO admDTO : admList) {
                String admPass = Integer.toString(admDTO.getPassword());
                String admUser = admDTO.getUser();

                if (user.equals(admUser) && password.equals(admPass)) return true;
            }
        }
        return false;
    }

}
