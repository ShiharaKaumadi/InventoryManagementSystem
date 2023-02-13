package lk.ijse.finalproject.controller;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import lk.ijse.finalproject.bo.custom.BOFactory;
import lk.ijse.finalproject.bo.custom.BOTypes;
import lk.ijse.finalproject.bo.custom.CustomerBO;
import lk.ijse.finalproject.dto.CustomerDTO;
import lk.ijse.finalproject.util.Navigation;
import lk.ijse.finalproject.util.Routes;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class CustomerAccountFormController {


    public BorderPane brdPaneCustomer;
    public Pane leftPane;
    public Circle userProfile;
    public Label lblUserName;
    public JFXButton btnHome;
    public JFXButton btnProfileSettings;
    public JFXButton btnManageCustomer;
    public JFXButton btnExpenses;
    public JFXButton btnGenerateIncome;
    public JFXButton btnLogout;
    public JFXButton btnHamburger;
    public Pane paneSearchBar1;
    public TextField txtSearch;
    public JFXButton btnSave;
    public Pane paneProfile;

    public JFXTextField txtAddress;
    public JFXTextField txtCashierId;
    public JFXTextField txtCustomerName;
    public JFXTextField txtEmail;
    public JFXTextField txtCustomerId;
    public JFXTextField txtContactNo;
    public JFXButton btnEdit;
    public JFXButton btnDelete;
    public JFXButton btnBack;

    CustomerBO customerBoImpl = (CustomerBO) BOFactory.getBoFactory().getBO(BOTypes.CUSTOMER);

    public void initialize() {
        loadCustomerId();
    }

    private void loadCustomerId() {
        String customerId = customerBoImpl.generateNextCustomerId();
        txtCustomerId.setText(customerId);
    }


    public void btnHomeOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CASHIER_DASHBOARD, brdPaneCustomer);
    }

    public void btnProfileSettingsOnAction(ActionEvent actionEvent) {
    }

    public void btnManageCustomerOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.NEW_CUSTOMER, brdPaneCustomer);
    }

    public void btnExpensesOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.EXPENSES, brdPaneCustomer);
    }

    public void btnGenerateIncomeOnAction(ActionEvent actionEvent) {
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout Conformation");
        alert.setContentText("Are you sure you want to logout?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.equals(null)) {
            Navigation.navigate(Routes.NEW_CUSTOMER, brdPaneCustomer);
        } else if (result.get() == ButtonType.OK) {
            Navigation.navigate(Routes.LOGIN, brdPaneCustomer);
        } else if (result.get() == ButtonType.CANCEL) {
            Navigation.navigate(Routes.NEW_CUSTOMER, brdPaneCustomer);
        }
    }

    public void btnClickHamburgerOnAction(ActionEvent actionEvent) {
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        String id = txtSearch.getText();
        try {
            CustomerDTO customer = customerBoImpl.searchCustomer(id);
            if (customer != null) {
                fillData(customer);
                txtSearch.setText("");
            } else {
                Notifications notifications = Notifications.create().title(" Search Customer").text("Customer Not Found").hideAfter(Duration.seconds(3)).position(Pos.TOP_CENTER);
                notifications.show();
                txtCustomerId.setText("");
                txtCustomerName.setText("");
                txtContactNo.setText("");
                txtEmail.setText("");
                txtCashierId.setText("");

            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void fillData(CustomerDTO customer) {
        txtCustomerId.setText(customer.getCustomerId());
        txtCustomerName.setText(customer.getCustomerName());
        txtContactNo.setText(customer.getContactNo());
        txtEmail.setText(customer.getEmail());
        txtCashierId.setText(customer.getCashierID());

    }


    public void txtSearchOnAction(ActionEvent actionEvent) {
        btnSearchOnAction(actionEvent);
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String customerId = txtCustomerId.getText();
        String name = txtCustomerName.getText();
        String contactNo = txtContactNo.getText();
        String email = txtEmail.getText();
        String cashierId = txtCashierId.getText();

        boolean isCustomerIdMatched = customerId.matches("^C-\\d{4}$");
        boolean isNameMatched = name.matches("^[a-zA-Z][a-zA-Z\\s]{0,40}$");
        boolean isContactMatched = contactNo.matches("^(070|071|072|074|075|078|077|076)([0-9]{7})$");
        boolean isEmailMatched = email.matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
        boolean isCashierIdMatched = cashierId.matches("^C-3\\d{2}$");


        CustomerDTO customer = new CustomerDTO(customerId, name, contactNo, email, cashierId);
        if (isCashierIdMatched) {
            if (isContactMatched) {
                if (isEmailMatched) {
                    if (isNameMatched) {
                        if (isCustomerIdMatched) {
                            try {
                                boolean isAdded = customerBoImpl.addCustomer(customer);
                                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                alert.setTitle("Add Customer");
                                alert.setContentText("Are you sure you want to add customer " + txtCustomerId.getText() + " ?");
                                Optional<ButtonType> result = alert.showAndWait();
                                if (result.equals(null)) {
                                    Navigation.navigate(Routes.NEW_CUSTOMER, brdPaneCustomer);
                                } else if (result.get() == ButtonType.OK) {
                                    if (isAdded) {
                                        Notifications notifications = Notifications.create().text("Customer Added Successfuly").title("Add Customer").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                                        notifications.showInformation();
                                    } else {
                                        Notifications notifications = Notifications.create().text("Customer Not Added.").title("Saving Error").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                                        notifications.showInformation();
                                    }
                                } else if (result.get() == ButtonType.CANCEL) {
                                    Navigation.navigate(Routes.NEW_CUSTOMER, brdPaneCustomer);
                                }


                            } catch (SQLException | ClassNotFoundException e) {
                                throw new RuntimeException(e);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        } else {
                            txtCustomerId.setFocusColor(Paint.valueOf("Red"));
                            txtCustomerId.requestFocus();
                        }
                    } else {
                        txtCustomerName.setFocusColor(Paint.valueOf("Red"));
                        txtCustomerName.requestFocus();
                    }
                } else {
                    txtEmail.setFocusColor(Paint.valueOf("Red"));
                    txtEmail.requestFocus();
                }
            } else {
                txtContactNo.setFocusColor(Paint.valueOf("Red"));
                txtContactNo.requestFocus();
            }
        } else {
            txtCashierId.setFocusColor(Paint.valueOf("Red"));
            txtCashierId.requestFocus();
        }

    }

    public void btnEditOnAction(ActionEvent actionEvent) {
        String id = txtCustomerId.getText();
        String name = txtCustomerName.getText();
        String contactNo = txtContactNo.getText();
        String email = txtEmail.getText();
        String cashierId = txtCashierId.getText();

        CustomerDTO customer = new CustomerDTO(id, name, contactNo, email, cashierId);
        boolean isCustomerIdMatched = id.matches("^C-\\d{4}$");
        boolean isNameMatched = name.matches("^[a-zA-Z][a-zA-Z\\s]{0,40}$");
        boolean isContactMatched = contactNo.matches("^(070|071|072|074|075|078|077|076)([0-9]{7})$");
        boolean isEmailMatched = email.matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
        boolean isCashierIdMatched = cashierId.matches("^C-3\\d{2}$");

        boolean isUpdated;
        if (isCashierIdMatched) {
            if (isContactMatched) {
                if (isEmailMatched) {
                    if (isNameMatched) {
                        if (isCustomerIdMatched) {
                            try {
                                isUpdated = customerBoImpl.updateCustomerDetails(customer);
                                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                alert.setTitle("Edit Customer Details");
                                alert.setContentText("Are you sure you want to update details of customer " + txtCustomerId.getText() + " ?");
                                Optional<ButtonType> result = alert.showAndWait();
                                if (result.equals(null)) {
                                    Navigation.navigate(Routes.NEW_CUSTOMER, brdPaneCustomer);
                                } else if (result.get() == ButtonType.OK) {
                                    if (isUpdated) {
                                        Notifications notifications = Notifications.create().text("Customer Details Updated.").title("Update Details").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                                        notifications.showInformation();
                                    } else {
                                        Notifications notifications = Notifications.create().text("Customer Details Not Updated.").title("Update Details").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                                        notifications.showError();
                                    }
                                } else if (result.get() == ButtonType.CANCEL) {
                                    Navigation.navigate(Routes.NEW_CUSTOMER, brdPaneCustomer);
                                }


                            } catch (ClassNotFoundException e) {
                                Notifications notifications = Notifications.create().text("Driver Not Found.").title("ClassNotFound Exception").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                                notifications.showError();

                            } catch (SQLException e) {
                                Notifications notifications = Notifications.create().text("Data Length is Too Large").title("Warning").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                                notifications.showError();

                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        } else {
                            txtCustomerId.setFocusColor(Paint.valueOf("Red"));
                            txtCustomerId.requestFocus();
                        }
                    } else {
                        txtCustomerName.setFocusColor(Paint.valueOf("Red"));
                        txtCustomerName.requestFocus();
                    }
                } else {
                    txtEmail.setFocusColor(Paint.valueOf("Red"));
                    txtEmail.requestFocus();
                }
            } else {
                txtContactNo.setFocusColor(Paint.valueOf("Red"));
                txtContactNo.requestFocus();
            }
        } else {
            txtCashierId.setFocusColor(Paint.valueOf("Red"));
            txtCashierId.requestFocus();
        }

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String id = txtSearch.getText();
        boolean isDeleted;
        try {
            isDeleted = customerBoImpl.deleteCustomer(id);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Customer");
            alert.setContentText("Are you sure you want to delete details of customer " + txtCustomerId.getText() + " ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.equals(null)) {
                Navigation.navigate(Routes.NEW_CUSTOMER, brdPaneCustomer);
            } else if (result.get() == ButtonType.OK) {
                if (isDeleted) {
                    Notifications notifications = Notifications.create().text("Customer Details Deleted.").title("Delete ").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                    notifications.showInformation();
                } else {
                    Notifications notifications = Notifications.create().text("Customer Not Found.").title("Error").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                    notifications.showError();
                }
            } else if (result.get() == ButtonType.CANCEL) {
                Navigation.navigate(Routes.NEW_CUSTOMER, brdPaneCustomer);
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


    public void btnReturnOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.RETURNS, brdPaneCustomer);
    }
}
