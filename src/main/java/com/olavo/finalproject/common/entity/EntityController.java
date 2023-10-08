package com.olavo.finalproject.common.entity;

import com.olavo.finalproject.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class EntityController {

    @FXML
    protected ImageView btnHome;

    @FXML
    protected ImageView btnBack;

    @FXML
    protected Button btnRegister;

    @FXML
    protected Button btnUpdate;

    @FXML
    protected Button btnDelete;

    @FXML
    protected TextField edtUser;

    @FXML
    protected PasswordField pswPass;

    @FXML
    public void goBack(MouseEvent event) throws IOException {
        Main.switchScene(Main.fxmlList.get(Main.fxmlList.size() - 1));
        Main.fxmlList.remove(Main.fxmlList.size() - 1);
    }

    @FXML
    public void goHome(MouseEvent event) throws IOException {
        Main.switchScene("MainWin");
    }

    protected String getUser() {
        return edtUser.getText();
    }

    protected int getPassword() {
        return Integer.parseInt(pswPass.getText());
    }

}
