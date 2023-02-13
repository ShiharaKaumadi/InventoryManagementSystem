package lk.ijse.finalproject.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import lk.ijse.finalproject.bo.custom.*;
import lk.ijse.finalproject.bo.custom.impl.PlaceOrderBOImpl;
import lk.ijse.finalproject.dao.custom.SupplierDAO;
import lk.ijse.finalproject.dao.custom.impl.SupplierDAOImpl;
import lk.ijse.finalproject.db.DBConnection;
import lk.ijse.finalproject.dto.CustomerDTO;
import lk.ijse.finalproject.dto.OrderDetailDTO;
import lk.ijse.finalproject.dto.PlaceOrderDTO;
import lk.ijse.finalproject.dto.StockDTO;

import lk.ijse.finalproject.entity.OrderDetail;
import lk.ijse.finalproject.entity.StockAtStore;
import lk.ijse.finalproject.util.Navigation;
import lk.ijse.finalproject.util.Routes;
import lk.ijse.finalproject.views.tm.PlaceOrderTM;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;

public class CashierDashboardFormController {
    public ScrollPane scrollPane;
    public GridPane gridPane;


    public Pane paneSearchBar1;
    public TextField txtSearch;
    public Label lblTotal;
    public TextField txtCash;
    public JFXButton btnPlaceOrder;
    public Label lblBalance;

    ArrayList <StockDTO> stockAtStoreArrayList = new ArrayList<>();

    public JFXButton btnEnter;
    public ScrollPane scroll;
    public AnchorPane paneBillRecordLayout;
    public GridPane gridInvoiceNotes;
    public VBox vBoxBillRecordLayout;
    public TableColumn colItemCode;
    public TableColumn colPrice;
    public TableColumn colItemDescription;
    public TableColumn colQty;
    public TableColumn colTotal;
    public TableColumn colDelete;
    public TextField txtItemCode;
    public TextField txtQty;
    public Label lblOrderID;
    public JFXButton btnNewCustomer;
    public Label lblCustomerCount;
    public Label lblTime;
    public JFXComboBox cmbItemCode;
    public TextField txtDescription;
    public TextField txtUnitPrice;
    public Label lblDescription;
    public Label lblUnitPrice;
    public TableView tblOrderCart;
    public Label lblCustomerName;
    public JFXComboBox cmbCustomerId;
    public Label lblSubCategory;
    public Label lblBrandName;
    public Label lblCategory;
    public BorderPane brdCashierDashboard;
    public Label lblMeasuredUnits;
    public JFXButton btnLogout;
    public JFXButton btnExpenses;
    public JFXButton btnIncome;
    public JFXButton btnDashboard;


    private ObservableList<PlaceOrderTM> obList = FXCollections.observableArrayList();
    ArrayList<OrderDetail> orderDetails = new ArrayList<>();
    PlaceOrderBO placeOrderBOImpl = new PlaceOrderBOImpl();
    StockBO stockBOImpl = (StockBO) BOFactory.getBoFactory().getBO(BOTypes.STOCK);
    SupplierDAO supplierDAOImpl = new SupplierDAOImpl();
    CustomerBO customerBOImpl = (CustomerBO) BOFactory.getBoFactory().getBO(BOTypes.CUSTOMER);


    private ArrayList <StockDTO> getData(){
        ArrayList <StockDTO> stockArrayList = new ArrayList<>();
        for(StockDTO stockAtStore1 : stockArrayList){
            StockDTO stockAtStore2 = new StockDTO(stockAtStore1.getStockCode(),stockAtStore1.getItemDescription(),stockAtStore1.getUnitRate(),stockAtStore1.getQtyOnHand(),stockAtStore1.getImgSrc());
            stockAtStoreArrayList.add(stockAtStore2);

        }
        return stockAtStoreArrayList  ;
    }

    private ArrayList <StockDTO> setData(){
        ArrayList <StockDTO> stockAtStoreArrayList = new ArrayList<>();
        for(StockDTO stockAtStore1 :stockAtStoreArrayList){
            StockDTO stockAtStore2 = new StockDTO(stockAtStore1.getStockCode(),stockAtStore1.getItemDescription(),stockAtStore1.getUnitRate());
            stockAtStoreArrayList.add(stockAtStore2);

        }
        return stockAtStoreArrayList;
    }

