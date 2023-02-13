package lk.ijse.finalproject.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import lk.ijse.finalproject.bo.custom.*;
import lk.ijse.finalproject.bo.custom.impl.ExpensesBoImpl;
import lk.ijse.finalproject.dao.custom.ExpensesDAO;
import lk.ijse.finalproject.dao.custom.OrderDAO;
import lk.ijse.finalproject.dao.custom.OrderDetailDAO;
import lk.ijse.finalproject.dao.custom.impl.ExpensesDAOImpl;
import lk.ijse.finalproject.dao.custom.impl.OrderDAOImpl;
import lk.ijse.finalproject.dao.custom.impl.OrderDetailDAOImpl;
import lk.ijse.finalproject.dto.OrderDTO;

import lk.ijse.finalproject.dto.OrderDetailDTO;
import lk.ijse.finalproject.dto.StockDTO;
import lk.ijse.finalproject.util.Navigation;
import lk.ijse.finalproject.util.Routes;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;


public class DashboardFormController {
    public TextField txtSearchBar;
    public Pane paneSales;
    public Label lblTodayIncome;
    public Label lblTotalSales;

    public Pane paneSearchBar;
    public JFXButton btnViewStatics;
    public JFXButton btnLogout;
    public Pane paneTopSelling;
    public Pane paneTrend;
    public Label lblTrend1;
    public Label lblPrice1;
    public Pane paneTrend1;
    public Label lblTrend2;
    public Label lblPrice12;
    public Pane paneTrend2;
    public Label lblTrend3;
    public Label lblPrice3;
    public Pane paneTrend3;
    public Label lblTrend4;
    public Label lblPrice4;
    public Pane paneIncomeVariation;
    public Pane paneCustomer;
    public Label lblCustomers;
    public Pane paneTotalSales;
    public Pane pane;
    public JFXButton btnHamburger;
    public Pane paneSearchBar1;
    public ComboBox cmbFilter;
    public Label lblRevenue;
    public Label lblExpense;
    public LineChart chrtIncome;
    public Label lblProfit;
    public Label lblTime;
    public AnchorPane anchorPane;
    public GridPane gridPane;
    public Label lblIncome;
    public AreaChart chartStockVariation;
    public AreaChart chartIncome;
    public Label lblExpenses;
    public Pane paneLoss;
    public AreaChart chartExpenseVariation;
    public Pane paneExpenses;
    public Label lblLoss;
    @FXML
    private BorderPane brdrPaneRegisterEmployee;

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
    private JFXButton btnRegisterEmployee;

    @FXML
    private JFXButton btnViewNotes;

    @FXML
    private JFXButton btnViewNotes1;

    @FXML
    private Pane paneEmployee;
    NumberAxis xAxis = new NumberAxis();
    NumberAxis yAxis = new NumberAxis();
    ExpensesBO expensesBOImpl = (ExpensesBO) BOFactory.getBoFactory().getBO(BOTypes.EXPENSES);
    OrderBO orderBOImpl = (OrderBO) BOFactory.getBoFactory().getBO(BOTypes.ORDER);
    OrderDetailBO orderDetailBOImpl = (OrderDetailBO) BOFactory.getBoFactory().getBO(BOTypes.ORDER_DETAIL);

