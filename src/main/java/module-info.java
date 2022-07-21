module com.upchiapas.lillia {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.upchiapas.lillia to javafx.fxml;
    exports com.upchiapas.lillia;
    exports com.upchiapas.lillia.controllers;
    opens com.upchiapas.lillia.controllers to javafx.fxml;
}