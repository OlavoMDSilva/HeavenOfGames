module com.olavo.finalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    exports com.olavo.finalproject;
    opens com.olavo.finalproject to javafx.fxml;
    exports com.olavo.finalproject.adm;
    opens com.olavo.finalproject.adm to javafx.fxml;
    exports com.olavo.finalproject.client;
    opens com.olavo.finalproject.client to javafx.fxml;
    exports com.olavo.finalproject.common.entity;
    opens com.olavo.finalproject.common.entity to javafx.fxml;
    exports com.olavo.finalproject.common;
    opens com.olavo.finalproject.common to javafx.fxml;
    exports com.olavo.finalproject.company;
    opens com.olavo.finalproject.company to javafx.fxml;
    exports com.olavo.finalproject.game;
    opens com.olavo.finalproject.game to javafx.fxml;
    exports com.olavo.finalproject.genre;
    opens com.olavo.finalproject.genre to javafx.fxml;
    exports com.olavo.finalproject.store;
    opens com.olavo.finalproject.store to javafx.fxml;

}