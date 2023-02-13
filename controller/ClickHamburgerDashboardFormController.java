package lk.ijse.finalproject.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import lk.ijse.finalproject.util.Navigation;
import lk.ijse.finalproject.util.Routes;

import java.io.IOException;

public class ClickHamburgerDashboardFormController {

    public BorderPane paneClickedHamburger;
    @FXML
    private BorderPane brdrPaneRegisterEmployee;

    @FXML
    private Pane leftPane;

    @FXML
    private Circle userProfile;

    @FXML
    private Label lblUserName;

    @FXML
    private JFXButton btnHome;

    @FXML
    private JFXButton btnProfileSettings;

    @FXML
    private JFXButton btnRegisterEmployee;

    @FXML
    private JFXButton btnViewNotes;

    @FXML
    private JFXButton btnViewStatics;

    @FXML
    private JFXButton btnLogout;

    @FXML
    private Pane paneEmployee;

    @FXML
    private Pane paneSales;

    @FXML
    private Label lblTotalSales;

    @FXML
    private Pane paneTopSelling;

    @FXML
    private Pane paneTrend;

    @FXML
    private Label lblTrend1;

    @FXML
    private Label lblPrice1;

    @FXML
    private Pane paneTrend1;

    @FXML
    private Label lblTrend2;

    @FXML
    private Label lblPrice12;

    @FXML
    private Pane paneTrend2;

    @FXML
    private Label lblTrend3;

    @FXML
    private Label lblPrice3;

    @FXML
    private Pane paneTrend3;

    @FXML
    private Label lblTrend4;

    @FXML
    private Label lblPrice4;

    @FXML
    private Pane paneIncomeVariation;

    @FXML
    private Pane paneCustomer;

    @FXML
    private Label lblCustomers;

    @FXML
    private Pane paneTotalSales;

    @FXML
    private Pane pane;

    @FXML
    private JFXButton btnClickHamburger;

    @FXML
    private Pane paneSearchBar1;

    @FXML
    private ComboBox<?> cmbFilter;

    @FXML
    void btnClickHamburgerOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.CLICKED_HAMBURGER, paneClickedHamburger);
    }

    @FXML
    void btnHomeOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.CLICK_DASHBOARD,paneClickedHamburger);
    }


    @FXML
    void btnLogoutOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.CLICK_LOGOUT,paneClickedHamburger);
    }

    @FXML
    void btnProfileSettingsOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.CLICK_PROFILE_SETTINGS,paneClickedHamburger);
    }

    @FXML
    void btnRegisterEmployeeOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.CLICK_MANAGE_EMPLOYEE,paneClickedHamburger);

    }

    @FXML
    void btnViewNotesOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.CLICK_VIEW_NOTES,paneClickedHamburger);
    }

    @FXML
    void btnViewStaticsOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.CLICK_VIEW_STATISTICS,paneClickedHamburger);
    }
}
