package lk.ijse.finalproject.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import lk.ijse.finalproject.bo.custom.BOFactory;
import lk.ijse.finalproject.bo.custom.BOTypes;
import lk.ijse.finalproject.bo.custom.QuotationBO;
import lk.ijse.finalproject.dto.QuotationDTO;
import lk.ijse.finalproject.util.Navigation;
import lk.ijse.finalproject.util.Routes;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Pattern;

public class QuotationFormController {
    public BorderPane brdPaneSupplierAccount;
    public Pane leftPane;
    public Circle userProfile;
    public Label lblUserName;
    public JFXButton btnHome;
    public JFXButton btnProfileSettings;
    public JFXButton btnViewNotes;
    public JFXButton btnViewStatics;
    public JFXButton btnLogout;
    public JFXButton btnHamburger;
    public JFXButton btnSaveQuotation;
    public Pane paneProfile;
    public JFXTextField txtCompanyName;
    public JFXTextField txtDescription;
    public JFXTextField txtQuantity;
    public JFXTextField txtStorekeeperId;
    public TextField txtSearch;
    public JFXComboBox cmbSupplierCategory;
    public JFXTextField txtSupplierId;
    public JFXTextField txtMaximumAmount;
    public JFXDatePicker dtCalledDate;
    public JFXDatePicker dtOpenedDate;
    public JFXTextField txtMeasuredUnits;
    public JFXButton btnEditQuotation;
    public JFXButton btnDelete;
    public JFXButton btnBack;
    public BorderPane brdPaneQuotation;
    public JFXTextField txtQuotationId;
    public ObservableList<String> obList = FXCollections.observableArrayList("Grocery","Stationary","Electronic Items");
    public JFXButton btnViewStatics1;

    private Pattern quotationIdPattern;

    QuotationBO quotationBOImpl = (QuotationBO) BOFactory.getBoFactory().getBO(BOTypes.QUOTATION);
    public void initialize(){
        cmbSupplierCategory.setItems(obList);

    }

