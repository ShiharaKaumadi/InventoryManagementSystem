package lk.ijse.finalproject.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
import lk.ijse.finalproject.dto.StockDTO;
import lk.ijse.finalproject.util.Navigation;
import lk.ijse.finalproject.util.Routes;
import lk.ijse.finalproject.views.tm.CurrentStockTM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class CurrentStockDetailsFormController {
    public BorderPane brdPaneCurrentStock;
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
    public TableColumn<CurrentStockTM, String> colStockId;
    public TableColumn<CurrentStockTM, String> colDescription;
    public TableColumn<CurrentStockTM, String> colMeasuredUnits;
    public TableColumn<CurrentStockTM, Double> colQtyOnHand;
    public TableColumn<CurrentStockTM, Double> colUnitRate;
    public TableColumn<CurrentStockTM, Double> colStockValue;
    public TableColumn<CurrentStockTM, String> colCategory;
    public TableColumn<CurrentStockTM, String> colSubCategory;
    public TableColumn<CurrentStockTM, String> colBrandName;
    public TableColumn<CurrentStockTM, Label> colPreOrderLevel;
    public TableView <CurrentStockTM> tblStockData;
    static ArrayList<StockDTO> list= new ArrayList<>();
    public BorderPane brdrPaneAddNewStock;
    public ComboBox cmbFilter;
    ObservableList <CurrentStockTM> tmObservableList = FXCollections.observableArrayList();
    ArrayList  <StockDTO> stockAtStore = null;
    StockBO stockBOImpl = (StockBO) BOFactory.getBoFactory().getBO(BOTypes.STOCK);

    public void initialize(){
        colStockId.setCellValueFactory(new PropertyValueFactory<>("stockId"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("stockDescription"));
        colMeasuredUnits.setCellValueFactory(new PropertyValueFactory<>("measuredUnits"));
        colQtyOnHand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        colUnitRate.setCellValueFactory(new PropertyValueFactory<>("unitRate"));
        colStockValue.setCellValueFactory(new PropertyValueFactory<>("stockValue"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colSubCategory.setCellValueFactory(new PropertyValueFactory<>("subCategory"));
        colBrandName.setCellValueFactory(new PropertyValueFactory<>("brandName"));
        colPreOrderLevel.setCellValueFactory(new PropertyValueFactory<>("label"));

        loadAllData();
    }

    private void loadAllData() {


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
                tmObservableList.add(tm);
                tblStockData.setItems(tmObservableList);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }







    }

    public void btnHomeOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STORE_DASHBOARD,brdPaneCurrentStock);
    }

    public void btnProfileSettingsOnAction(ActionEvent actionEvent) {
    }

    public void BtnSupplierDirectoryOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.SUPPLIER_DIRECTORY,brdPaneCurrentStock);
    }

    public void btnViewNotesOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STORE_NOTES,brdPaneCurrentStock);
    }

    public void btnViewStaticsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STORE_STATISTICS,brdPaneCurrentStock);
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) {
    }

    public void btnInventoryOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.INVENTORY,brdPaneCurrentStock);
    }

    public void btnClickHamburgerOnAction(ActionEvent actionEvent) {
    }

    public void btnAddNewOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.NEW_STOCK,brdPaneCurrentStock);
    }

    public void btnRemoveOnAction(ActionEvent actionEvent) {
    }

    public void btnEditOnAction(ActionEvent actionEvent) {
    }

    public void btnPrintReport(ActionEvent actionEvent) {
    }

    public void btnCreateMrnOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STORE_NOTES,brdrPaneAddNewStock);
    }

    public void btnVerification(ActionEvent actionEvent) {
    }

    public void btnQuotationOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.QUOTATION,brdPaneCurrentStock);
    }

    public void btnPurchaseOrderOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PURCHASE_ORDER,brdPaneCurrentStock);
    }
}
