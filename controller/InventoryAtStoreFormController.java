package lk.ijse.finalproject.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import lk.ijse.finalproject.bo.custom.BOFactory;
import lk.ijse.finalproject.bo.custom.BOTypes;
import lk.ijse.finalproject.bo.custom.StockBO;
import lk.ijse.finalproject.bo.custom.impl.StockBoImpl;
import lk.ijse.finalproject.dao.custom.StockDAO;
import lk.ijse.finalproject.dao.custom.impl.StockDAOImpl;
import lk.ijse.finalproject.db.DBConnection;
import lk.ijse.finalproject.dto.StockDTO;
import lk.ijse.finalproject.entity.StockAtStore;
import lk.ijse.finalproject.util.Navigation;
import lk.ijse.finalproject.util.Routes;
import lk.ijse.finalproject.views.tm.CurrentStockTM;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class InventoryAtStoreFormController {
    public BorderPane brdrPaneInventory;
    public Pane leftPane;
    public Circle userProfile;
    public Label lblUserName;
    public JFXButton btnHome;
    public JFXButton btnProfileSettings;
    public JFXButton btnSupplierDirectory;
    public JFXButton btnViewNotes;
    public JFXButton btnViewStatics;
    public JFXButton btnLogout;
    public JFXButton btnInventory;
    public JFXButton btnHamburger;
    public ComboBox cmbFilter;
    public Tab tabCurrentStock;
    public TableView<CurrentStockTM> tblStockData;
    public TableColumn<CurrentStockTM, String> colStockId;
    public TableColumn<CurrentStockTM, String> colStockDescription;
    public TableColumn<CurrentStockTM, String> colUnits;
    public TableColumn<CurrentStockTM,Double> colQtyOnHand;
    public TableColumn<CurrentStockTM, Double> colUnitRate;
    public TableColumn<CurrentStockTM, Double> colStockValue;
    public TableColumn<CurrentStockTM, String> colCategory;
    public TableColumn<CurrentStockTM, String> colSubCategory;
    public TableColumn<CurrentStockTM, String> colBrandName;
    public TableColumn<CurrentStockTM, Label> colPreOrderStatus;
    public Tab tabStockVerification;
    public JFXComboBox cmbComStockCode;
    public JFXTextField txtComItemDescription;
    public JFXTextField txtComUnits;
    public JFXTextField txtComQtyOnHand;
    public JFXTextField txtPhysicalItemDescription;
    public JFXComboBox cmbPhysicalStockCode;
    public JFXTextField txtPhysicalUnits;
    public JFXTextField txtPhysicalQtyOnHand;
    public JFXTextField txtReasonForDifference;
    public JFXTextField txtChangedItemDescription;
    public JFXComboBox cmbChagedStockCode;
    public JFXTextField txtChangeUnits;
    public JFXTextField txtChangePhysicalQty;
    public JFXButton btnReject;
    public JFXButton btnConfirm;
    public JFXTextField txtRecommendedBy;
    public Label lblPreparedBy;
    public TextField txtSearch;
    public JFXButton btnProfileSettings1;

    ObservableList<CurrentStockTM> tmList = FXCollections.observableArrayList();
    
    static ArrayList<StockDTO>list= new ArrayList<>();
    StockBO stockBOImpl = (StockBO) BOFactory.getBoFactory().getBO(BOTypes.STOCK);;

    private void loadAllData(){
        ArrayList  <StockDTO> stockAtStore = null;
        try {
            stockAtStore = stockBOImpl.getAllStockDetails();
            for (StockDTO stockAtStore1 : stockAtStore) {
                double stockValue = stockAtStore1.getQtyOnHand() * stockAtStore1.getUnitRate();
                Label label = new Label("Available");
                if(stockAtStore1.getQtyOnHand()<=100){
                    label.setText("Not Available");
                }else{
                    label.setText("Available");
                }
                CurrentStockTM tm = new CurrentStockTM(stockAtStore1.getStockCode(), stockAtStore1.getItemDescription(), stockAtStore1.getMeasuredUnits(), stockAtStore1.getQtyOnHand(), stockAtStore1.getUnitRate(), stockValue, stockAtStore1.getCategory(), stockAtStore1.getSubCategory(), stockAtStore1.getBrand(), label);
                tmList.add(tm);
                tblStockData.setItems(tmList);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void initialize(){
        colStockId.setCellValueFactory(new PropertyValueFactory<>("stockId"));
        colStockDescription.setCellValueFactory(new PropertyValueFactory<>("stockDescription"));
        colUnits.setCellValueFactory(new PropertyValueFactory<>("measuredUnits"));
        colQtyOnHand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        colUnitRate.setCellValueFactory(new PropertyValueFactory<>("unitRate"));
        colStockValue.setCellValueFactory(new PropertyValueFactory<>("stockValue"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colSubCategory.setCellValueFactory(new PropertyValueFactory<>("subCategory"));
        colBrandName.setCellValueFactory(new PropertyValueFactory<>("brandName"));
        colPreOrderStatus.setCellValueFactory(new PropertyValueFactory<>("label"));
        loadAllData();

        FilteredList <CurrentStockTM> filteredList = new FilteredList<>(tmList,b->true);
        txtSearch.textProperty().addListener((observable,oldvalue,newValue) ->{
            filteredList.setPredicate(stock ->{
                if (newValue==null||newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (stock.getCategory().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                    return true;
                }else if (stock.getBrandName().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                    return true;
                }else if (stock.getStockDescription().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                    return true;
                }else if (stock.getSubCategory().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                    return true;
                }else if (String.valueOf(stock.getStockValue()).toLowerCase().indexOf(lowerCaseFilter)!=-1){
                    return true;
                }else{
                    return false;
                }
            });
            SortedList <CurrentStockTM> sortedList = new SortedList<>(filteredList);
            sortedList.comparatorProperty().bind(tblStockData.comparatorProperty());
            tblStockData.setItems(sortedList);
        } );



    }

    public void btnHomeOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STORE_DASHBOARD,brdrPaneInventory);
    }

    public void btnProfileSettingsOnAction(ActionEvent actionEvent) {
    }

    public void btnSupplierDirectoryOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.SUPPLIER_DIRECTORY,brdrPaneInventory);
    }

    public void btnViewNotesOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STORE_NOTES, brdrPaneInventory);
    }

    public void btnViewStaticsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STORE_STATISTICS,brdrPaneInventory);
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout Conformation");
        alert.setContentText("Do you want to logout?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.equals(null)){
            Navigation.navigate(Routes.INVENTORY,brdrPaneInventory);
        }else if (result.get()==ButtonType.OK){
            Navigation.navigate(Routes.LOGIN,brdrPaneInventory);
        }else if (result.get()==ButtonType.CANCEL){
            Navigation.navigate(Routes.INVENTORY,brdrPaneInventory);
        }
    }

    public void btnInventoryOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.INVENTORY,brdrPaneInventory);
    }

    public void btnClickHamburgerOnAction(ActionEvent actionEvent) {
    }

    public void btnAddNewOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.NEW_STOCK,brdrPaneInventory);
    }

    public void btnRemoveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        int selectedRow = tblStockData.getSelectionModel().getSelectedIndex();
        CurrentStockTM selectedItem = tblStockData.getSelectionModel().getSelectedItem();
        String stockId = selectedItem.getStockId();
        stockBOImpl.deleteStock(stockId);
        tblStockData.getItems().remove(selectedItem);
    }

    public void btnEditOnAction(ActionEvent actionEvent) throws IOException {
        //Navigation.navigate(Routes.EDIT_STOCK_DETAILS,brdrPaneInventory);
    }

    public void btnPrintReport(ActionEvent actionEvent) {

        InputStream inputStream = this.getClass().getResourceAsStream("/lk/ijse/finalproject/report/StockEvaluation.jrxml");

        try {

            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null, DBConnection.getInstance().getConnection());
            // JasperPrintManager.printReport(jasperPrint,true);
            JasperViewer.viewReport(jasperPrint,false);

        } catch (JRException | SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void btnCreateMrnOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CREATE_MRN,brdrPaneInventory);
    }

    public void txtSearchOnAction(ActionEvent actionEvent) {
        btnSearchOnAction(actionEvent);
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
    }

    public void btnQuotationOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.QUOTATION,brdrPaneInventory);
    }

    public void btnPurchaseOrderOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PURCHASE_ORDER,brdrPaneInventory);
    }
}