    public void btnHomeOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STORE_DASHBOARD,brdPaneQuotation);
    }

    public void btnQuotationOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.QUOTATION,brdPaneQuotation);
    }

    public void btnSupplierDirectoryOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.SUPPLIER_DIRECTORY,brdPaneQuotation);
    }

    public void btnViewNotesOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STORE_NOTES,brdPaneQuotation);
    }

    public void btnViewStaticsOnAction(ActionEvent actionEvent) {
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Alert");
        alert.setContentText("Do you want to logout?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.equals(null)){
            Navigation.navigate(Routes.QUOTATION,brdPaneQuotation);
        } else if (result.get()==ButtonType.OK) {
            Navigation.navigate(Routes.LOGIN,brdPaneQuotation);
        } else if (result.get()==ButtonType.CANCEL) {
            Navigation.navigate(Routes.QUOTATION,brdPaneQuotation);
        }
    }

    public void btnInventoryOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.INVENTORY,brdPaneQuotation);
    }

    public void btnClickHamburgerOnAction(ActionEvent actionEvent) {
        throw new UnsupportedOperationException("Under Implementation");
    }

    public void btnSaveQuotationOnAction(ActionEvent actionEvent) {
        String quotationId=txtQuotationId.getText();
        quotationIdPattern = Pattern.compile("^[a-z]$");
        if (quotationIdPattern.matcher(quotationId).matches()) {
        }else {

            txtQuotationId.setFocusColor(Paint.valueOf("Red"));
            txtQuotationId.requestFocus();
        }

        String supplierCategory = String.valueOf(cmbSupplierCategory.getValue());
        String description = txtDescription.getText();
        double qty = Double.parseDouble(txtQuantity.getText());
        String measuredUnits = txtMeasuredUnits.getText();
        double maximumAmount = Double.parseDouble(txtMaximumAmount.getText());
        LocalDate calledDate = dtCalledDate.getValue();
        LocalDate openedDate = dtOpenedDate.getValue();
        String storekeeperId = txtStorekeeperId.getText();
        String supplierId = txtSupplierId.getText();
        QuotationDTO quotationDTO = new QuotationDTO(quotationId,supplierCategory,description,qty,measuredUnits,maximumAmount,calledDate,openedDate,storekeeperId,supplierId);
        try {
            boolean isAdded = quotationBOImpl.addQuotation(quotationDTO);
            if (isAdded){
                Notifications notifications = Notifications.create().text("Quotation Added Successfully").title("Add Quotation").position(Pos.CENTER_RIGHT).hideAfter(Duration.seconds(3));
                notifications.showInformation();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void txtSearchOnAction(ActionEvent actionEvent) {
        btnSearchOnAction(actionEvent);
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        String quotationId = txtSearch.getText();
        QuotationDTO quotationDTO ;
        try {
            quotationDTO = quotationBOImpl.searchQuotation(quotationId);
            if (quotationDTO != null) {
                fillData(quotationDTO);
                txtSearch.setText("");
            }else{
                Notifications notifications = Notifications.create().title(" Search Quotation").text("Not Found").hideAfter(Duration.seconds(3)).position(Pos.TOP_CENTER);
                notifications.show();
                txtQuotationId.setText("");
                cmbSupplierCategory.setValue("");
                txtDescription.setText("");
                txtQuantity.setText("");
                txtMeasuredUnits.setText("");
                txtMaximumAmount.setText("");
                dtCalledDate.setValue(null);
                dtOpenedDate.setValue(null);
                txtStorekeeperId.setText("");
                txtSupplierId.setText("");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void fillData(QuotationDTO quotationDTO) {
        txtQuotationId.setText(quotationDTO.getQuotationId());
        cmbSupplierCategory.setValue(quotationDTO.getSupplierCategory());
        txtDescription.setText(quotationDTO.getDescription());
        txtQuantity.setText(String.valueOf(quotationDTO.getQty()));
        txtMeasuredUnits.setText(quotationDTO.getMeasuredUnits());
        txtMaximumAmount.setText(String.valueOf(quotationDTO.getMaximumAmount()));
        dtCalledDate.setValue(quotationDTO.getCalledDate());
        dtOpenedDate.setValue(quotationDTO.getOpenedDate());
        txtStorekeeperId.setText(quotationDTO.getStorekeeperID());
        txtSupplierId.setText(quotationDTO.getSupplierID());
    }

    public void btnEditQuotationOnAction(ActionEvent actionEvent) {
        String quotationId=txtQuotationId.getText();
        txtQuotationId.setDisable(true);
        String supplierCategory = cmbSupplierCategory.getSelectionModel().getSelectedItem().toString();
        String description = txtDescription.getText();
        double qty = Double.parseDouble(txtQuantity.getText());
        String measuredUnits = txtMeasuredUnits.getText();
        double maximumAmount = Double.parseDouble(txtMaximumAmount.getText());
        LocalDate calledDate = dtCalledDate.getValue();
        LocalDate openedDate = dtOpenedDate.getValue();
        String storekeeperId = txtStorekeeperId.getText();
        String supplierId = txtSupplierId.getText();
        QuotationDTO quotationDTO = new QuotationDTO(quotationId,supplierCategory,description,qty,measuredUnits,maximumAmount,calledDate,openedDate,storekeeperId,supplierId);
        try {
            boolean isUpdated = quotationBOImpl.updateQuotation(quotationDTO);
            if (isUpdated){
                Notifications notifications = Notifications.create().text("Quotation Added Successfully").title("Add Quotation").position(Pos.CENTER_RIGHT).hideAfter(Duration.seconds(3));
                notifications.showInformation();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnDeleteQuotationOnAction(ActionEvent actionEvent) throws IOException {
        String id = txtQuotationId.getText();
        boolean isDeleted;

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Alert");
            alert.setContentText("Do you want to delete the record?");
            Optional <ButtonType> result = alert.showAndWait();
            if (result.equals(null)){

            } else if (result.get()==ButtonType.OK) {
                try {
                    isDeleted = quotationBOImpl.deleteQuotation(id);
                    if (isDeleted) {
                        Notifications notifications = Notifications.create().text("Quotation Details Deleted.").title("Quotation Delete ").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                        notifications.showInformation();
                    } else {
                        Notifications notifications = Notifications.create().text("Not Found.").title("Error").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                        notifications.showError();
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

            }else if (result.get()==ButtonType.CANCEL){

                    Navigation.navigate(Routes.QUOTATION,brdPaneQuotation);
                }
            }




    public void btnClearOnAction(ActionEvent actionEvent) {
        txtQuotationId.setText("");
        cmbSupplierCategory.setValue("");
        txtDescription.setText("");
        txtQuantity.setText("");
        txtMeasuredUnits.setText("");
        txtMaximumAmount.setText("");
        dtCalledDate.setValue(null);
        dtOpenedDate.setValue(null);
        txtStorekeeperId.setText("");
        txtSupplierId.setText("");
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STORE_NOTES,brdPaneQuotation);
    }

    public void btnPurchaseOrderOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PURCHASE_ORDER,brdPaneQuotation);
    }
}
