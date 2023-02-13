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
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import lk.ijse.finalproject.bo.custom.BOFactory;
import lk.ijse.finalproject.bo.custom.BOTypes;
import lk.ijse.finalproject.bo.custom.PurchaseOrderBO;
import lk.ijse.finalproject.bo.custom.StockBO;
import lk.ijse.finalproject.dto.PurchaseOrderDTO;
import lk.ijse.finalproject.dto.StockDTO;
import lk.ijse.finalproject.util.Navigation;
import lk.ijse.finalproject.util.Routes;
import org.controlsfx.control.Notifications;

import javax.management.Notification;
import javax.swing.text.html.Option;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class PurchaseOrderFormController {
    public BorderPane brdPanePO;
    public Pane leftPane;
    public Circle userProfile;
    public Label lblUserName;
    public JFXButton btnHome;
    public JFXButton btnQuotation;
    public JFXButton btnViewNotes;
    public JFXButton btnViewStatics;
    public JFXButton btnLogout;
    public JFXButton btnHamburger;
    public Pane paneProfile;
    public JFXTextField txtPurchaseOrderId;
    public JFXTextField txtUnitRate;
    public TextField txtSearch;
    public JFXComboBox cmbMeasuredUnits;
    public JFXTextField txtSupplierId;
    public JFXDatePicker dtOrderDate;
    public JFXDatePicker dtDeliverBefore;
    public JFXTextField txtQty;
    public JFXTextField txtStorekeeperId;
    public JFXComboBox cmbProductCategory;
    public JFXComboBox cmbProductId;
    public JFXComboBox cmbProductName;
    public JFXButton btnDelete;
    public ObservableList<String> obList = FXCollections.observableArrayList("Grocery","Stationary","Electronic Items");
    public ObservableList<String> measureList = FXCollections.observableArrayList("NOS","Liters","Meters","Packets");
    public JFXTextField txtProductCategory;
    public JFXTextField txtProductName;
    public JFXTextField txtMeasuredUnits;
    public Label lblPurchaseOrderId;
    PurchaseOrderBO purchaseOrderBOImpl = (PurchaseOrderBO) BOFactory.getBoFactory().getBO(BOTypes.PURCHASE_ORDER);
    StockBO stockBOImpl = (StockBO) BOFactory.getBoFactory().getBO(BOTypes.STOCK);

    public void initialize(){
        loadProductIds();
        loadNextPurchaseOrderId();

    }

    private void loadNextPurchaseOrderId() {
        try {
            String orderId = purchaseOrderBOImpl.generateNextPurchaseOrderId();
            lblPurchaseOrderId.setText(orderId);
        } catch (SQLException e) {
            Notifications notifications = Notifications.create().text("Duplicate Order ID").title("Error").position(Pos.CENTER).hideAfter(Duration.seconds(3));
            notifications.showError();
        }catch (ClassNotFoundException e){
            Notifications notifications = Notifications.create().text("Class Not Found Exception").title("Error").position(Pos.CENTER).hideAfter(Duration.seconds(3));
            notifications.showError();
        }
    }

    private void loadProductIds() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> idList = purchaseOrderBOImpl.loadProductIdsEligibleForPO();

            for (String id : idList) {
                observableList.add(id);
            }
            cmbProductId.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnHomeOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STORE_DASHBOARD,brdPanePO);
    }

    public void btnQuotationOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.QUOTATION,brdPanePO);
    }

    public void btnSupplierDirectoryOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.SUPPLIER_DIRECTORY,brdPanePO);
    }

    public void btnViewNotesOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STORE_NOTES,brdPanePO);
    }

    public void btnViewStaticsOnAction(ActionEvent actionEvent) {
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Are You Sure");
        alert.setContentText("you want to logout?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.equals(null)){
            Navigation.navigate(Routes.PURCHASE_ORDER,brdPanePO);
        } else if (result.get()==ButtonType.OK) {
            Navigation.navigate(Routes.LOGIN,brdPanePO);
        } else if (result.get()==ButtonType.CANCEL) {
            Navigation.navigate(Routes.PURCHASE_ORDER,brdPanePO);
        }
    }

    public void btnInventoryOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STORE_DASHBOARD,brdPanePO);
    }

    public void btnClickHamburgerOnAction(ActionEvent actionEvent) {
    }

    public void btnSavePOOnAction(ActionEvent actionEvent) {
        String purchaseOrderId = lblPurchaseOrderId.getText();
        String productCategory = txtProductCategory.getText();
        String productId = cmbProductId.getSelectionModel().getSelectedItem().toString();
        String productName = txtProductName.getText();
        String measuredUnits = txtMeasuredUnits.getText();
        double qty = Double.parseDouble(txtQty.getText());
        double unitRate = Double.parseDouble(txtUnitRate.getText());
        LocalDate orderDate = dtOrderDate.getValue();
        LocalDate deliverBefore = dtDeliverBefore.getValue();
        String supplierId = txtSupplierId.getText();
        String storekeeperId = txtStorekeeperId.getText();

        PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO(purchaseOrderId,productCategory,productId,productName,measuredUnits,qty,unitRate,orderDate,deliverBefore,supplierId,storekeeperId);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Are you sure");
        alert.setContentText("you want to save this?");
        Optional <ButtonType> result = alert.showAndWait();
        try {
            boolean isAdded = purchaseOrderBOImpl.addPurchaseOrder(purchaseOrderDTO);
            if (result.equals(null)){
                Navigation.navigate(Routes.PURCHASE_ORDER,brdPanePO);
            } else if (result.get()==ButtonType.OK) {
                if (isAdded) {
                    Notifications notifications = Notifications.create().text("PO Added Successfully").title("PO").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                    notifications.showConfirm();
                    loadNextPurchaseOrderId();
                }
            } else if (result.get()==ButtonType.CANCEL) {
                Navigation.navigate(Routes.PURCHASE_ORDER,brdPanePO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void txtSearchOnAction(ActionEvent actionEvent) {
        btnSearchOnAction(actionEvent);
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        String purchaseOrderId = txtSearch.getText();
        try {
            PurchaseOrderDTO purchaseOrderDTO = purchaseOrderBOImpl.searchPurchaseOrder(purchaseOrderId);
            if (purchaseOrderId!= null){
                fillPurchaseOrderFormFields(purchaseOrderDTO);
                txtSearch.setText("");
            }else{
                lblPurchaseOrderId.setText("");
                cmbProductId.setValue("");
                txtProductCategory.setText("");
                txtProductName.setText("");
                txtMeasuredUnits.setText("");
                txtQty.setText("");
                txtUnitRate.setText("");
                dtOrderDate.setValue(null);
                dtDeliverBefore.setValue(null);
                txtStorekeeperId.setText("");
                txtSupplierId.setText("");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void fillPurchaseOrderFormFields(PurchaseOrderDTO purchaseOrderDTO) {
        lblPurchaseOrderId.setText(purchaseOrderDTO.getPurchaseOrderId());
        cmbProductId.setValue(purchaseOrderDTO.getProductID());
        txtProductCategory.setText(purchaseOrderDTO.getPurchaseCategory());
        txtProductName.setText(purchaseOrderDTO.getProductName());
        txtMeasuredUnits.setText(purchaseOrderDTO.getMeasuredUnits());
        txtQty.setText(String.valueOf(purchaseOrderDTO.getQty()));
        txtUnitRate.setText(String.valueOf(purchaseOrderDTO.getUnitRate()));
        dtOrderDate.setValue(purchaseOrderDTO.getOrderDate());
        dtDeliverBefore.setValue(purchaseOrderDTO.getDeliverBefore());
        txtStorekeeperId.setText(purchaseOrderDTO.getStoreKeeperID());
        txtSupplierId.setText(purchaseOrderDTO.getSupplierID());
    }


    public void btnEditPOOnAction(ActionEvent actionEvent) {
        String pOId = lblPurchaseOrderId.getText();
        String productCategory = txtProductCategory.getText();
        String productId = cmbProductId.getSelectionModel().getSelectedItem().toString();
        String productName = txtProductName.getText();
        String measuredUnits = txtMeasuredUnits.getText();
        double qty = Double.parseDouble(txtQty.getText());
        double unitRate = Double.parseDouble(txtUnitRate.getText());
        LocalDate orderDate = dtOrderDate.getValue();
        LocalDate deliverBefore = dtDeliverBefore.getValue();
        String supplierId = txtSupplierId.getText();
        String storekeeperId = txtStorekeeperId.getText();

        PurchaseOrderDTO purchaseOrderDTO1 = new PurchaseOrderDTO(pOId,productCategory,productId,productName,measuredUnits,qty,unitRate,orderDate,deliverBefore,supplierId,storekeeperId);
        boolean isUpdated=false;
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Alert");
            alert.setContentText("Are you sure you want to update detail?");
            Optional <ButtonType> result = alert.showAndWait();
            if (result.get()==null){

            }else if (result.get()==ButtonType.OK) {
                isUpdated = purchaseOrderBOImpl.updatePurchaseOrder(purchaseOrderDTO1);
                if (isUpdated) {
                    Notifications notifications = Notifications.create().text("PO Details Updated.").title("Update ").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                    notifications.showInformation();
                }
            }else {
                Notifications notifications = Notifications.create().text("PO Details Not Updated.").title("Error ").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                notifications.showInformation();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void btnDeletePOOnAction(ActionEvent actionEvent) throws IOException {
        String id = txtSearch.getText();
        boolean isDeleted;
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Alert");
            alert.setContentText("Are you sure you want to delete PO "+id);
            Optional <ButtonType> result = alert.showAndWait();
            if (result.get()==null){

            }else if (result.get()==ButtonType.OK){
                isDeleted = purchaseOrderBOImpl.deletePurchaseOrder(id);
                if (isDeleted) {
                    Notifications notifications = Notifications.create().text("PO Details Deleted.").title("Delete ").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                    notifications.showInformation();
                } else {
                    Notifications notifications = Notifications.create().text("PO Not Found.").title("Error").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                    notifications.showError();
                }
            } else if (result.get()==ButtonType.CANCEL) {
               Navigation.navigate(Routes.PURCHASE_ORDER,brdPanePO);
            }

        } catch (ClassNotFoundException e) {
            Notifications notifications = Notifications.create().text("Driver Not Found.").title("ClassNotFound Exception").position(Pos.CENTER).hideAfter(Duration.seconds(3));
            notifications.showError();

        } catch (SQLException e) {
            Notifications notifications = Notifications.create().text("Supplier Not Identified").title("Warning").position(Pos.CENTER).hideAfter(Duration.seconds(3));
            notifications.showError();

        }
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        loadNextPurchaseOrderId();
        cmbProductId.setValue("SELECT ITEM");
        txtProductCategory.setText("");
        txtProductName.setText("");
        txtMeasuredUnits.setText("");
        txtQty.setText("");
        txtUnitRate.setText("");
        dtOrderDate.setValue(null);
        dtDeliverBefore.setValue(null);
        txtStorekeeperId.setText("");
        txtSupplierId.setText("");
        txtSearch.setText("");
    }

    public void cmbProductIDSelectOnAction(ActionEvent actionEvent) {
        String code = String.valueOf(cmbProductId.getValue());
        if (code.equals("SELECT ITEM")) {
            txtProductName.setText("");
            txtMeasuredUnits.setText("");
            txtProductCategory.setText("");
        }else{

            try {
                StockDTO stockAtStore = stockBOImpl.searchStockDetails(code);
                fillItemFields(stockAtStore);
                txtQty.requestFocus();
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void fillItemFields(StockDTO stockAtStore) {
        txtProductName.setText(stockAtStore.getItemDescription());
        txtMeasuredUnits.setText(stockAtStore.getMeasuredUnits());
        txtProductCategory.setText(stockAtStore.getCategory());
    }
}
