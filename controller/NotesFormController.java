package lk.ijse.finalproject.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import lk.ijse.finalproject.bo.custom.*;
import lk.ijse.finalproject.dao.custom.GrnDAO;
import lk.ijse.finalproject.dao.custom.MinDAO;
import lk.ijse.finalproject.dao.custom.MrnDAO;
import lk.ijse.finalproject.dao.custom.StockDAO;
import lk.ijse.finalproject.dao.custom.impl.GrnDAOImpl;
import lk.ijse.finalproject.dao.custom.impl.MinDAOImpl;
import lk.ijse.finalproject.dao.custom.impl.MrnDAOImpl;
import lk.ijse.finalproject.dao.custom.impl.StockDAOImpl;
import lk.ijse.finalproject.db.DBConnection;
import lk.ijse.finalproject.dto.*;

import lk.ijse.finalproject.util.Navigation;
import lk.ijse.finalproject.util.Routes;
import lk.ijse.finalproject.views.tm.GrnTM;
import lk.ijse.finalproject.views.tm.MinTM;
import lk.ijse.finalproject.views.tm.MrnTM;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.poi.hssf.record.formula.functions.Na;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class NotesFormController {
    public BorderPane brdrPaneViewNotes;
    public Pane leftPane;
    public Circle userProfile;
    public Label lblUserName;
    public JFXButton btnProfileSettings;
    public JFXButton btnSupplierDirectory;
    public JFXButton btnViewNotes;
    public JFXButton btnViewStatics;
    public JFXButton btnLogout;
    public JFXButton btnInventory;
    public JFXButton btnHamburger;
    public JFXDatePicker dtRequestedDate;
    public JFXTextField txtRecommendPersonId;
    public Label lblNoteId;
    public Label lblMrnId;
    public JFXTextField txtSubCategory;
    public JFXDatePicker dtDateRequired;
    public JFXButton btnEnter;
    public JFXTextField txtBrandName;
    public JFXComboBox<String> cmbMeasuredUnits;
    public JFXTextField txtQtyRequested;
    public JFXTextField txtStockItemDescription;
    public JFXTextField txtStockCode;
    public JFXTextField txtCategory;
    public JFXButton btnMrnEdit;
    public JFXButton btnMrnEmail;
    public JFXButton btnMrnPrint;
    public JFXDatePicker dtIssueDate;
    public Label lblMinId;
    public JFXTextField txtRequestPersonId;
    public Label lblNoteId1;
    public JFXTextField txtPurpose;
    public JFXButton btnMinEnter;
    public JFXComboBox cmbCategory;
    public JFXTextField txtQtyIssued;
    public JFXComboBox cmbStockCode;
    public JFXComboBox cmbStockItemDescription;
    public JFXComboBox cmbSubCategory;
    public TableView<MinTM> tblMinData;
    public TableColumn tblRequestData2;
    public JFXButton btnMinEdit;
    public JFXButton btnMinEmail;
    public JFXButton btnMinPrint;
    public Pane paneMrn21;
    public JFXDatePicker dtReceiveDate;
    public Label lblNoteIDGrn;
    public Label lblGrnId;
    public JFXTextField txtMrnId;
    public JFXDatePicker dtGrnDate;
    public JFXComboBox<String> cmbGrnCategory;
    public JFXTextField txtQtyReceived;
    public JFXComboBox<String> cmbReceiveStockCode;
    public JFXComboBox<String> cmbReceiveItem;
    public JFXComboBox<String> cmbGrnSubCategory;
    public JFXTextField txtQtyAccepted;
    public JFXTextField txtUnitPrice;
    public JFXTextField txtReasonerRejection;
    public JFXButton btnGrnEnter;
    public JFXButton btnMrnRemove;
    public TableView tblGrnData;
    public JFXButton btnGrnEdit;
    public JFXButton btnGrnRemove;
    public JFXButton btnGrnEmail;
    public JFXButton btnGrnPrint;
    public JFXTextField txtGrnQtyReceived;
    public JFXComboBox<String> cmbGrMeasuredUnits;
    public JFXComboBox<String> cmbGrnBrandName;
    public JFXTextField txtGrnUnitPrice;
    public JFXButton btnMinRemove;
    public JFXComboBox<String> cmbMinCategory;
    public JFXComboBox<String> cmbMinSubCategory;
    public JFXComboBox<String> cmbMinBrandName;
    public JFXComboBox<String> cmbMinMeasuredUnits;
    public Label lblMiNoteId;
    public Pane paneMrn2;
    public Tab tabMin;
    public TableView<MrnTM> tblMRNData;
    public JFXComboBox<String> cmbMrMeasuredUnits;
    public AnchorPane anchPaneMrn;
    public Pane paneMrn;
    public Tab tabMrn;
    public JFXButton btnHome;
    public Tab tabGrn;
    public TableColumn<MrnTM,String> colStockCode;
    public TableColumn<MrnTM,String> colStockItemDescription;
    public TableColumn<MrnTM, String> colMeasuredUnits;
    public TableColumn<MrnTM,Double> colQtyRequested;
    public TableColumn<MrnTM,LocalDate> colRequiredDate;
    public TableColumn<MrnTM,String > colCategory;
    public TableColumn<MrnTM,String> colSubCategory;
    public TableColumn<MrnTM,String> colBrandName;
    public TableColumn colReceivedStockCode;
    public TableColumn colGrnStockItemDescription;
    public TableColumn colGrnCategory;
    public TableColumn colGrnSubCategory;
    public TableColumn colGrnBrandName;
    public TableColumn colGrnMeasuredUnits;
    public TableColumn colUnitPrice;
    public TableColumn colQtyReceived;
    public TableColumn colQtyAccepted;
    public TableColumn colReasonForRejection;
    public JFXTextField txtGrnMrnId;
    public TableColumn<MinTM,String> colMinStockCode;
    public TableColumn <MinTM,String>colMinStockItemDescription;
    public TableColumn <MinTM,String>colMinMeasuredUnits;
    public TableColumn <MinTM,Double> colQtyIssued;
    public TableColumn <MinTM,LocalDate>colIssueDate;
    public TableColumn <MinTM,String>colMinCategory;
    public TableColumn <MinTM,String>colMinSubCategory;
    public TableColumn<MinTM,String> colMinBrandName;
    public TableColumn <MinTM,Double>colMinUnitRate;
    public JFXComboBox cmbMinStockCode;
    public JFXComboBox cmbMinStockItemDescription;
    public JFXTextField txtStoreKeeperId;
    public JFXComboBox cmbMrnId;
    public JFXComboBox cmbGrnMrnId;
    static  ArrayList<MrnDTO> list =new ArrayList<>();
    public JFXTextField txtStorekeeperId;
    public JFXTextField txtUnitRate;
    public TableColumn<MinTM,String> colMinId;
    public TextField txtMrnSearch;
    public JFXDatePicker dtMrRequestedDate;
    public JFXTextField txtMrnRecommendPersonId;
    public JFXTextField txtMrSubCategory;
    public JFXDatePicker dtMrDateRequired;
    public JFXButton btnMrEnter;
    public JFXTextField txtMrBrandName;
    public JFXTextField txtMrQtyRequested;
    public JFXTextField txtMrnStockItemDescription;
    public JFXTextField txtMrCategory;
    public JFXComboBox cmbMrnStockCode;
    public TableColumn <MrnTM,String> colMrStockCode;
    public TableColumn <MrnTM,String> colMrStockItemDescription;
    public TableColumn  <MrnTM,String>colMrMeasuredUnits;
    public TableColumn  <MrnTM,Double>colMrQtyRequested;
    public TableColumn  <MrnTM,LocalDate>colMrRequiredDate;
    public TableColumn  <MrnTM,String>colMrCategory;
    public TableColumn  <MrnTM,String>colMrSubCategory;
    public TableColumn  <MrnTM,String>colMrBrandName;
    public TextField txtMinSearch;
    public JFXTextField txtMrnMeasuredUnits;
    public TableColumn <MrnTM,String> colMrnID;
    ObservableList <MrnTM> tmList = FXCollections.observableArrayList();
    ObservableList <MinTM> minTmList = FXCollections.observableArrayList();
    ObservableList <StockDTO> codeList = FXCollections.observableArrayList();
    GrnBO grnBOImpl = (GrnBO) BOFactory.getBoFactory().getBO(BOTypes.GRN);
    StockBO stockBOImpl = (StockBO) BOFactory.getBoFactory().getBO(BOTypes.STOCK);
    MrnBO mrnBOImpl = (MrnBO) BOFactory.getBoFactory().getBO(BOTypes.MRN);

    MinBO minBOImpl = (MinBO) BOFactory.getBoFactory().getBO(BOTypes.MIN);



    public void initialize() {
        mrnSetCellValueFactory();
        minSetCellValueFactory();

       loadNextMrnId();
        loadNextGrnId();
        loadNextMinId();
        loadStockCodesInGrn();
        loadStockDescriptionInGrn();


        loadMrnIdInGrn();
        ObservableList<String> unitsList = FXCollections.observableArrayList("Nos","Kilogram","Liters","Meters","Packets");
        cmbGrMeasuredUnits.setItems(unitsList);
        cmbMinMeasuredUnits.setItems(unitsList);

        ObservableList <String> categoryList = FXCollections.observableArrayList("Grocery","Dairy","Homeware","Meat and Fish","Personal Care","Baby Needs","Frozen Items","Fruits and Vegetables");
        cmbGrnCategory.setItems(categoryList);
        cmbMinCategory.setItems(categoryList);
        loadMrnTableData();
        loadMinTableData();
        loadStockCodes();
        loadDescriptionList();
        loadCategoryList();
        loadBrandNameList();
        loadMrnStockCodeList();
        loadSubCategoryList();


    }

    private void loadMrnStockCodeList() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> itemList = stockBOImpl.collectUnAvailableProductCodes();

            for (String code : itemList) {
                observableList.add(String.valueOf(code));
            }
            cmbMrnStockCode.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void minSetCellValueFactory() {
        colMinStockCode.setCellValueFactory(new PropertyValueFactory<>("minStockCode"));
        colMinStockItemDescription.setCellValueFactory(new PropertyValueFactory<>("minStockItemDescription"));
        colMinMeasuredUnits.setCellValueFactory(new PropertyValueFactory<>("minMeasuredUnits"));
        colQtyIssued.setCellValueFactory(new PropertyValueFactory<>("minQtyIssued"));
        colIssueDate.setCellValueFactory(new PropertyValueFactory<>("minDate"));
        colMinCategory.setCellValueFactory(new PropertyValueFactory<>("minCategory"));
        colMinSubCategory.setCellValueFactory(new PropertyValueFactory<>("minSubCategory"));
        colMinBrandName.setCellValueFactory(new PropertyValueFactory<>("minBrandName"));
        colMinUnitRate.setCellValueFactory(new PropertyValueFactory<>("minUnitRate"));
        colMinId.setCellValueFactory(new PropertyValueFactory<>("minId"));
    }

    private void mrnSetCellValueFactory(){
        colMrnID.setCellValueFactory(new PropertyValueFactory<>("mrnId"));
        colMrStockCode.setCellValueFactory(new PropertyValueFactory<>("stockCode"));
        colMrStockItemDescription.setCellValueFactory(new PropertyValueFactory<>("productName"));
        colMrMeasuredUnits.setCellValueFactory(new PropertyValueFactory<>("measuredUnits"));
        colMrQtyRequested.setCellValueFactory(new PropertyValueFactory<>("requestQty"));
        colMrRequiredDate.setCellValueFactory(new PropertyValueFactory<>("requiredDate"));
        colMrCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMrSubCategory.setCellValueFactory(new PropertyValueFactory<>("subCategory"));
        colMrBrandName.setCellValueFactory(new PropertyValueFactory<>("brandName"));
    }

    private void loadMinTableData() {
        ArrayList  <MinDTO> min = null;
        try {
            min = minBOImpl.getAllMinTableData();
            for (MinDTO min1 : min) {

                MinTM tm = new MinTM(min1.getStockCode(),min1.getStockItemDescription(),min1.getMeasuredUnits(),min1.getQtyIssued(),min1.getIssuedDate(),min1.getCategory(),min1.getSubCategory(),min1.getBrandName(),min1.getUnitRate(),min1.getMinId());
                minTmList.add(tm);
                tblMinData.setItems(minTmList);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void loadDescriptionList() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> availableProductDescriptions = stockBOImpl.collectProductNames();

            for (String code : availableProductDescriptions) {
                observableList.add(code);
            }
            cmbMinStockItemDescription.setItems(observableList);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadCategoryList() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> availableProductCategories = stockBOImpl.collectAvailableItemCategories();

            for (String code : availableProductCategories) {
                observableList.add(code);
            }
            cmbMinCategory.setItems(observableList);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private void loadBrandNameList() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> brandNameList = stockBOImpl.collectProductBrandNames();

            for (String code : brandNameList) {
                observableList.add(code);
            }
            cmbMinBrandName.setItems(observableList);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    private void loadSubCategoryList() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> subCategoryList = stockBOImpl.collectAvailableItemSubCategories();

            for (String code : subCategoryList) {
                observableList.add(code);
            }
            cmbMinSubCategory.setItems(observableList);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    private void loadStockCodes()  {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> availableProductCodes = stockBOImpl.collectAvailableProductCodes();

            for (String code : availableProductCodes) {
                observableList.add(code);
            }
            cmbMinStockCode.setItems(observableList);



        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private void loadNextMinId() {
        String  minId = null;

        try {
            minId = minBOImpl.getNextMinId();
            lblMinId.setText(minId);
        } catch (SQLException e) {
            Notifications notifications = Notifications.create().title("SQL Exception").text("Exception").hideAfter(Duration.seconds(3)).position(Pos.BASELINE_RIGHT);
            notifications.showInformation();
        } catch (ClassNotFoundException e) {
            Notifications notifications = Notifications.create().title("Class Not Found Exception").text("Exception").hideAfter(Duration.seconds(3)).position(Pos.BASELINE_RIGHT);
            notifications.showInformation();
        }
    }

    private void loadMrnTableData() {
        ArrayList  <MrnDTO> mrn = null;
        try {
            mrn = mrnBOImpl.getAllMrnDetails();
            for (MrnDTO mrn1 : mrn) {

                MrnTM tm = new MrnTM(mrn1.getMrnId(),mrn1.getStockCode(),mrn1.getStockDescription(),mrn1.getMeasuredUnits(),mrn1.getRequiredDate(),mrn1.getRequestedQty(),mrn1.getCategory(),
                        mrn1.getSubCategory(),mrn1.getBrandName());
                tmList.add(tm);
                tblMRNData.setItems(tmList);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void loadMrnIdInGrn() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> mrnIdList = mrnBOImpl.chooseMrnId();

            for (String id : mrnIdList) {
                observableList.add(id);
            }
           cmbGrnMrnId.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadStockDescriptionInGrn() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> stockDescriptionList = stockBOImpl.chooseDescription();

            for (String id : stockDescriptionList) {
                observableList.add(id);
            }
            cmbReceiveItem.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private void loadStockCodesInGrn() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> stockCodeList = stockBOImpl.collectAvailableProductCodes();

            for (String id : stockCodeList) {
                observableList.add(id);
            }
            cmbReceiveStockCode.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadNextGrnId() {
        String  grnId = null;

        try {
            grnId = grnBOImpl.getNextGrnId();
            lblGrnId.setText(grnId);
        } catch (SQLException e) {
            Notifications notifications = Notifications.create().title("SQL Exception").text("Exception").hideAfter(Duration.seconds(3)).position(Pos.BASELINE_RIGHT);
            notifications.showInformation();
        } catch (ClassNotFoundException e) {
            Notifications notifications = Notifications.create().title("Class Not Found Exception").text("Exception").hideAfter(Duration.seconds(3)).position(Pos.BASELINE_RIGHT);
            notifications.showInformation();
        }

    }


    private void loadNextMrnId()  {

        String  mrnId = null;

        try {
            mrnId = mrnBOImpl.getNextMrnId();
            lblMrnId.setText(mrnId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


    public void btnHomeOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STORE_DASHBOARD,brdrPaneViewNotes);
    }
    public void btnProfileSettingsOnAction(ActionEvent actionEvent) {
    }

    public void BtnSupplierDirectoryOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.SUPPLIER_DIRECTORY,brdrPaneViewNotes);
    }

    public void btnViewNotesOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.VIEW_NOTES,brdrPaneViewNotes);
    }

    public void btnViewStaticsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STORE_STATISTICS,brdrPaneViewNotes);
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) {
    }

    public void btnInventoryOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.INVENTORY,brdrPaneViewNotes);
    }

    public void btnClickHamburgerOnAction(ActionEvent actionEvent) {
    }

    public void btnEnterOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String mrnId = lblMrnId.getText();
        LocalDate requestedDate = dtMrRequestedDate.getValue();
        String recommendPersonId=txtMrnRecommendPersonId.getText();
        String stockCode = cmbMrnStockCode.getSelectionModel().getSelectedItem().toString();
        String stockItemDescription = txtMrnStockItemDescription.getText();
        LocalDate dateRequired = dtMrDateRequired.getValue();
        String measuredUnits = txtMrnMeasuredUnits.getText();
        String category = txtMrCategory.getText();
        String subCategory = txtMrSubCategory.getText();
        String brandName = txtMrBrandName.getText();
        double qtyRequested = Double.parseDouble(txtMrQtyRequested.getText());

        MrnDTO newMrn = new MrnDTO(mrnId,stockCode,stockItemDescription,measuredUnits,requestedDate,dateRequired,recommendPersonId,qtyRequested,category,subCategory,brandName);
        ObservableList<MrnTM> mrnTM = tblMRNData.getItems();
        boolean isAdded = false;
        try {
            isAdded = mrnBOImpl.addMrn(newMrn);
            if(isAdded){
                mrnTM.add(new MrnTM(newMrn.getMrnId(),newMrn.getStockCode(),newMrn.getStockDescription(),newMrn.getMeasuredUnits(),newMrn.getRequiredDate(),newMrn.getRequestedQty(),newMrn.getCategory(),newMrn.getSubCategory(),newMrn.getBrandName()));
                tblMRNData.setItems(mrnTM);
                Notifications notifications = Notifications.create().title("Material Request Note").text("MRN recorded successfully.").hideAfter(Duration.seconds(3)).position(Pos.BASELINE_RIGHT);
                notifications.showInformation();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            Notifications notifications = Notifications.create().title("Class Not Found Exception").text("Exception").hideAfter(Duration.seconds(3)).position(Pos.BASELINE_RIGHT);
            notifications.showInformation();
        }


    }

    public void btnMrnEditOnAction(ActionEvent actionEvent) {
        String mrnId = lblMrnId.getText();
        LocalDate requestedDate = dtMrRequestedDate.getValue();
        String recommendPersonId = txtMrnRecommendPersonId.getText();
        String stockCode = cmbMrnStockCode.getSelectionModel().getSelectedItem().toString();
        String stockItemDescription = txtMrnStockItemDescription.getText();
        LocalDate dateRequired = dtMrDateRequired.getValue();
        String measuredUnits = txtMrnMeasuredUnits.getText();
        String category = txtMrCategory.getText();
        String subCategory = txtMrSubCategory.getText();
        String brandName = txtMrBrandName.getText();
        double qtyRequested = Double.parseDouble(txtMrQtyRequested.getText());

        MrnDTO mrn = new MrnDTO(mrnId, stockCode, stockItemDescription, measuredUnits, requestedDate, dateRequired, recommendPersonId, qtyRequested, category, subCategory, brandName);

        boolean isUpdated = false;
        try {
            isUpdated = mrnBOImpl.updateMrn(mrn);
            if (isUpdated) {
                Notifications notifications = Notifications.create().text("Mrn Details Updated.").title("Update Details").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                notifications.showInformation();
            } else {
                Notifications notifications = Notifications.create().text("Mrn Details Not Updated.").title("Update Details").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                notifications.showError();
            }

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

    }
    public void btnMrnRemoveOnAction(ActionEvent actionEvent) throws IOException {

        int selectedIndex = tblMRNData.getSelectionModel().getSelectedIndex();
        String mrnId = tblMRNData.getSelectionModel().getSelectedItem().getMrnId();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Alert");
        alert.setContentText("Do you want to delete the record?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.equals(null)){

        }else if (result.get()==ButtonType.OK) {
            try {
                boolean isDelete = mrnBOImpl.deleteMrn(mrnId);
                tblMRNData.getItems().remove(selectedIndex);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }else {
            Navigation.navigate(Routes.VIEW_NOTES,brdrPaneViewNotes);
        }



    }

    public void btnMrnEmailOnAction(ActionEvent actionEvent) {
    }

    public void btnMrnPrintOnAction(ActionEvent actionEvent) {

        HashMap<String, Object> hashMap = new HashMap<>();
        InputStream inputStream = this.getClass().getResourceAsStream("/lk/ijse/finalproject/report/MrnForm.jrxml");
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hashMap, DBConnection.getInstance().getConnection());
            JasperPrintManager.printReport(jasperPrint, false);
            //JasperPrintManager.printReport(jasperPrint,true); //print hardcopy
            JasperViewer.viewReport(jasperPrint);

        } catch (JRException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnMinEnterOnAction(ActionEvent actionEvent) {
        String minId = lblMinId.getText();
        String purpose = txtPurpose.getText();
        LocalDate date = dtIssueDate.getValue();

        String requestPersonId = txtRequestPersonId.getText();
        String stockCode = cmbMinStockCode.getSelectionModel().getSelectedItem().toString();
        String desc = cmbMinStockItemDescription.getSelectionModel().getSelectedItem().toString();
        String category = cmbMinCategory.getSelectionModel().getSelectedItem().toString();
        String subCategory = cmbMinSubCategory.getSelectionModel().getSelectedItem().toString();
        String brandName = cmbMinBrandName.getSelectionModel().getSelectedItem().toString();
        double qtyIssued = Double.parseDouble(txtQtyIssued.getText());
        String skId = txtStorekeeperId.getText();
        double unitRate = Double.parseDouble(txtUnitRate.getText());
        String measuredUnits = cmbMinMeasuredUnits.getSelectionModel().getSelectedItem().toString();

        MinDTO minDTO= new MinDTO(minId,purpose,date,requestPersonId,stockCode,desc,category,subCategory,brandName,qtyIssued,skId,unitRate,measuredUnits);
        ObservableList<MinTM> minTM = tblMinData.getItems();
        boolean isAdded = false;
        try {
            isAdded = minBOImpl.addMin(minDTO);
            if(isAdded){
                minTM.add(new MinTM(minDTO.getStockCode(),minDTO.getStockItemDescription(),minDTO.getMeasuredUnits(),minDTO.getQtyIssued(),minDTO.getIssuedDate(),minDTO.getCategory(),minDTO.getSubCategory(),minDTO.getBrandName(),minDTO.getUnitRate()));
                tblMinData.setItems(minTM);
                Notifications notifications = Notifications.create().title("Material Issue Note").text("MIN recorded successfully.").hideAfter(Duration.seconds(3)).position(Pos.BASELINE_RIGHT);
                notifications.showInformation();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            Notifications notifications = Notifications.create().title("Class Not Found Exception").text("Exception").hideAfter(Duration.seconds(3)).position(Pos.BASELINE_RIGHT);
            notifications.showInformation();
        }

    }

    public void btnMinEditOnAction(ActionEvent actionEvent) {
    }

    public void btnMinRemoveOnAction(ActionEvent actionEvent) {
        int selectedIndex = tblMinData.getSelectionModel().getSelectedIndex();
        tblMinData.getItems().remove(selectedIndex);
    }

    public void btnMinEmailOnAction(ActionEvent actionEvent) {
    }

    public void btnMinPrintOnAction(ActionEvent actionEvent) {
        InputStream inputStream = this.getClass().getResourceAsStream("/lk/ijse/finalproject/report/MinForm.jrxml");


        try {

            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null, DBConnection.getInstance().getConnection());
            // JasperPrintManager.printReport(jasperPrint,true);
            JasperViewer.viewReport(jasperPrint,false);

        } catch (JRException | SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void btnGrnEnterOnAction(ActionEvent actionEvent) {
        String grnId = lblGrnId.getText();
        String mrnId = cmbGrnMrnId.getSelectionModel().getSelectedItem().toString();
        LocalDate stockReceivedDate = dtReceiveDate.getValue();
        LocalDate grnDate = dtGrnDate.getValue();
        String stockCode = cmbReceiveStockCode.getSelectionModel().getSelectedItem().toString();
        String stockItemDescription = cmbStockItemDescription.getSelectionModel().getSelectedItem().toString();
        String category = cmbGrnCategory.getSelectionModel().getSelectedItem().toString();
        String subCategory = cmbGrnSubCategory.getSelectionModel().getSelectedItem().toString();
        String brandName = cmbGrnBrandName.getSelectionModel().getSelectedItem().toString();
        String measuredUnits = cmbGrMeasuredUnits.getSelectionModel().getSelectedItem().toString();
        double qtyReceived = Double.parseDouble(txtGrnQtyReceived.getText());
        double qtyAccepted = Double.parseDouble(txtQtyAccepted.getText());
        double unitPrice = Double.parseDouble(txtGrnUnitPrice.getText());
        String storeKeeperId = txtStoreKeeperId.getText();
        String reasonForRejection = txtReasonerRejection.getText();

        GrnDTO grn = new GrnDTO (grnId,mrnId,stockReceivedDate,grnDate,stockCode,stockItemDescription,category,subCategory,brandName,measuredUnits,qtyReceived,qtyAccepted,unitPrice,storeKeeperId,reasonForRejection);
        ObservableList<GrnDTO> grnTM = tblGrnData.getItems();
        boolean isAdded = false;
        try {
            isAdded = grnBOImpl.addGrn(grn);
            if(isAdded){
                grnTM.add(grn);
                tblGrnData.setItems(grnTM);
                Notifications notifications = Notifications.create().title("Goods Receipt Note").text("GRN Added Successfully.").hideAfter(Duration.seconds(3)).position(Pos.BASELINE_RIGHT);
                notifications.showInformation();

            }
        } catch (SQLException e) {
            Notifications notifications = Notifications.create().title("SQL Exception").text("Exception").hideAfter(Duration.seconds(3)).position(Pos.BASELINE_RIGHT);
            notifications.showInformation();
        } catch (ClassNotFoundException e) {
            Notifications notifications = Notifications.create().title("Class Not Found Exception").text("Exception").hideAfter(Duration.seconds(3)).position(Pos.BASELINE_RIGHT);
            notifications.showInformation();
        }

    }

    public void btnGrnEditOnAction(ActionEvent actionEvent) {
    }

    public void btnGrnRemoveOnAction(ActionEvent actionEvent) {
    }

    public void btnGrnEmailOnAction(ActionEvent actionEvent) {
    }

    public void btnGrnPrintOnAction(ActionEvent actionEvent) {
    }


    public void cmbGenerateDetailsOnAction(ActionEvent actionEvent) {
        String code = String.valueOf(cmbReceiveStockCode.getValue());
        try {
            StockDTO item = stockBOImpl.searchStockDetails(code);
            fillItemFields(item);
            txtGrnQtyReceived.requestFocus();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void fillItemFields(StockDTO item) {
        cmbReceiveItem.setAccessibleText(item.getItemDescription());
        cmbGrnCategory.setAccessibleText(item.getCategory());
        cmbGrnSubCategory.setAccessibleText(item.getSubCategory());
        cmbGrnBrandName.setAccessibleText(item.getBrand());
        cmbGrMeasuredUnits.setAccessibleText(item.getMeasuredUnits());
    }

    public void cmbStockDescriptionOnAction(ActionEvent actionEvent) {
        String description = String.valueOf(cmbReceiveItem.getValue());
        try {
            StockDTO itemDetails = stockBOImpl.searchDetailsWithDescription(description);
            fillItemFields(itemDetails);
            txtGrnQtyReceived.requestFocus();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void rowClockedOnMouseEvent(MouseEvent mouseEvent) {
        MrnTM clickedRow = tblMRNData.getSelectionModel().getSelectedItem();
        lblMrnId.setText(String.valueOf(clickedRow.getMrnId()));
        cmbMrnStockCode.setValue(String.valueOf(clickedRow.getStockCode()));
        txtMrnStockItemDescription.setText(String.valueOf(clickedRow.getProductName()));
        txtMrnMeasuredUnits.setText(String.valueOf(clickedRow.getMeasuredUnits()));
        txtMrQtyRequested.setText(String.valueOf(clickedRow.getRequestQty()));
        dtMrDateRequired.setValue(clickedRow.getRequiredDate());
        txtMrCategory.setText(String.valueOf(clickedRow.getCategory()));
        txtMrSubCategory.setText(String.valueOf(clickedRow.getCategory()));
        txtMrBrandName.setText(String.valueOf(clickedRow.getBrandName()));

    }

    public void txtMrnSearchOnAction(ActionEvent actionEvent) {
        btnMrnSearchOnAction(actionEvent);
    }

    public void btnMrnSearchOnAction(ActionEvent actionEvent) {
        String code = txtMrnSearch.getText();
        try {
            MrnDTO mrnDTO =mrnBOImpl.searchMrn(code);
            if (mrnDTO!= null){
                txtMrnSearch.setText("");
                fillMrnFormData(mrnDTO);
            }else{
                Notifications notifications = Notifications.create().title(" Search Mrn").text("Mrn "+txtMrnSearch.getText() +" Not Found").hideAfter(Duration.seconds(3)).position(Pos.TOP_CENTER);
                notifications.show();
                txtMrnSearch.setText("");
                txtMrnRecommendPersonId.setText("");
                dtMrRequestedDate.setAccessibleRoleDescription("");
                cmbMrnStockCode.setAccessibleText("");
                txtMrnStockItemDescription.setText("");
                dtMrDateRequired.setAccessibleRoleDescription("");
                txtMrnMeasuredUnits.setText("");
                txtMrCategory.setText("");
                txtMrSubCategory.setText("");
                txtMrBrandName.setText("");
                txtMrQtyRequested.setText("");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void fillMrnFormData(MrnDTO mrnDTO){
        lblMrnId.setText(mrnDTO.getMrnId());
        txtMrnRecommendPersonId.setText(mrnDTO.getRecommendBy());
        dtMrRequestedDate.setValue(mrnDTO.getRequestDate());
        cmbMrnStockCode.setValue(mrnDTO.getStockCode());
        txtMrnStockItemDescription.setText(mrnDTO.getStockDescription());
        dtMrDateRequired.setValue(mrnDTO.getRequiredDate());
        txtMrnMeasuredUnits.setText(mrnDTO.getMeasuredUnits());
        txtMrCategory.setText(mrnDTO.getCategory());
        txtMrSubCategory.setText(mrnDTO.getSubCategory());
        txtMrBrandName.setText(mrnDTO.getBrandName());
        txtMrQtyRequested.setText(String.valueOf(mrnDTO.getRequestedQty()));
    }

    public void cmbIdSelectOnAction(ActionEvent actionEvent) {
    }

    public void btnMrEnterOnAction(ActionEvent actionEvent) {
        String mrnId = lblMrnId.getText();
        LocalDate requestedDate = dtMrRequestedDate.getValue();
        String recommendPersonId=txtMrnRecommendPersonId.getText();
        String stockCode = cmbMrnStockCode.getSelectionModel().getSelectedItem().toString();
        String stockItemDescription = txtMrnStockItemDescription.getText();
        LocalDate dateRequired = dtMrDateRequired.getValue();
        String measuredUnits = cmbMrMeasuredUnits.getSelectionModel().getSelectedItem().toString();
        String category = txtMrCategory.getText();
        String subCategory = txtMrSubCategory.getText();
        String brandName = txtMrBrandName.getText();
        double qtyRequested = Double.parseDouble(txtMrQtyRequested.getText());

        MrnDTO newMrn = new MrnDTO(mrnId,stockCode,stockItemDescription,measuredUnits,requestedDate,dateRequired,recommendPersonId,qtyRequested,category,subCategory,brandName);
        ObservableList<MrnTM> mrnTM = tblMRNData.getItems();

        boolean isAdded = false;
        try {
            isAdded = mrnBOImpl.addMrn(newMrn);
            if(isAdded){
                mrnTM.add(new MrnTM(newMrn.getStockCode(),newMrn.getStockDescription(),newMrn.getMeasuredUnits(),newMrn.getSkId(),newMrn.getRequiredDate(),newMrn.getRequestedQty(),newMrn.getCategory(),newMrn.getSubCategory(),newMrn.getBrandName()));
                tblMRNData.setItems(mrnTM);
                Notifications notifications = Notifications.create().title("Material Request Note").text("MRN recorded successfully.").hideAfter(Duration.seconds(3)).position(Pos.BASELINE_RIGHT);
                notifications.showInformation();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            Notifications notifications = Notifications.create().title("Class Not Found Exception").text("Exception").hideAfter(Duration.seconds(3)).position(Pos.BASELINE_RIGHT);
            notifications.showInformation();
        }


    }

    public void cmbMrnIdSelectOnAction(ActionEvent actionEvent) {
        String code = String.valueOf(cmbMrnStockCode.getValue());
        try {
            StockDTO stockDTO = stockBOImpl.searchStockDetails(code);
            fillMrnItemFields(stockDTO);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void fillMrnItemFields(StockDTO stockAtStore) {
        txtMrnStockItemDescription.setText(stockAtStore.getItemDescription());
        txtMrnMeasuredUnits.setText(stockAtStore.getMeasuredUnits());
        txtMrCategory.setText(stockAtStore.getCategory());
        txtMrSubCategory.setText(stockAtStore.getSubCategory());
        txtMrBrandName.setText(stockAtStore.getBrand());
        dtMrDateRequired.requestFocus();


    }

    public void txtMinSearchOnAction(ActionEvent actionEvent) {
    }

    public void btnMinSearchOnAction(ActionEvent actionEvent) {
    }
}
