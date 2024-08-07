package com.larrykin.appmanager.views;

import com.larrykin.appmanager.enums.DashboardOptions;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

public class ViewFactory {
    //? Initializing the ObjectProperty and the panes
    private final ObjectProperty dashboardSelectedItem;
    private ScrollPane tableviewScrollPane , settingsScrollPane, smsScrollPane;


    //?constructor
    public ViewFactory() {
        this.dashboardSelectedItem = new SimpleObjectProperty();
    }

    //!  DASHBOARD SECTION
    //?getting the DASHBOARD selected item
    public ObjectProperty<DashboardOptions> getDashboardSelectedItem() {
        return dashboardSelectedItem;
    }

    //? getting DASHBOARD resources
    public ScrollPane getTableviewScrollPane() {
        if (tableviewScrollPane == null) {
            try {
                tableviewScrollPane = new FXMLLoader(getClass().getResource("/fxml/tableview.fxml")).load();
            } catch (Exception e) {
                System.out.println("Error loading tableview"+e.getMessage());
                e.printStackTrace();
            }
        }
        return tableviewScrollPane;
    }
    public ScrollPane getSettingsScrollPane() {
        if (settingsScrollPane == null) {
            try {
                settingsScrollPane = new FXMLLoader(getClass().getResource("/fxml/settings.fxml")).load();
            } catch (Exception e) {
                System.out.println("Error loading settingsAnchorPane"+e.getMessage());
                e.printStackTrace();
            }
        }
        return settingsScrollPane;
    }
    public ScrollPane getSmsScrollPane() {
        if (smsScrollPane == null) {
            try {
                smsScrollPane = new FXMLLoader(getClass().getResource("/fxml/sms.fxml")).load();
            } catch (Exception e) {
                System.out.println("Error loading smsAnchorPane"+e.getMessage());
                e.printStackTrace();
            }
        }
        return smsScrollPane;
    }


}
