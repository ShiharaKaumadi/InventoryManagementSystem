package lk.ijse.finalproject.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import lk.ijse.finalproject.bo.custom.*;
import lk.ijse.finalproject.dto.ReturnsDTO;
import lk.ijse.finalproject.util.Navigation;
import lk.ijse.finalproject.util.Routes;
import lk.ijse.finalproject.views.tm.ReturnsTM;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class ReturnsFormController {
    public BorderPane brdPaneReturns;
    public Pane leftPane;
    public Circle userProfile;
    public Label lblUserName;
    public JFXButton btnHome;
    public JFXButton btnProfileSettings;
    public JFXButton btnManageCustomer;
    public JFXButton btnExpenses;
    public JFXButton btnGenerateIncome;
    public JFXButton btnLogout;
    public Pane paneSearchBar1;
    public TextField txtSearch;
    public JFXButton btnSave;
    public Pane paneProfile;
    public JFXTextField txtReturnId;
    public JFXTextField txtProductId;
    public JFXTextField txtCustomerId;
    public JFXButton btnEdit;
    public JFXButton btnDelete;
    public TableView<ReturnsDTO> tblReturns;
    public TableColumn<ReturnsTM, String> colReturnId;
    public TableColumn<ReturnsTM, LocalDate> colReturnDate;
    public TableColumn<ReturnsTM, String> colProductID;
    public TableColumn<ReturnsTM, String> colCustomerId;
    public JFXDatePicker dtReturnDate;
    public JFXTextField txtQty;
    public TableColumn<ReturnsTM, Double> colQty;
    ObservableList<ReturnsDTO> tmList = FXCollections.observableArrayList();
    ObservableList<ReturnsTM> obList = FXCollections.observableArrayList();
    ReturnsBO returnsBOImpl = (ReturnsBO) BOFactory.getBoFactory().getBO(BOTypes.RETURNS);
    StockBO stockBOImpl = (StockBO) BOFactory.getBoFactory().getBO(BOTypes.STOCK);

    public void initialize() {

        setCellValueFactory();
        loadReturnsTblData();
        loadNextReturnId();
    }

    private void loadNextReturnId() {
        String returnId = null;
        try {
            returnId = returnsBOImpl.getNextReturnId();
            txtReturnId.setText(returnId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadReturnsTblData() {
        ArrayList<ReturnsDTO> returns = null;
        try {
            returns = returnsBOImpl.getAllReturns();
            for (ReturnsDTO returnsDTO : returns) {
                ReturnsDTO returnsDTO1 = new ReturnsDTO(returnsDTO.getReturnId(), returnsDTO.getReturnDate(), returnsDTO.getProductID(), returnsDTO.getQty(), returnsDTO.getCustomerID());
                tmList.add(returnsDTO1);

                tblReturns.setItems(tmList);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    private void setCellValueFactory() {
        colReturnId.setCellValueFactory(new PropertyValueFactory<>("returnId"));
        colReturnDate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        colProductID.setCellValueFactory(new PropertyValueFactory<>("productID"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("customerID"));
    }

    public void btnHomeOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.CASHIER_DASHBOARD, brdPaneReturns);
    }

    public void btnProfileSettingsOnAction(ActionEvent actionEvent) {
    }

    public void btnManageCustomerOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.NEW_CUSTOMER, brdPaneReturns);
    }

    public void btnExpensesOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.EXPENSES, brdPaneReturns);
    }

    public void btnGenerateIncomeOnAction(ActionEvent actionEvent) {
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout Confirmation");
        alert.setContentText("Are you sure you want to logout?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == null) {
            Navigation.navigate(Routes.RETURNS, brdPaneReturns);
        } else if (result.get() == ButtonType.OK) {
            Navigation.navigate(Routes.LOGIN, brdPaneReturns);
        } else if (result.get() == ButtonType.CANCEL) {
            Navigation.navigate(Routes.RETURNS, brdPaneReturns);
        }
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        String id = txtSearch.getText();
        ReturnsDTO returnsDTO = null;
        try {
            returnsDTO = returnsBOImpl.searchReturnItem(id);
            if (returnsDTO != null) {
                fillData(returnsDTO);

            } else {
                Notifications notifications = Notifications.create().text("Not Found").title("Search Id").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                notifications.showInformation();
                txtCustomerId.setText("");
                txtProductId.setText("");
                txtQty.setText("");
                txtReturnId.setText("");
                dtReturnDate.setValue(null);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private void fillData(ReturnsDTO returnsDTO) {
        txtReturnId.setText(returnsDTO.getReturnId());
        txtProductId.setText(returnsDTO.getProductID());
        txtQty.setText(String.valueOf(returnsDTO.getQty()));
        txtCustomerId.setText(returnsDTO.getCustomerID());
        dtReturnDate.setValue(returnsDTO.getReturnDate());
    }

    public void txtSearchOnAction(ActionEvent actionEvent) {
        btnSearchOnAction(actionEvent);
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String returnId = txtReturnId.getText();
        LocalDate returnDate = dtReturnDate.getValue();
        String productId = txtProductId.getText();
        double qty = Double.parseDouble(txtQty.getText());
        String customerId = txtCustomerId.getText();

        ReturnsDTO returnsDTO = new ReturnsDTO(returnId, returnDate, productId, qty, customerId);
        ObservableList<ReturnsDTO> returns1 = tblReturns.getItems();
        boolean isAdded = false;

        try {
            isAdded = returnsBOImpl.saveReturn(returnsDTO);
            double quantity = Integer.parseInt(txtQty.getText());

            ReturnsTM isExists = isExists((String) txtProductId.getText(),txtCustomerId.getText());
            if (isExists != null) {
                for (ReturnsTM returnsTM : obList) {
                    if (returnsTM.equals(isExists)) {
                        returnsTM.setQty(returnsTM.getQty() + qty);

                    }
                }

            }

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setContentText("Are you sure you want to add return item?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == null) {
                Navigation.navigate(Routes.RETURNS, brdPaneReturns);
            } else if (result.get() == ButtonType.OK) {
                if (isAdded) {
                    returns1.add(returnsDTO);
                    tblReturns.setItems(returns1);

                    Notifications notifications = Notifications.create().title("Add Return").text("Added Successfully").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                    notifications.showConfirm();
                }
            } else if (result.get() == ButtonType.CANCEL) {
                Navigation.navigate(Routes.RETURNS, brdPaneReturns);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private ReturnsTM isExists(String code, String text) {
        for (ReturnsTM returnsTM : obList) {
            if (returnsTM.getProductId().equals(code)&returnsTM.getCustomerId().equals(text)) {
                return returnsTM;
            }
        }
        return null;

    }

    public void btnEditOnAction(ActionEvent actionEvent) throws IOException {
        String returnId = txtReturnId.getText();
        String productId = txtProductId.getText();
        String customerId = txtCustomerId.getText();
        double qty = Double.parseDouble(txtQty.getText());
        LocalDate returnDate = dtReturnDate.getValue();

        ReturnsDTO returnsDTO = new ReturnsDTO(returnId, returnDate, productId, qty, customerId);
        ObservableList<ReturnsDTO> returns1 = FXCollections.observableArrayList();
        boolean isUpdate = false;
        try {
            isUpdate = returnsBOImpl.editReturnDetails(returnsDTO);
            returns1.add(returnsDTO);
            tblReturns.setItems(returns1);
            tblReturns.refresh();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setContentText("Are you sure you want to edit return item?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == null) {
                Navigation.navigate(Routes.RETURNS, brdPaneReturns);
            } else if (result.get() == ButtonType.OK) {
                if (isUpdate) {
                    Notifications notifications = Notifications.create().title("Update Return").text("Updated Successfully").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                    notifications.showConfirm();
                } else {
                    Notifications notifications = Notifications.create().title("Update Return").text("Update Error").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                    notifications.showWarning();
                }
            } else if (result.get() == ButtonType.CANCEL) {
                Navigation.navigate(Routes.RETURNS, brdPaneReturns);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String id = txtSearch.getText();
        boolean isDeleted;
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Alert");
            alert.setContentText("Are you sure you want to delete Return  " + id);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == null) {

            } else if (result.get() == ButtonType.OK) {
                isDeleted = returnsBOImpl.deleteReturn(id);
                if (isDeleted) {
                    Notifications notifications = Notifications.create().text("Return Details Deleted.").title("Delete ").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                    notifications.showInformation();
                } else {
                    Notifications notifications = Notifications.create().text("Return Detail Not Found.").title("Error").position(Pos.CENTER).hideAfter(Duration.seconds(3));
                    notifications.showError();
                }
            } else if (result.get() == ButtonType.CANCEL) {
                Navigation.navigate(Routes.RETURNS, brdPaneReturns);
            }

        } catch (ClassNotFoundException e) {
            Notifications notifications = Notifications.create().text("Driver Not Found.").title("ClassNotFound Exception").position(Pos.CENTER).hideAfter(Duration.seconds(3));
            notifications.showError();

        } catch (SQLException e) {
            Notifications notifications = Notifications.create().text("Return ID Not Identified").title("Warning").position(Pos.CENTER).hideAfter(Duration.seconds(3));
            notifications.showError();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnAddNewOnAction(ActionEvent actionEvent) {
        loadNextReturnId();
        txtProductId.setText("");
        txtCustomerId.setText("");
        dtReturnDate.setValue(null);
        txtQty.setText("");
    }
}
