package com.olavo.finalproject.client;

import com.olavo.finalproject.Main;
import com.olavo.finalproject.common.entity.EntityController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.ArrayList;

public class ClientLoginController extends EntityController {

    @FXML
    private Label lblError;

    @FXML
    private Button btnConfirm;

    @FXML
    private Button btnCancel;

    public void btnConfirmClick(ActionEvent event) {
        if (checkClient()) {
            try {
                Main.switchScene("StoreWin", "ClientLoginWin");
            } catch (IOException e) {
                System.out.println("ClientLoginController.btnConfirmClick: " + e.getMessage());
                System.out.println("Cause: " + e.getCause());
            }
        }
        else lblError.setText("Invalid User or Password!");
    }

    public void btnCancelClick(ActionEvent event) {
        try {
            Main.switchScene("ClientLobbyWin");
        } catch (IOException e) {
            System.out.println("ClientLoginController.btnCancelClick: " + e.getMessage());
            System.out.println("Cause: " + e.getCause());
        }
    }

    private boolean checkClient() {
        ArrayList<ClientDTO> clientList = new ClientDAO().findAll();
        String user = edtUser.getText();
        String password = pswPass.getText();
        if (!user.equals("") && !password.equals("")) {
            for (ClientDTO clientDTO : clientList) {
                String clientUser = clientDTO.getUser();
                String clientPass = Integer.toString(clientDTO.getPassword());

                if (clientUser.equals(user) && clientPass.equals(password)) return true;
            }
        }
        return false;
    }

}
