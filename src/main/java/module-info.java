module com.larrykin.appmanager {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.larrykin.appmanager.controllers to javafx.fxml;
    exports com.larrykin.appmanager;
    exports com.larrykin.appmanager.controllers to javafx.fxml;
}