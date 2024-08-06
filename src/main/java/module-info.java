module com.larrykin.callandsmsmanagementsoftwaredevelopment {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.larrykin.appmanager to javafx.fxml;
    exports com.larrykin.appmanager;
}