    public void initialize() throws SQLException, ClassNotFoundException {
        loadNextOrderId();
        loadCustomerIds();
        loadItemCodes();
        loadCustomerCount();
        loadOrderTime();
        setCellValueFactory();
        setCustomerName();


        ArrayList<StockDTO> itemList = stockBOImpl.getAllStockDetails();
        itemList.addAll(getData());
        System.out.println(itemList.size());
        int column=0;
        int row =1;

            try {
                for(int i=0; i<itemList.size();i++){
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/lk/ijse/finalproject/views/ItemForm.fxml"));
                    AnchorPane anchorPane = fxmlLoader.load();
                    ItemFormController itemFormController=fxmlLoader.getController();
                    itemFormController.setData(itemList.get(i));

                    if(column ==3){
                        column =0;
                        row++;
                    }
                    gridPane.add(anchorPane,column++,row);
                    gridPane.setMinWidth(Region.USE_COMPUTED_SIZE);
                    gridPane.setPrefWidth(Region.USE_COMPUTED_SIZE);
                    gridPane.setMaxWidth(Region.USE_COMPUTED_SIZE);

                    gridPane.setMaxHeight(Region.USE_COMPUTED_SIZE);
                    gridPane.setPrefHeight(Region.USE_COMPUTED_SIZE);
                    gridPane.setMaxHeight(Region.USE_COMPUTED_SIZE);

                    GridPane.setMargin(anchorPane, new Insets(8));

                }
        } catch (IOException e) {
                e.printStackTrace();
            }

    }

    private void setCustomerName() {
    }

    private void loadCustomerIds() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> idList = placeOrderBOImpl.loadAllCustomerIds();

