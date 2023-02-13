package lk.ijse.finalproject.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import lk.ijse.finalproject.util.Navigation;
import lk.ijse.finalproject.util.Routes;

import java.io.IOException;

public class ClickHamburgerManageEmployeeFormController {
    public JFXButton btnClickHome;
    public JFXButton btnClickProfileSettings;
    public JFXButton btnClickRegisterEmployee;
    public JFXButton btnClickViewNotes;
    public JFXButton btnClickViewStatics;
    public JFXButton btnClickHamburger;
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
    private JFXButton btnHamburger;

    @FXML
    private Pane paneSearchBar1;

    @FXML
    private JFXButton btnAddEmployee;

    @FXML
    private JFXButton btnReduce;

    @FXML
    private JFXButton btnIncrease;

    @FXML
    private TextField txtRecordPerPage;

    @FXML
    void btnAddEmployeeOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.ADD_EMPLOYEE,brdrPaneRegisterEmployee);
    }


    @FXML
    void btnIncreaseOnAction(ActionEvent event) {

    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.CLICK_LOGOUT,brdrPaneRegisterEmployee);
    }


    @FXML
    void btnReduceOnAction(ActionEvent event) {

    }

    @FXML
    void txtRecordPerAction(ActionEvent event) {

    }

    public void btnClickHomeOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CLICK_DASHBOARD,brdrPaneRegisterEmployee);
    }

    public void btnClickProfileSettingsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CLICK_PROFILE_SETTINGS,brdrPaneRegisterEmployee);
    }

    public void btnClickRegisterEmployeeOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CLICK_MANAGE_EMPLOYEE,brdrPaneRegisterEmployee);
    }

    public void btnClickViewNotesOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CLICK_VIEW_NOTES,brdrPaneRegisterEmployee);
    }

    public void btnClickViewStaticsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CLICK_VIEW_STATISTICS,brdrPaneRegisterEmployee);
    }

    public void btnClicHamburgerOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.HAM_MANAGE_EMPLOYEE,brdrPaneRegisterEmployee);
    }
}
