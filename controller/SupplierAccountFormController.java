package lk.ijse.finalproject.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import lk.ijse.finalproject.bo.custom.BOFactory;
import lk.ijse.finalproject.bo.custom.BOTypes;
import lk.ijse.finalproject.bo.custom.SupplierBO;
import lk.ijse.finalproject.dao.custom.SupplierDAO;
import lk.ijse.finalproject.dao.custom.impl.SupplierDAOImpl;
import lk.ijse.finalproject.dto.SupplierDTO;
import lk.ijse.finalproject.entity.Supplier;
import lk.ijse.finalproject.util.Navigation;
import lk.ijse.finalproject.util.Routes;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierAccountFormController {
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
    public JFXButton btnSaveSupplier;
    public Pane paneProfile;
    public JFXTextField txtCompanyName;
    public JFXTextField txtSupplierID;
    public JFXTextField txtAddress;
    public JFXTextField txtEmail;
    public JFXTextField txtContactNumber;
    public JFXTextField txtContactPerson;
    public JFXButton btnBack;
    public TextField txtSearch;
    public JFXComboBox cmbSupplierCategory;
    public JFXTextField txtSupplierSubCategory;
    public JFXTextField txtBrandName;
    public JFXButton btnEditSupplier;
    public JFXButton btnDelete;
    public JFXTextField txtProductID;
    public ObservableList <String> obList = FXCollections.observableArrayList("Grocery","Stationary","Electronic Items");

    SupplierDTO supplier;
    ArrayList<SupplierDTO> supplierList = new ArrayList<>();
    SupplierBO supplierBOImpl = (SupplierBO) BOFactory.getBoFactory().getBO(BOTypes.SUPPLIER);

    public void initialize() {
        cmbSupplierCategory.setItems(obList);
     //   getData();
    }

    public ArrayList<SupplierDTO> getData()  {
        ArrayList <SupplierDTO> supplierArrayList = null;
        try {
            supplierArrayList = supplierBOImpl.selectAllSuppliers();
            SupplierDTO supplierDTO= new SupplierDTO();
            for (SupplierDTO supplier: supplierArrayList){
                //System.out.println(supplierArrayList);
                supplier.setContactPerson(supplier.getContactPerson());
               // System.out.println(supplier.getSupplierId());
                supplier.setSupplierId(supplier.getSupplierId());
                supplier.setCompanyName(supplier.getCompanyName());
                supplier.setEmail(supplier.getEmail());
                supplier.setContactNo(supplier.getContactNo());
                supplier.setAddress(supplier.getAddress());
                supplierList.add(supplier);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return supplierList;



    }

    public void btnHomeOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STORE_DASHBOARD,brdPaneSupplierAccount);
    }

    public void btnProfileSettingsOnAction(ActionEvent actionEvent) {
    }

    public void btnSupplierDirectoryOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.SUPPLIER_DIRECTORY,brdPaneSupplierAccount);
    }

    public void btnViewNotesOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STORE_NOTES,brdPaneSupplierAccount);
    }

    public void btnViewStaticsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STORE_STATISTICS,brdPaneSupplierAccount);
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) {
    }

    public void btnInventoryOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.INVENTORY,brdPaneSupplierAccount);
    }

    public void btnClickHamburgerOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.HAM_SUPPLIER,brdPaneSupplierAccount);
    }

    public void btnSaveSupplierOnAction(ActionEvent actionEvent) {
        String supplierId = txtSupplierID.getText();
        String name = txtCompanyName.getText();
        String address = txtAddress.getText();
        String email = txtEmail.getText();
        String contactNo = txtContactNumber.getText();
        String contactPerson =txtContactPerson.getText();
        String supplierCategory = cmbSupplierCategory.getSelectionModel().getSelectedItem().toString();
        String subCategory = txtSupplierSubCategory.getText();
        String brandName = txtBrandName.getText();
        String productId = txtProductID.getText();


        supplier = new SupplierDTO(supplierId,name,address,email,contactNo,contactPerson,supplierCategory,subCategory,brandName,productId);

        try {
            boolean isAdded = supplierBOImpl.addSupplier(supplier);

            if (isAdded) {
                Notifications notifications = Notifications.create().text("Supplier Added Successfuly").title("Add Supplier").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                notifications.showInformation();
                getData();

            } else {
                Notifications notifications = Notifications.create().text("Supplier Not Added.").title("Saving Error").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                notifications.showInformation();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.SUPPLIER_DIRECTORY,brdPaneSupplierAccount);
    }

    public void txtSearchOnAction(ActionEvent actionEvent) {
        btnSearchOnAction(actionEvent);
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        String id = txtSearch.getText();
        SupplierDTO supplier;
        try {
            supplier = supplierBOImpl.searchSupplier(id);
            if (supplier != null) {
                fillData(supplier);
                txtSearch.setText("");
            } else {
                Notifications notifications = Notifications.create().title(" Search Supplier").text("Supplier Not Found").hideAfter(Duration.seconds(3)).position(Pos.TOP_CENTER);
                notifications.show();
                txtSupplierID.setText("");
                txtCompanyName.setText("");
                txtAddress.setText("");
                txtEmail.setText("");
                txtContactNumber.setText("");
                txtContactPerson.setText("");
                cmbSupplierCategory.setValue(null);
                txtSupplierSubCategory.setText("");
                txtBrandName.setText("");
                txtProductID.setText("");
            }

        } catch (SQLException e) {
            Notifications notifications = Notifications.create().title("Error").text("Duplicate Entry or Character Length Exceeded").hideAfter(Duration.seconds(3)).position(Pos.TOP_CENTER);
            notifications.showError();
        } catch (ClassNotFoundException e) {
            Notifications notifications = Notifications.create().title("Error").text("Driver Not Found").hideAfter(Duration.seconds(3)).position(Pos.TOP_CENTER);
            notifications.showError();

        }
    }

        private void fillData(SupplierDTO supplier) {
            txtSupplierID.setText(supplier.getSupplierId());
            txtCompanyName.setText(supplier.getCompanyName());
            txtAddress.setText(supplier.getAddress());
            txtEmail.setText(supplier.getEmail());
            txtContactNumber.setText(supplier.getContactNo());
            txtContactPerson.setText(supplier.getContactPerson());
            cmbSupplierCategory.setValue(supplier.getSupplierSubCategory());
            txtSupplierSubCategory.setText(supplier.getSupplierSubCategory());
            txtBrandName.setText(supplier.getBrandName());
            txtProductID.setText(supplier.getSupplierId());
        }

        public void btnEditSupplierOnAction(ActionEvent actionEvent) {
            String supplierId = txtSupplierID.getText();
            String name = txtCompanyName.getText();
            String address = txtAddress.getText();
            String email = txtEmail.getText();
            String contactNo = txtContactNumber.getText();
            String contactPerson =txtContactPerson.getText();
            String supplierCategory = cmbSupplierCategory.getSelectionModel().getSelectedItem().toString();
            String subCategory = txtSupplierSubCategory.getText();
            String brandName = txtBrandName.getText();
            String productId = txtProductID.getText();

            SupplierDTO supplier = new SupplierDTO(supplierId,name,address,email,contactNo,contactPerson,supplierCategory,subCategory,brandName,productId);
            boolean isUpdated;
            try {
                isUpdated = supplierBOImpl.updateSupplier(supplier);
                if (isUpdated) {
                    Notifications notifications = Notifications.create().text("Supplier Details Updated.").title("Update Details").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                    notifications.showInformation();
                } else {
                    Notifications notifications = Notifications.create().text("Customer Details Not Updated.").title("Error").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                    notifications.showError();
                }
            } catch (ClassNotFoundException e) {
                Notifications notifications = Notifications.create().text("Driver Not Found.").title("ClassNotFound Exception").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                notifications.showError();

            } catch (SQLException e) {
                Notifications notifications = Notifications.create().text("Data Length is Too Large or Duplicate Entry").title("Warning").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                notifications.showError();

            }
        }

        public void btnDeleteSupplierOnAction(ActionEvent actionEvent) {
            String id = txtSearch.getText();
            boolean isDeleted;
            try {
                isDeleted = supplierBOImpl.deleteSupplier(id);
                if (isDeleted) {
                    Notifications notifications = Notifications.create().text("Supplier Details Deleted.").title("Delete ").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                    notifications.showInformation();
                } else {
                    Notifications notifications = Notifications.create().text("Supplier Not Found.").title("Error").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                    notifications.showError();
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
            txtSupplierID.setText("");
            txtCompanyName.setText("");
            txtAddress.setText("");
            txtEmail.setText("");
            txtContactNumber.setText("");
            txtContactPerson.setText("");
            cmbSupplierCategory.setItems(obList);
            txtSupplierSubCategory.setText("");
            txtBrandName.setText("");
            txtProductID.setText("");

        }


    public void btnQuotationOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.QUOTATION,brdPaneSupplierAccount);
    }

    public void btnPurchaseOrderOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PURCHASE_ORDER,brdPaneSupplierAccount);
    }
}
