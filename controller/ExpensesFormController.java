package lk.ijse.finalproject.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import lk.ijse.finalproject.bo.custom.BOFactory;
import lk.ijse.finalproject.bo.custom.BOTypes;
import lk.ijse.finalproject.bo.custom.ExpensesBO;
import lk.ijse.finalproject.dao.custom.ExpensesDAO;
import lk.ijse.finalproject.dao.custom.impl.ExpensesDAOImpl;
import lk.ijse.finalproject.db.DBConnection;
import lk.ijse.finalproject.dto.ExpensesDTO;
import lk.ijse.finalproject.entity.Expenses;
import lk.ijse.finalproject.util.Navigation;
import lk.ijse.finalproject.util.Routes;
import lk.ijse.finalproject.views.tm.ExpensesTM;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class ExpensesFormController {
    public BorderPane brdExpenses;
    public Label lblOrderID;
    public JFXButton btnDashboard;
    public JFXButton btnNewCustomer;
    public JFXButton btnExpenses;
    public JFXButton btnIncome;
    public JFXButton btnLogout;
    public Label lblBalance;
    public JFXCheckBox chkPayStatus;
    public Label lblTotal;
    public TableColumn<ExpensesTM, Double> colAmount;
    public TableColumn<ExpensesTM, LocalDate> colDate;
    public TableColumn<ExpensesTM, String> colCashierId;
    public TableColumn<ExpensesTM, String> colDescription;
    public TableColumn<ExpensesTM, String> colExpId;
    public TableView<ExpensesDTO> tblExpData;
    public JFXDatePicker dtDate;
    public JFXTextField txtAmount;
    public JFXTextField txtCashierId;
    public JFXTextField txtDescription;
    public JFXTextField txtExpId;
    public Label lblExpId;
    public TextField txtSearch;
    ObservableList<ExpensesDTO> tmList = FXCollections.observableArrayList();
    ExpensesBO expensesBO = (ExpensesBO) BOFactory.getBoFactory().getBO(BOTypes.EXPENSES);
    private ExpensesDTO expenses;

    public void initialize() {

        setCellValueFactory();
        loadExpensesTblData();
        loadNextExpenseId();
        loadExpenseTotal();

    }

    private void loadExpenseTotal() {
        try {
            double expenses= expensesBO.collectTotalExpenses();
            lblTotal.setText(String.valueOf(expenses));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    private void setCellValueFactory() {
        colExpId.setCellValueFactory(new PropertyValueFactory("expId"));
        colDescription.setCellValueFactory(new PropertyValueFactory("description"));
        colCashierId.setCellValueFactory(new PropertyValueFactory("cashierId"));
        colDate.setCellValueFactory(new PropertyValueFactory("date"));
        colAmount.setCellValueFactory(new PropertyValueFactory("amount"));
    }

    private void loadExpensesTblData() {
        ArrayList<ExpensesDTO> expenses = null;
        try {
            expenses = expensesBO.getAllExpenses();
            for (ExpensesDTO exp : expenses) {
                ExpensesDTO expenses1 = new ExpensesDTO(exp.getExpId(), exp.getDescription(), exp.getCashierId(), exp.getDate(), exp.getAmount());
                tmList.add(expenses1);

                tblExpData.setItems(tmList);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    private void loadNextExpenseId() {
        String expId = null;
        try {
            expId = expensesBO.getNextExpenseId();
            lblExpId.setText(expId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void btnDashboardOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CASHIER_DASHBOARD, brdExpenses);
    }

    public void btnNewCustomerOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.NEW_CUSTOMER,brdExpenses);
    }

    public void btnExpensesOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.EXPENSES, brdExpenses);
    }

    public void btnIncomeOnAction(ActionEvent actionEvent) {
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setContentText("Are you sure you want to logout ?");
        Optional <ButtonType> result = alert.showAndWait();
        if (result.equals(null)){
            Navigation.navigate(Routes.EXPENSES, brdExpenses);
        } else if (result.get()==ButtonType.OK) {
            Navigation.navigate(Routes.LOGIN, brdExpenses);
        }else if (result.get()==ButtonType.CANCEL){
            Navigation.navigate(Routes.EXPENSES, brdExpenses);
        }
    }

    public void btnEnterOnAction(ActionEvent actionEvent) {
        String expId = lblExpId.getText();
        String description = txtDescription.getText();
        String cashierId = txtCashierId.getText();
        LocalDate date = dtDate.getValue();
        double amount = Double.parseDouble(txtAmount.getText());


        ExpensesDTO expenses = new ExpensesDTO(expId, description, cashierId, date, amount);
        ObservableList<ExpensesDTO> expenses1 = tblExpData.getItems();

        boolean isDateMatched = String.valueOf(date).matches("^[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{4}$");
        boolean isExpIdMatched = expId.matches("^EXP-\\d{1,}$");
        boolean isDescriptionMatched = description.matches("^[a-zA-Z][a-zA-Z\\s]{0,40}$");
        boolean isCashierIdMatched = cashierId.matches("^C-3\\d{2}$");
        boolean isAmountMatched = String.valueOf(amount).matches("^[1-9][\\d]{1,4}.[0-9]{1,2}$");

        boolean isAdded = false;

        if (isExpIdMatched) {
            if (isDescriptionMatched) {
                if (isCashierIdMatched) {
                    if (isAmountMatched) {
                        try {
                            isAdded = expensesBO.addExpenseDetails(expenses);
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Add Expense");
                            alert.setContentText("Are you sure you want to add new Expense ?");
                            Optional <ButtonType> result = alert.showAndWait();
                            if (result.equals(null)){
                                Navigation.navigate(Routes.EXPENSES,brdExpenses);
                            }else if (result.get()==ButtonType.OK) {
                                if (isAdded) {
                                    expenses1.add(expenses);
                                    tblExpData.setItems(expenses1);
                                    double text = Double.parseDouble(lblTotal.getText());

                                    lblTotal.setText(String.valueOf(text));
                                    try {
                                        double expenseAmount= expensesBO.collectTotalExpenses();
                                        lblTotal.setText(String.valueOf(expenseAmount));
                                    } catch (SQLException e) {
                                        throw new RuntimeException(e);
                                    } catch (ClassNotFoundException e) {
                                        throw new RuntimeException(e);
                                    }
                                    Notifications notifications = Notifications.create().text("Expense Added Successfuly").title("Add Expense").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                                    notifications.showInformation();
                                } else {
                                    Notifications notifications = Notifications.create().text("Expense Not Added.").title("Saving Error").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                                    notifications.showWarning();
                                }
                            }else if (result.get()==ButtonType.CANCEL){
                                Navigation.navigate(Routes.EXPENSES,brdExpenses);
                            }
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        } catch (ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        txtAmount.setFocusColor(Paint.valueOf("Red"));
                        txtAmount.requestFocus();
                    }
                } else {
                    txtCashierId.setFocusColor(Paint.valueOf("Red"));
                    txtCashierId.requestFocus();
                }
            } else {
                txtDescription.setFocusColor(Paint.valueOf("Red"));
                txtDescription.requestFocus();
            }
        } else {
            txtExpId.setFocusColor(Paint.valueOf("Red"));
            txtExpId.requestFocus();
        }

    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        loadNextExpenseId();
        txtDescription.setText("");
        txtCashierId.setText("");
        dtDate.setValue(null);
        txtAmount.setText("");
    }

    public void btnEditOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        String expId = lblExpId.getText();
        String description = txtDescription.getText();
        String cashierId = txtCashierId.getText();
        LocalDate date = dtDate.getValue();
        double amount = Double.parseDouble(txtAmount.getText());
        ExpensesDTO expenses = new ExpensesDTO(expId, description, cashierId, date, amount);
        ObservableList<ExpensesDTO> expenses1 = tblExpData.getItems();


        boolean isDateMatched = String.valueOf(date).matches("^[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{4}$");
        boolean isExpIdMatched = expId.matches("^EXP-\\d{1,}$");
        boolean isDescriptionMatched = description.matches("^[a-zA-Z][a-zA-Z\\s]{0,40}$");
        boolean isCashierIdMatched = cashierId.matches("^C-3\\d{2}$");
        boolean isAmountMatched = String.valueOf(amount).matches("^[1-9][\\d]{1,4}.[0-9]{1,2}$");

        boolean isUpdated;
        if (isExpIdMatched) {
            if (isDescriptionMatched) {
                if (isCashierIdMatched) {
                    if (isAmountMatched) {
                        try {
                            isUpdated = expensesBO.updateExpenseDetail(expenses);
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Edit Expense");
                            alert.setContentText("Are you sure you want to edit details ?");
                            Optional<ButtonType> result = alert.showAndWait();
                            if (result.equals(null)) {
                                Navigation.navigate(Routes.EXPENSES, brdExpenses);
                            } else if (result.get() == ButtonType.OK) {
                                if (isUpdated) {
                                    int selectedIndex = tblExpData.getSelectionModel().getSelectedIndex();
                                    tblExpData.getItems();


                                    Notifications notifications = Notifications.create().title("Edit Details").text("Expense record Updated").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                                    notifications.showInformation();


                                } else {
                                    Notifications notifications = Notifications.create().title("Edit Details").text("Not Updated").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                                    notifications.showInformation();
                                }
                            } else if (result.get() == ButtonType.CANCEL) {
                                Navigation.navigate(Routes.EXPENSES, brdExpenses);
                            }

                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        } catch (ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }

                    } else {
                        txtAmount.setFocusColor(Paint.valueOf("Red"));
                        txtAmount.requestFocus();
                    }
                } else {
                    txtCashierId.setFocusColor(Paint.valueOf("Red"));
                    txtCashierId.requestFocus();
                }
            } else {
                txtDescription.setFocusColor(Paint.valueOf("Red"));
                txtDescription.requestFocus();
            }
        } else {
            txtExpId.setFocusColor(Paint.valueOf("Red"));
            txtExpId.requestFocus();
        }

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String id = lblExpId.getText();
        boolean isDeleted;
        try {
            isDeleted = expensesBO.deleteExpense(id);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Expense");
            alert.setContentText("Are you sure you want to delete details ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.equals(null)) {
                Navigation.navigate(Routes.EXPENSES, brdExpenses);
            } else if (result.get() == ButtonType.OK) {
                if (isDeleted) {
                    int selectedIndex = tblExpData.getSelectionModel().getSelectedIndex();
                    tblExpData.getItems().remove(selectedIndex);
                    Notifications notifications = Notifications.create().text("Expense Details Deleted.").title("Delete ").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                    notifications.showInformation();
                } else {
                    Notifications notifications = Notifications.create().text("Expense Details Not Found.").title("Error").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                    notifications.showError();
                }
            } else if (result.get() == ButtonType.CANCEL) {
                Navigation.navigate(Routes.EXPENSES, brdExpenses);
            }


        } catch (ClassNotFoundException e) {
            Notifications notifications = Notifications.create().text("Driver Not Found.").title("ClassNotFound Exception").position(Pos.CENTER).hideAfter(Duration.seconds(3));
            notifications.showError();

        } catch (SQLException e) {
            Notifications notifications = Notifications.create().text("Customer Not Identified").title("Warning").position(Pos.CENTER).hideAfter(Duration.seconds(3));
            notifications.showError();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnGenerateExpenseReportOnAction(ActionEvent actionEvent) {
        try {
            expensesBO.btnGenerateExpenseReportOnAction(actionEvent);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
//        HashMap <String, Object> hashMap = new HashMap<>();
////        hashMap.put("expId",lblExpId.getText());
////        hashMap.put("description",txtDescription.getText());
////        hashMap.put("date",dtDate.getValue());
////        hashMap.put("amount",txtAmount.getText());
//        InputStream inputStream = this.getClass().getResourceAsStream("/lk/ijse/finalproject/report/Expenses.jrxml");
//        try {
//            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());
//            JasperPrintManager.printReport(jasperPrint, false);
//            //JasperPrintManager.printReport(jasperPrint,true); //print hardcopy
//            JasperViewer.viewReport(jasperPrint);
//
//        } catch (JRException e) {
//            throw new RuntimeException(e);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
    }

    public void btnViewSummaryOnAction(ActionEvent actionEvent) {
    }

    public void txtSearchOnAction(ActionEvent actionEvent) {
        btnSearchOnAction(actionEvent);
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        String id = txtSearch.getText();
        ExpensesDTO expenses = null;
        try {
            expenses = expensesBO.searchExpense(id);
            if (expenses != null) {
                fillData(expenses);

            } else {
                Notifications notifications = Notifications.create().text("Not Found").title("Search Id").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                notifications.showInformation();
                lblExpId.setText("");
                txtDescription.setText("");
                txtCashierId.setText("");
                dtDate.setValue(null);
                txtAmount.setText("");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }

    }

    private void fillData(ExpensesDTO expenses) {
        lblExpId.setText(expenses.getExpId());
        txtDescription.setText(expenses.getDescription());
        txtCashierId.setText(expenses.getCashierId());
        dtDate.setValue(expenses.getDate());
        txtAmount.setText(String.valueOf(expenses.getAmount()));
    }

    public void btnReturnOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.RETURNS,brdExpenses);
    }

    public void tblDataOnMouseClick(MouseEvent mouseEvent) {
        expenses = tblExpData.getSelectionModel().getSelectedItem();
        if (expenses != null) {
            lblExpId.setText(expenses.getExpId());
            txtDescription.setText(expenses.getDescription());
            txtCashierId.setText(expenses.getCashierId());
            dtDate.setValue(expenses.getDate());
            txtAmount.setText(String.valueOf(expenses.getAmount()));
        }
    }
}
