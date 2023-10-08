package com.olavo.finalproject.client;

import com.olavo.finalproject.Main;
import com.olavo.finalproject.common.entity.EntityController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class ClientRegisterController extends EntityController {

    @FXML
    private ImageView btnBack;

    @FXML
    private Button btnCancel;

    @FXML
    private ImageView btnHome;

    @FXML
    private DatePicker dpDate;

    @FXML
    private TextField edtEmail;

    @FXML
    private TextField edtName;

    public void btnRegisterClick() {

    }

    public void btnCancelClick() {
        cancel();
    }

    private void cancel() {
        try {
            Main.switchScene("ClientLobby");
        } catch (IOException e) {
            System.out.println("ClientRegisterController.cancel: " + e.getMessage());
            System.out.println("Cause: " + e.getCause());
        }
    }

}
