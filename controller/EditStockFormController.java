package lk.ijse.finalproject.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import lk.ijse.finalproject.util.Navigation;
import lk.ijse.finalproject.util.Routes;

import java.io.IOException;

public class EditStockFormController {

    public JFXButton btnProfileSettings1;
    @FXML
    private BorderPane brdrPaneAddNewStock;

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
    private JFXButton btnSupplierDirectory;

    @FXML
    private JFXButton btnViewNotes;

    @FXML
    private JFXButton btnViewStatics;

    @FXML
    private JFXButton btnLogout;

    @FXML
    private JFXButton btnInventory;

    @FXML
    private JFXButton btnHamburger;

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXTextField txtStockCode;

    @FXML
    private JFXTextField txtItemDescription;

    @FXML
    private JFXTextField txtQtyOnHand;

    @FXML
    private JFXTextField txtUnitRate;

    @FXML
    private JFXButton btnEnter;

    @FXML
    private JFXComboBox<?> cmbCategory;

    @FXML
    private JFXComboBox<?> cmbSubCategory;

    @FXML
    private JFXComboBox<?> cmbMeasuredUnits;

    @FXML
    private JFXComboBox<?> cmbBrandName;

    @FXML
    void BtnSupplierDirectoryOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.SUPPLIER_DIRECTORY,brdrPaneAddNewStock);
    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.INVENTORY,brdrPaneAddNewStock);

    }

    @FXML
    void btnClickHamburgerOnAction(ActionEvent event) {

    }

    @FXML
    void btnEnterOnAction(ActionEvent event) {

    }

    @FXML
    void btnHomeOnAction(ActionEvent event) throws IOException {
       Navigation.navigate(Routes.STORE_DASHBOARD,brdrPaneAddNewStock);
    }

    @FXML
    void btnInventoryOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.INVENTORY,brdrPaneAddNewStock);
    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) {

    }

    @FXML
    void btnProfileSettingsOnAction(ActionEvent event) {

    }

    @FXML
    void btnViewNotesOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.STORE_NOTES,brdrPaneAddNewStock);
    }

    @FXML
    void btnViewStaticsOnAction(ActionEvent event) throws IOException {


    }

    public void btnQuotationOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.QUOTATION,brdrPaneAddNewStock);
    }

    public void btnPurchaseOrderOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PURCHASE_ORDER,brdrPaneAddNewStock);
    }
}
