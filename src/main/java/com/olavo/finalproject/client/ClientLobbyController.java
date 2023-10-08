package com.olavo.finalproject.client;

import com.olavo.finalproject.Main;
import com.olavo.finalproject.common.entity.EntityController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class ClientLobbyController extends EntityController {

    @FXML
    private Button btnSignIn;

    @FXML
    private Button btnSignUp;

    @FXML
    private Button btnAccount;

    public void btnSignInClick(ActionEvent event) {
        try {
            Main.switchScene("ClientLoginWin", "ClientLobbyWin");
        } catch (IOException e) {
            System.out.println("ClientLobbyController.btnSignInClick: " + e.getMessage());
            System.out.println("Cause: " + e.getCause());
        }
    }

    public void btnSignUpClick(ActionEvent event) {
        try {
            Main.switchScene("ClientRegisterWin", "ClientLobbyWin");
        } catch (IOException e) {
            System.out.println("ClientLobbyController.btnSignUpClick: " + e.getMessage());
            System.out.println("Cause: " + e.getCause());
        }
    }

    public void btnAccountClick(ActionEvent event) {
        try {
            Main.switchScene("ClientDeleteWin", "ClientLobbyWin");
        } catch (IOException e) {
            System.out.println("ClientLobbyController.btnAccountClick: " + e.getMessage());
            System.out.println("Cause: " + e.getCause());
        }
    }

}
