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
        ArrayList<AdmDTO> admList = new AdmDAO().findAll();
        if (!edtUser.getText().equals("") & !pswPass.getText().equals("")) {
            String user = edtUser.getText();
            int password = Integer.parseInt(pswPass.getText());
            for (AdmDTO admDTO : admList) {
                if (user.equals(admDTO.getUser()) && password == admDTO.getPassword()) {
                    try {
                        Main.switchScene("AdmLobbyWin", "AdmLoginWin");
                    } catch (IOException e) {
                        System.out.println("AdmController.goToAdmLobby: " + e.getMessage());
                        System.out.println("Cause: " + e.getCause());
                    }
                }
                else {
                    lblError.setText("Invalid User or Password!");
                    break;
                }
            }
        }
        else {
            lblError.setText("Invalid User or Password!");
        }
    }

}
