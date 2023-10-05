package com.olavo.finalproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    private static Stage stage;

    public static void switchScene(String fxml) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource(fxml + ".fxml")));
        Scene scene = new Scene(root);
        Main.stage.setScene(scene);
    }

    @Override
    public void start(Stage stage) throws IOException {
        Main.stage = stage;
        switchScene("fxml/MainWin");
        Main.stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}