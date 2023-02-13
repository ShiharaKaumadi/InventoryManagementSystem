package lk.ijse.finalproject.util;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.io.IOException;

public class Navigation {
    private static BorderPane pane;

    public static void navigate(Routes route, BorderPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage)Navigation.pane.getScene().getWindow();

        switch (route) {
            case HAMBURGER:
                window.setTitle("Dashboard");
                initUI("ClickHamburgerDashboardForm.fxml");
                break;

            case CLICKED_HAMBURGER:
                window.setTitle("Dashboard");
                initUI("DashboardForm.fxml");
                break;

            case USERNAME_ERROR:
                window.setTitle("Error Login");
                initUI("UserNameErrorLoginForm.fxml");
                break;

            case PASSWORD_ERROR:
                window.setTitle("Error Login");
                initUI("PasswordErrorLoginForm.fxml");
                break;

            case PASSWORD_RESET:
                window.setTitle("Reset Password");
                initUI("ResetPasswordForm.fxml");
                break;

            case LOGIN:
                window.setTitle("Login");
                initUI("LoginForm.fxml");
                break;

            case DASHBOARD:
                window.setTitle("Dashboard");
                initUI("DashboardForm.fxml");
                break;

            case CLICK_DASHBOARD:
                window.setTitle("Dashboard Form");
                initUI("ClickHamburgerDashboardForm.fxml");
                break;

            case MANAGE_EMPLOYEE:
                window.setTitle("Manage Employee");
                initUI("ManageEmployeeForm.fxml");
                break;

            case CLICK_MANAGE_EMPLOYEE:
                window.setTitle("Manage Employee");
                initUI("ClickHamburgerManageEmployeeForm.fxml");
                break;

            case HAM_MANAGE_EMPLOYEE:
                window.setTitle("Manage Employee");
                initUI("ManageEmployeeForm.fxml");
                break;

            case CLICK_HAM_MANAGE_EMPLOYEE:
                window.setTitle("Manage Employee");
                initUI("ClickHamburgerManageEmployeeForm.fxml");
                break;
            case STORE_DASHBOARD:
                window.setTitle("Dashboard");
                initUI("StoreDashboardForm.fxml");
                break;

            case SUPPLIER_DIRECTORY:
                window.setTitle("Supplier Directory");
                initUI("SupplierDirectoryForm.fxml");
                break;

            case INVENTORY:
                window.setTitle("Inventory");
                initUI("InventoryAtStoreForm.fxml");
                break;

            case SUPPLIER_ACCOUNT:
                window.setTitle("Supplier Account");
                initUI("SupplierAccountForm.fxml");
                break;

            case STORE_NOTES:
                window.setTitle("View Notes");
                initUI("NotesForm.fxml");
                break;

            case NEW_STOCK:
                window.setTitle("Add Stock");
                initUI("AddNewStockForm.fxml");
                break;

            case EDIT_STOCK_DETAILS:
                window.setTitle("Edit Stock Details");
                initUI("EditStockForm.fxml");
                break;

            case CREATE_MRN:
                window.setTitle("Create Note");
                initUI("NotesForm.fxml");
                break;
            case HAM_STORE:
                window.setTitle("Add Stock");
                initUI("ClickHamburgerAddNewStockForm.fxml");
                break;
            case QUOTATION:
                window.setTitle("Quotation Form");
                initUI("QuotationForm.fxml");
                break;
            case PURCHASE_ORDER:
                window.setTitle("Purchase Order Form");
                initUI("PurchaseOrderForm.fxml");
                break;
            case CLICK_HAM_STORE:
                window.setTitle("Add Stock");
                initUI("AddNewStockForm.fxml");
                break;

            case HAM_SUPPLIER:
                window.setTitle("Supplier Account Form");
                initUI("ClickHamburgerSupplierAccountForm");
                break;

            case CASHIER_DASHBOARD:
                window.setTitle("Place Order Form");
                initUI("CashierDashboardForm.fxml");
                break;

            case ITEM:
                initUI("ItemForm.fxml");
                break;

            case NEW_CUSTOMER:
                window.setTitle("Customer Account");
                initUI("CustomerAccountForm.fxml");
                break;

            case EXPENSES:
                window.setTitle("Expenses");
                initUI("ExpensesForm.fxml");
                break;

            case ADD_EMPLOYEE:
                window.setTitle("Add Employee");
                initUI("EmployeeAccountForm.fxml");
                break;

            case MANAGEMENT_NOTES:
                window.setTitle("View Notes");
                initUI("ViewNotesForm.fxml");
                break;
            case RETURNS:
                window.setTitle("Returns");
                initUI("ReturnsForm.fxml");
                break;

            default:
                Notifications notifications = Notifications.create().text("UI Not Found").title("Error").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                notifications.showWarning();
        }
    }
    public static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/ijse/finalproject/views/" + location)));
    }
}
