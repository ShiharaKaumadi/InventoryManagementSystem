package lk.ijse.finalproject.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import lk.ijse.finalproject.bo.custom.BOFactory;
import lk.ijse.finalproject.bo.custom.BOTypes;
import lk.ijse.finalproject.bo.custom.SupplierBO;
import lk.ijse.finalproject.dao.custom.SupplierDAO;
import lk.ijse.finalproject.dao.custom.impl.SupplierDAOImpl;
import lk.ijse.finalproject.dto.SupplierDTO;

import lk.ijse.finalproject.util.Navigation;
import lk.ijse.finalproject.util.Routes;
import lk.ijse.finalproject.views.tm.SupplierTM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class  SupplierDirectoryFormController  extends SupplierAccountFormController {
    public BorderPane brdPaneSupplier;
    public Pane leftPane;
    public Circle userProfile;
    public Label lblUserName;
    public JFXButton btnHome;
    public JFXButton btnProfileSettings;
    public JFXButton btnSupplierDirectory;
    public JFXButton btnViewNotes;
    public JFXButton btnViewStatics;
    public JFXButton btnLogout;
    public JFXButton btnHamburger;
    public JFXButton btnSaveSupplier;
    public Pane paneProfile;
    public JFXTextField txtCompanyName;
    public JFXTextField txtSupplierId;
    public JFXTextField txtAddress;
    public JFXTextField txtEmail;
    public JFXTextField txtContactNo;
    public JFXTextField txtContactPerson;
    public JFXButton btnBack;
    public TextField txtSearch;
    public JFXTextField txtSupplierSubCategory;
    public JFXTextField txtBrandName;
    public JFXComboBox cmbCategory;
    public JFXButton btnEditSupplier;
    public JFXButton btnDelete;
    public JFXButton btnClear;
    public Pane pane;
    public ScrollPane scrollPane;
    public AnchorPane anchorPane;
    public GridPane gridPane;
    public TableView<SupplierTM> tblSupplierData;
    public TableColumn<SupplierTM,String> colSupplierID;
    public TableColumn<SupplierTM,String> colCompanyName;
    public TableColumn<SupplierTM,String> colAddress;
    public TableColumn<SupplierTM,String> colEmail;
    public TableColumn <SupplierTM,String> colContactNo;
    public TableColumn<SupplierTM,String> colContactPerson;
    public TableColumn <SupplierTM,String> colCategory;
    public TableColumn <SupplierTM,String> colSubCategory;
    public TableColumn <SupplierTM,String> colProductID;

    ObservableList<SupplierTM> tmList = FXCollections.observableArrayList();
    SupplierBO supplierBOImpl = (SupplierBO) BOFactory.getBoFactory().getBO(BOTypes.SUPPLIER);



    public void btnHomeOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STORE_DASHBOARD,brdPaneSupplier);
    }

    public void btnProfileSettingsOnAction(ActionEvent actionEvent) {

    }

    public void btnSupplierDirectoryOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.SUPPLIER_DIRECTORY,brdPaneSupplier);
    }

    public void btnViewNotesOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STORE_NOTES,brdPaneSupplier);
    }

    public void btnViewStaticsOnAction(ActionEvent actionEvent) throws IOException {
Navigation.navigate(Routes.STORE_NOTES,brdPaneSupplier);
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) {
    }

    public void btnClickHamburgerOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.HAM_SUPPLIER,brdPaneSupplier);
    }

    public void btnSaveSupplierOnAction(ActionEvent actionEvent) {

    }

    public void btnBackOnAction(ActionEvent actionEvent) {


    }

    public void txtSearchOnAction(ActionEvent actionEvent) {
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
    }

    public void btnEditSupplierOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteSupplierOnAction(ActionEvent actionEvent) {
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
    }

    public void btnInventoryOnACtion(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.INVENTORY,brdPaneSupplier);
    }


    public void initialize() {
       colSupplierID.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
        colCompanyName.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colContactNo.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        colContactPerson.setCellValueFactory(new PropertyValueFactory<>("contactPerson"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colSubCategory.setCellValueFactory(new PropertyValueFactory<>("subCategory"));
        colProductID.setCellValueFactory(new PropertyValueFactory<>("productId"));
        loadSupplierTableData();
      /*  ArrayList<SupplierDTO> supplierList = null;
        try {
            supplierList = SupplierDAOImpl.selectAllSuppliers();
           // System.out.println(supplierList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //supplierList.addAll(getData());
        System.out.println(supplierList);
        int column=0;
        int row = 1;
        try{
            for(SupplierDTO supplierDTO: supplierList){
                //System.out.println(supplierList.size());
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/lk/ijse/finalproject/views/SupplierNameCard.fxml"));
                Pane anchorPane1 = fxmlLoader.load();
                SupplierNameCardController supplierNameCardController = fxmlLoader.getController();
                supplierNameCardController.setNameCardData(supplierDTO);
                if (column == 5) {
                    column = 0;
                    row++;
                }

                gridPane.add(anchorPane1, column++, row);
                gridPane.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridPane.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridPane.setMaxWidth(Region.USE_COMPUTED_SIZE);
                gridPane.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridPane.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridPane.setMaxHeight(Region.USE_COMPUTED_SIZE);
                GridPane.setMargin(anchorPane, new Insets(20));

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

    }

    private void loadSupplierTableData() {
        ArrayList<SupplierDTO> list=null;
        try {
            list = supplierBOImpl.getAllSuppliers();
            for (SupplierDTO supplierDTO: list){
                SupplierTM supplierTM = new SupplierTM(supplierDTO.getSupplierId(),supplierDTO.getCompanyName(),supplierDTO.getAddress(),supplierDTO.getEmail(),supplierDTO.getContactNo(),supplierDTO.getContactPerson(),supplierDTO.getSupplierCategory(),supplierDTO.getSupplierSubCategory(),supplierDTO.getProductId());
                tmList.add(supplierTM);
                tblSupplierData.setItems(tmList);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnCreateNewSupplier(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.SUPPLIER_ACCOUNT,brdPaneSupplier);
    }



}