    public void initialize() throws SQLException, ClassNotFoundException {
        loadExpenses();
        loadIncome();
        loadIncomeData();
        loadProfit();
        loadCurrentTime();
        //loadTopSellingProductList();
        ArrayList<OrderDetailDTO> topSellingItemList = orderDetailBOImpl.getTopSellingItemOrder();
        topSellingItemList.addAll(getData());
        System.out.println(topSellingItemList.size());
        int column=0;
        int row =1;

        try {
            for(int i=0; i<topSellingItemList.size();i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/lk/ijse/finalproject/views/TopSellingItemForm.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                TopSellingItemFormController itemFormController=fxmlLoader.getController();
                itemFormController.setData(topSellingItemList.get(i));

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
    private ArrayList <OrderDetailDTO> getData() throws SQLException, ClassNotFoundException {
        ArrayList<OrderDetailDTO> topItemList = new ArrayList<>();
        // System.out.println(stockAtStoreArrayList);
        for(OrderDetailDTO orderDetailDTO : topItemList){

            OrderDetailDTO stockAtStore2 = new OrderDetailDTO(orderDetailDTO.getDescription(), orderDetailDTO.getQty());
            topItemList.add(stockAtStore2);

        }
        return topItemList  ;

    }

    private void loadTopSellingProductList() {
        double [] array =new double[4];
        ArrayList<OrderDetailDTO> topSellingItemOrder = null;
        try {
            topSellingItemOrder = orderDetailBOImpl.getTopSellingItemOrder();
            System.out.println(topSellingItemOrder);
            for (OrderDetailDTO order: topSellingItemOrder) {
//                OrderDetailDTO orderDetailDTO =new OrderDetailDTO(order.getDescription(),order.getUnitPrice());

                System.out.println(order.getDescription());
                lblTrend1.setText(order.getDescription());
                lblPrice1.setText(String.valueOf(order.getUnitPrice()));
            }
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

    private void loadProfit() {
        double revenue = Double.parseDouble(lblRevenue.getText());
        double expense = Double.parseDouble(lblExpense.getText());
        double profitOrLoss = revenue-expense;
        lblProfit.setText(String.valueOf(profitOrLoss));
    }

    private void loadIncomeData() {
        xAxis.setLabel("Date");
        yAxis.setLabel("Revenue");
        XYChart.Series series = new XYChart.Series<>();
        series.setName("Income Variation");
        ArrayList <OrderDTO> orderDTOArrayList = null;
        try {
            orderDTOArrayList= orderBOImpl.getTotalIncome();
            for (OrderDTO orderDTO: orderDTOArrayList){
                OrderDTO orderDTO1 = new OrderDTO(orderDTO.getOrderId(),orderDTO.getDate(),orderDTO.getTime(),orderDTO.getTotalAmount(),orderDTO.getCustomerId());
                series.getData().add(new XYChart.Data<>(String.valueOf(orderDTO1.getDate()),orderDTO1.getTotalAmount()));
            }
            chrtIncome.getData().add(series);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadExpenses() {
        try {
            double expenses= expensesBOImpl.collectTotalExpenses();
            lblExpense.setText(String.valueOf(expenses));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private void loadIncome() {
        try {
            double income= orderDetailBOImpl.collectTotalIncomeValue();
            lblRevenue.setText(String.valueOf(income));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnHomeOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.DASHBOARD,brdrPaneRegisterEmployee);
    }

    @FXML
    void btnRegisterEmployeeOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.MANAGE_EMPLOYEE,brdrPaneRegisterEmployee);
    }

    @FXML
    void btnViewNotesOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.MANAGEMENT_NOTES,brdrPaneRegisterEmployee);
    }

    public void btnProfileSettingsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PROFILE_SETTINGS,brdrPaneRegisterEmployee);
    }

    public void btnViewStaticsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.VIEW_STATISTICS,brdrPaneRegisterEmployee);
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout Conformation");
        alert.setContentText("Do you want to logout?");
        Optional <ButtonType> result = alert.showAndWait();
        if (result.equals(null)){
            Navigation.navigate(Routes.DASHBOARD,brdrPaneRegisterEmployee);
        }else if (result.get()==ButtonType.OK){
            Navigation.navigate(Routes.LOGIN,brdrPaneRegisterEmployee);
        }else if (result.get()==ButtonType.CANCEL){
            Navigation.navigate(Routes.DASHBOARD,brdrPaneRegisterEmployee);
        }



    }



    public void btnClickHamburgerOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.HAMBURGER, brdrPaneRegisterEmployee);
    }
}
