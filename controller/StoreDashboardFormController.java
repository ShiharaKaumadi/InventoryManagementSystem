package lk.ijse.finalproject.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import lk.ijse.finalproject.bo.custom.BOFactory;
import lk.ijse.finalproject.bo.custom.BOTypes;
import lk.ijse.finalproject.bo.custom.StockBO;
import lk.ijse.finalproject.dao.custom.StockDAO;
import lk.ijse.finalproject.dao.custom.SupplierDAO;
import lk.ijse.finalproject.dao.custom.impl.StockDAOImpl;
import lk.ijse.finalproject.dao.custom.impl.SupplierDAOImpl;
import lk.ijse.finalproject.dto.StockDTO;
import lk.ijse.finalproject.util.Navigation;
import lk.ijse.finalproject.util.Routes;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;

public class StoreDashboardFormController {

    public LineChart chrtStockValueVariation;
    public Label lblWastageValue;
    public Label lblTotalSuppliers;
    public Label lblStockValue;
    public Text lblTime;
    public GridPane gridPane;
    public AnchorPane anchorPane;
    @FXML
    private BorderPane brdrStoreDashboard;

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
    NumberAxis xAxis = new NumberAxis();
    NumberAxis yAxis = new NumberAxis();
    XYChart.Series series = new XYChart.Series<>();
    StockBO stockBOImpl = (StockBO) BOFactory.getBoFactory().getBO(BOTypes.STOCK);
    SupplierDAO supplierDAOImpl = new SupplierDAOImpl();
    ArrayList <StockDTO> stockAtStoreArrayList = new ArrayList<>();

    public void initialize() throws SQLException, ClassNotFoundException {
        loadStockVariationData();
        loadStockValue();
        loadCurrentTime();
        loadSupplierCount();
        ArrayList<StockDTO> notAvailableItemList = stockBOImpl.getNotAvailableItemList();
        notAvailableItemList.addAll(getData());
        System.out.println(notAvailableItemList.size());
        int column=0;
        int row =1;

        try {
            for(int i=0; i<notAvailableItemList.size();i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/lk/ijse/finalproject/views/BelowPreOrderItemForm.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                BelowPreOrderItemFormController itemFormController=fxmlLoader.getController();
                itemFormController.setData(notAvailableItemList.get(i));

                if(column ==1){
                    column =0;
                    row++;
                }
                gridPane.add(anchorPane,column,row++);
                gridPane.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridPane.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridPane.setMaxWidth(Region.USE_COMPUTED_SIZE);

                gridPane.setMaxHeight(Region.USE_COMPUTED_SIZE);
                gridPane.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridPane.setMaxHeight(Region.USE_COMPUTED_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private ArrayList <StockDTO> getData() throws SQLException, ClassNotFoundException {
        ArrayList<StockDTO> notAvailableItemList = new ArrayList<>();
        // System.out.println(stockAtStoreArrayList);
        for(StockDTO stockAtStore1 : notAvailableItemList){

                StockDTO stockAtStore2 = new StockDTO(stockAtStore1.getItemDescription(), stockAtStore1.getQtyOnHand());
                stockAtStoreArrayList.add(stockAtStore2);

        }
        return stockAtStoreArrayList  ;
    }

    private ArrayList <StockDTO> setData(){
        ArrayList <StockDTO> stockAtStoreArrayList = new ArrayList<>();
        for(StockDTO stockAtStore1 :stockAtStoreArrayList){
            StockDTO stockAtStore2 = new StockDTO(stockAtStore1.getItemDescription(),stockAtStore1.getQtyOnHand());
            stockAtStoreArrayList.add(stockAtStore2);

        }
        return stockAtStoreArrayList;
    }
    private void loadSupplierCount() {
        String count=null;
        try {
            count =supplierDAOImpl.count();
            lblTotalSuppliers.setText(String.valueOf(count));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadCurrentTime() {
        LocalTime time = LocalTime.now();

        if (time.isAfter(LocalTime.NOON)){
            lblTime.setText(time.getHour()+"."+time.getMinute()+" PM");
        }else{
            lblTime.setText(time.getHour()+"."+time.getMinute()+" AM");
        }
    }

    private void loadStockValue() {
        try {
            double stockValue= stockBOImpl.collectStockValue();
            lblStockValue.setText(String.valueOf(stockValue));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadStockVariationData() {
        xAxis.setLabel("Date");
        yAxis.setLabel("Stock Value");
        series.setName("Stock Value Variation");
        ArrayList<StockDTO> orderDTOArrayList = null;
        try {
            orderDTOArrayList= stockBOImpl.getStockValuePerEachItem();
            for (StockDTO stockDTO: orderDTOArrayList){
                StockDTO stockDTO1 = new StockDTO(stockDTO.getItemDescription(),stockDTO.getQtyOnHand(),stockDTO.getUnitRate(),stockDTO.getStockValue());
                series.getData().add(new XYChart.Data<>(stockDTO1.getItemDescription(),stockDTO1.getStockValue()));
            }
            chrtStockValueVariation.getData().add(series);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void BtnSupplierDirectoryOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.SUPPLIER_DIRECTORY,brdrStoreDashboard);

    }

    @FXML
    void btnClickHamburgerOnAction(ActionEvent event) {

    }

    @FXML
    void btnHomeOnAction(ActionEvent event) throws IOException {
    Navigation.navigate(Routes.STORE_DASHBOARD,brdrStoreDashboard);
    }

    @FXML
    void btnInventoryOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.INVENTORY,brdrStoreDashboard);
    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) {

    }

    @FXML
    void btnProfileSettingsOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.QUOTATION,brdrStoreDashboard);

    }

    @FXML
    void btnViewNotesOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.STORE_NOTES,brdrStoreDashboard);
    }

    @FXML
    void btnViewStaticsOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.STORE_STATISTICS,brdrStoreDashboard);
    }

    public void btnPurchaseOrderOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PURCHASE_ORDER,brdrStoreDashboard);
    }
}