            for (String id : idList) {
                observableList.add(id);
            }
            cmbCustomerId.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        colItemCode.setCellValueFactory(new PropertyValueFactory("code"));
        colItemDescription.setCellValueFactory(new PropertyValueFactory("description"));
        colQty.setCellValueFactory(new PropertyValueFactory("qty"));
        colPrice.setCellValueFactory(new PropertyValueFactory("unitPrice"));
        colTotal.setCellValueFactory(new PropertyValueFactory("total"));
        colDelete.setCellValueFactory(new PropertyValueFactory("btnDelete"));
    }



    private void loadItemCodes() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> itemList = placeOrderBOImpl.collectAvailableProductCodes();

            for (String code : itemList) {
                 observableList.add(code);
            }
            cmbItemCode.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadOrderTime() {
        LocalTime time = LocalTime.now();

        if (time.isAfter(LocalTime.NOON)){
            lblTime.setText(time.getHour()+"."+time.getMinute()+" PM");
        }else{
            lblTime.setText(time.getHour()+"."+time.getMinute()+" AM");
        }
    }

    private void loadCustomerCount() {
        String count = null;
        try {
            count = placeOrderBOImpl.generateCustomerCount();
            lblCustomerCount.setText(count);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private void loadOrderDate() {
    }

    private void loadNextOrderId() {
        try {
            String orderId = placeOrderBOImpl.generateNextOrderId();
            lblOrderID.setText(orderId);
        } catch (SQLException e) {
           Notifications notifications = Notifications.create().text("Duplicate Order ID").title("Error").position(Pos.CENTER).hideAfter(Duration.seconds(3));
           notifications.showError();
        }catch (ClassNotFoundException e){
            Notifications notifications = Notifications.create().text("Class Not Found Exception").title("Error").position(Pos.CENTER).hideAfter(Duration.seconds(3));
            notifications.showError();
        }
    }


    public void btnSearchOnAction(ActionEvent actionEvent) throws IOException {
//        stockAtStoreArrayList.addAll(setData());
//        StockAtStore stockAtStore = new StockAtStore("I-2001","Colmans Toddy Vinegar",350.00);
//        StockAtStore stockAtStore2 = new StockAtStore("I-2003","Edin Mayonnaise",350.00);
//        int column=0;
//        int row =1;
//
//        try {
//            for(int i=0; i<stockAtStoreArrayList.size();i++) {
//                if (txtSearch.getText().equals(stockAtStore.getStockCode())) {
//                    FXMLLoader fxmlLoader = new FXMLLoader();
//                    fxmlLoader.setLocation(getClass().getResource("/lk/ijse/finalproject/views/ItemRecordForm.fxml"));
//                    Pane paneBillRecordLayout = fxmlLoader.load();
//                    ItemRecordFormController itemRecordFormController = fxmlLoader.getController();
//                    itemRecordFormController.setData(stockAtStoreArrayList.get(i));
//                    vBoxBillRecordLayout.getChildren().add(paneBillRecordLayout);
//                    if (column == 1) {
//                        column = 0;
//                        row++;
//                    }
//                    gridInvoiceNotes.add(paneBillRecordLayout, column++, row);
//                    gridInvoiceNotes.setMinWidth(Region.USE_COMPUTED_SIZE);
//                    gridInvoiceNotes.setPrefWidth(Region.USE_COMPUTED_SIZE);
//                    gridInvoiceNotes.setMaxWidth(Region.USE_COMPUTED_SIZE);
//
//                    gridInvoiceNotes.setMaxHeight(Region.USE_COMPUTED_SIZE);
//                    gridInvoiceNotes.setPrefHeight(Region.USE_COMPUTED_SIZE);
//                    gridInvoiceNotes.setMaxHeight(Region.USE_COMPUTED_SIZE);
//
//                    GridPane.setMargin(vBoxBillRecordLayout, new Insets(5));
//                }
//            }
//            } catch(IOException e){
//                e.printStackTrace();
//            }

    }



    public void txtSearchOnAction(ActionEvent actionEvent) {

    }

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) {

        String orderId = lblOrderID.getText();
        String customerId = String.valueOf(cmbCustomerId.getValue());

         double totalAmount = Double.parseDouble(lblTotal.getText());

         //checkBalance();



            for (int i = 0; i < tblOrderCart.getItems().size(); i++) {

                PlaceOrderTM tm = obList.get(i);
                orderDetails.add(new OrderDetail(orderId, tm.getCode(), tm.getDescription(), tm.getQty(), tm.getMeasuredUnits(), tm.getUnitPrice(), tm.getCategory(), tm.getSubCategory(), tm.getBrandName()));
            }

            PlaceOrderDTO placeOrder = new PlaceOrderDTO(customerId, orderId, totalAmount, orderDetails);
            try {
                boolean isPlaced = placeOrderBOImpl.placeOrder(placeOrder);

                    if (cmbCustomerId.getValue() != null){
                        if (txtCash.getText().matches("^[1-9][\\d]{1,4}.[0-9]{1,2}$")) {
                            if (isPlaced) {
                                //checkBalance();
                                Notifications notifications = Notifications.create().text("Order Placed ").title("Information").position(Pos.CENTER_RIGHT).hideAfter(Duration.seconds(3));
                                notifications.showConfirm();
                                txtCash.setText("");
                                lblBalance.setText("");
                                obList.clear();
                                loadNextOrderId();
                            }else{
                                Notifications notifications = Notifications.create().text("Order Not Placed ").title("Warning").position(Pos.CENTER_RIGHT).hideAfter(Duration.seconds(3));
                                notifications.showError();
                            }
                        }else {
                            Notifications notifications = Notifications.create().text("Please enter amount ").title("Warning").position(Pos.CENTER_RIGHT).hideAfter(Duration.seconds(3));
                            notifications.showError();
                        }
                    }else{
                        Notifications notifications = Notifications.create().text("Please select customer ID ").title("Warning").position(Pos.CENTER_RIGHT).hideAfter(Duration.seconds(3));
                        notifications.showError();
                    }

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }catch (NumberFormatException e){
                Notifications notifications = Notifications.create().text("Enter Qty First").title("Warning").position(Pos.TOP_RIGHT).hideAfter(Duration.seconds(3));
                notifications.showError();
            }

    }


    public void btnNewCustomerOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.NEW_CUSTOMER,brdCashierDashboard);
    }

    public void txtEnterQtyOnAction(ActionEvent actionEvent) {
        btnEnterOnAction(actionEvent);
    }

    public void btnEnterOnAction(ActionEvent actionEvent) {
        double unitPrice= Double.parseDouble(lblUnitPrice.getText());
        boolean isQtyMatched = txtQty.getText().matches("^[1-9][\\d]{1,}(.){1,}$");

            try {
                int qty = Integer.parseInt(txtQty.getText());
                double totalCost = unitPrice * qty;
                PlaceOrderTM isExists = isExists((String) cmbItemCode.getValue());
                if (isExists != null) {
                    for (PlaceOrderTM placeOrderTM : obList) {
                        if (placeOrderTM.equals(isExists)) {
                            placeOrderTM.setQty(placeOrderTM.getQty() + qty);
                            placeOrderTM.setTotal(placeOrderTM.getTotal() + totalCost);
                        }
                    }

                } else {
                    Button button = new Button("Delete");
                    PlaceOrderTM placeOrderTM = new PlaceOrderTM(String.valueOf(cmbItemCode.getValue()), lblDescription.getText(), qty, lblMeasuredUnits.getText(), unitPrice, lblCategory.getText(), lblSubCategory.getText(), lblBrandName.getText(), totalCost, button);

                    button.setOnAction(event -> {
                        for (PlaceOrderTM placeOrderTM1 : obList) {
                            if (placeOrderTM1.getCode().equals(placeOrderTM.getCode())) {
                                obList.remove(placeOrderTM1);
                                calculateNetTotal();
                            }
                        }
                    });
                    obList.add(placeOrderTM);
                    tblOrderCart.setItems(obList);

                }

                txtQty.setText("");

                tblOrderCart.refresh();
                calculateNetTotal();
            } catch (NumberFormatException |NullPointerException e) {
                Notifications notifications = Notifications.create().text("Please Enter Quantity").title("Warning").position(Pos.TOP_RIGHT).hideAfter(Duration.seconds(3));
                notifications.showError();

            }

    }

    private PlaceOrderTM isExists(String code) {
        for (PlaceOrderTM placeOrderTM:obList){
            if (placeOrderTM.getCode().equals(code)){
                return placeOrderTM;
            }
        }
        return null;
    }

    private void calculateNetTotal() {
        double netTotal = 0;
        for(PlaceOrderTM placeOrderTM:obList){
            netTotal += placeOrderTM.getTotal();
        }
        lblTotal.setText(String.valueOf(netTotal));
    }

    public void cmbItemCodeOnAction(ActionEvent actionEvent) {
        String code = String.valueOf(cmbItemCode.getValue());
        try {
            StockDTO stockDTO = placeOrderBOImpl.searchItem(code);
            fillItemFields(stockDTO);
            txtQty.requestFocus();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void fillItemFields(StockDTO stockAtStore) {
        lblDescription.setText(stockAtStore.getItemDescription());
        lblUnitPrice.setText(String.valueOf(stockAtStore.getUnitRate()));
        lblMeasuredUnits.setText(stockAtStore.getMeasuredUnits());
        lblCategory.setText(stockAtStore.getCategory());
        lblSubCategory.setText(stockAtStore.getSubCategory());
        lblBrandName.setText(stockAtStore.getBrand());

    }



    public void txtCheckBalanceOnAction(ActionEvent actionEvent) {
        try {
            lblBalance.setText(String.valueOf(Double.parseDouble(txtCash.getText()) - Double.parseDouble(lblTotal.getText())));
        }catch (NumberFormatException e){
            Notifications notifications = Notifications.create().text("Enter Cash Amount First").title("Warning").position(Pos.TOP_RIGHT).hideAfter(Duration.seconds(3));
            notifications.showError();
        }
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout Conformation");
        alert.setContentText("Are you sure you want to logout?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.equals(null)){
            Navigation.navigate(Routes.CASHIER_DASHBOARD,brdCashierDashboard);
        }else if (result.get()==ButtonType.OK){
            Navigation.navigate(Routes.LOGIN,brdCashierDashboard);
        }else if (result.get()==ButtonType.CANCEL){
            Navigation.navigate(Routes.CASHIER_DASHBOARD,brdCashierDashboard);
        }
    }

    public void btnExpensesOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.EXPENSES,brdCashierDashboard);
    }

    public void btnIncomeOnAction(ActionEvent actionEvent) {
    }

    public void btnDashboardOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CASHIER_DASHBOARD,brdCashierDashboard);
    }

    public void btnPrintOnAction(ActionEvent actionEvent) {

        InputStream inputStream = this.getClass().getResourceAsStream("/lk/ijse/finalproject/report/OrderDeailsjrxml.jrxml");


        try {

            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null, DBConnection.getInstance().getConnection());
            // JasperPrintManager.printReport(jasperPrint,true);
            JasperViewer.viewReport(jasperPrint,false);

        } catch (JRException | SQLException | ClassNotFoundException e) {
            System.out.println(e);
}

    }

    public void btnReceiptOnAction(ActionEvent actionEvent) {
    }

    public void btnReturnOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.RETURNS,brdCashierDashboard);
    }

    public void cmbCustomerIdOnAction(ActionEvent actionEvent) {
        String code = String.valueOf(cmbCustomerId.getValue());
        try {
            CustomerDTO customerDTO = customerBOImpl.searchCustomer(code);
            lblCustomerName.setText(customerDTO.getCustomerName());
            txtQty.requestFocus();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



}


