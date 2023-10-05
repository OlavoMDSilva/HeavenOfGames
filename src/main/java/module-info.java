module com.olavo.finalproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.olavo.finalproject to javafx.fxml;
    exports com.olavo.finalproject;
    exports com.olavo.finalproject.common;
    opens com.olavo.finalproject.common to javafx.fxml;
    exports com.olavo.finalproject.client;
    opens com.olavo.finalproject.client to javafx.fxml;
}