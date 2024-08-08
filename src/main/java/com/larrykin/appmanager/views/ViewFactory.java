package com.larrykin.appmanager.views;

import com.larrykin.appmanager.enums.DashboardOptions;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;

public class ViewFactory {
    //? Initializing the ObjectProperty and the panes
    private final ObjectProperty dashboardSelectedItem;
    private ScrollPane tableviewScrollPane , settingsScrollPane, smsScrollPane, sendSMSScrollPane, dailingPlanScrollPane, blockGuardScrollPane, codecScrollPane, ussdApiScrollPane, ussdScrollPane, manageUsageScrollPane, blackAndWhiteListScrollPane;


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
    public ScrollPane getSendSMSScrollPane() {
        if (sendSMSScrollPane == null) {
            try {
                sendSMSScrollPane = new FXMLLoader(getClass().getResource("/fxml/sendSMS.fxml")).load();
            } catch (Exception e) {
                System.out.println("Error loading sendSMSAnchorPane"+e.getMessage());
                e.printStackTrace();
            }
        }
        return sendSMSScrollPane;
    }
    public ScrollPane getDailingPlanScrollPane() {
        if (dailingPlanScrollPane == null) {
            try {
                dailingPlanScrollPane = new FXMLLoader(getClass().getResource("/fxml/dailingPlan.fxml")).load();
            } catch (Exception e) {
                System.out.println("Error loading dailingPlanAnchorPane"+e.getMessage());
                e.printStackTrace();
            }
        }
        return dailingPlanScrollPane;
    }
    public ScrollPane getBlockGuardScrollPane() {
        if (blockGuardScrollPane == null) {
            try {
                blockGuardScrollPane = new FXMLLoader(getClass().getResource("/fxml/blockGuard.fxml")).load();
            } catch (Exception e) {
                System.out.println("Error loading blockGuardAnchorPane"+e.getMessage());
                e.printStackTrace();
            }
        }
        return blockGuardScrollPane;
    }
    public ScrollPane getCodecScrollPane() {
        if (codecScrollPane == null) {
            try {
                codecScrollPane = new FXMLLoader(getClass().getResource("/fxml/codec.fxml")).load();
            } catch (Exception e) {
                System.out.println("Error loading codecAnchorPane"+e.getMessage());
                e.printStackTrace();
            }
        }
        return codecScrollPane;
    }
    public ScrollPane getUssdApiScrollPane() {
        if (ussdApiScrollPane == null) {
            try {
                ussdApiScrollPane = new FXMLLoader(getClass().getResource("/fxml/ussdApi.fxml")).load();
            } catch (Exception e) {
                System.out.println("Error loading ussdApiAnchorPane"+e.getMessage());
                e.printStackTrace();
            }
        }
        return ussdApiScrollPane;
    }
    public ScrollPane getUssdScrollPane() {
        if (ussdScrollPane == null) {
            try {
                ussdScrollPane = new FXMLLoader(getClass().getResource("/fxml/manualUSSD.fxml")).load();
            } catch (Exception e) {
                System.out.println("Error loading ussdAnchorPane"+e.getMessage());
                e.printStackTrace();
            }
        }
        return ussdScrollPane;
    }
    public ScrollPane getManageUsageScrollPane() {
        if (manageUsageScrollPane == null) {
            try {
                manageUsageScrollPane = new FXMLLoader(getClass().getResource("/fxml/manageUsage.fxml")).load();
            } catch (Exception e) {
                System.out.println("Error loading manageUsageAnchorPane"+e.getMessage());
                e.printStackTrace();
            }
        }
        return manageUsageScrollPane;
    }
    public ScrollPane getBlackAndWhiteListScrollPane() {
        if (blackAndWhiteListScrollPane == null) {
            try {
                blackAndWhiteListScrollPane = new FXMLLoader(getClass().getResource("/fxml/blackAndWhiteList.fxml")).load();
            } catch (Exception e) {
                System.out.println("Error loading blackAndWhiteListAnchorPane"+e.getMessage());
                e.printStackTrace();
            }
        }
        return blackAndWhiteListScrollPane;
    }
}
