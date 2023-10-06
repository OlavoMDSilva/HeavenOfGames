module com.olavo.finalproject {
    requires javafx.controls;
    requires javafx.fxml;


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

}