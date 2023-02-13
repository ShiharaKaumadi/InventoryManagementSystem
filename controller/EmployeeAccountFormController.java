package lk.ijse.finalproject.controller;

import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import lk.ijse.finalproject.bo.custom.BOFactory;
import lk.ijse.finalproject.bo.custom.BOTypes;
import lk.ijse.finalproject.bo.custom.EmployeeBO;
import lk.ijse.finalproject.dao.custom.EmployeeDAO;
import lk.ijse.finalproject.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.finalproject.dto.EmployeeDTO;

import lk.ijse.finalproject.util.Navigation;
import lk.ijse.finalproject.util.Routes;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class  EmployeeAccountFormController {
    public JFXRadioButton rdBtnPermanent;
    public JFXRadioButton rdBtnTrainee;
    public JFXRadioButton rdBtnPartTimer;
    public ToggleGroup employeeType;
    public JFXTextField txtEmployeeType;
    public JFXComboBox<String> cmbEmployeeType;
    public TextField txtSearch;
    public JFXButton btnClear;

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
    private JFXButton btnViewStatics;

    @FXML
    private JFXButton btnLogout;

    @FXML
    private JFXButton btnHamburger;

    @FXML
    private Pane paneSearchBar1;

    @FXML
    private JFXButton btnSaveEmployee;

    @FXML
    private Pane paneProfile;

    @FXML
    private JFXTextField txtEmployeeId;

    @FXML
    private JFXTextField txtEmployeeName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtNicNumber;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXDatePicker dtDateofBirth;

    @FXML
    private JFXDatePicker dtJoinedDate;

    @FXML
    private JFXTextField txtDesignation;

    @FXML
    private JFXTextField txtContactNumber;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXTextField txtPassword;

    @FXML
    private JFXRadioButton rdBtnMale;

    @FXML
    private JFXRadioButton rdBtnFemale;

    @FXML
    private JFXButton btnEditEmployee;

    @FXML
    private JFXButton btnDeleteEmployee;
    EmployeeBO employeeBoImpl = (EmployeeBO) BOFactory.getBoFactory().getBO(BOTypes.EMPLOYEE);

    public void initialize(){
        ObservableList <String> employeeTypeList = FXCollections.observableArrayList("Permanent","Part-timer","Trainee");
        cmbEmployeeType.setItems(employeeTypeList);
    }

    @FXML
    void btnClickHamburgerOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteEmployeeOnAction(ActionEvent event) {

    }

    @FXML
    void btnEditEmployeeOnAction(ActionEvent event) {
        String employeeId = txtEmployeeId.getText();
        String name = txtEmployeeName.getText();
        String address = txtAddress.getText();
        String nicNumber = txtNicNumber.getText();
        LocalDate dateofBirth =dtDateofBirth.getValue();
        String email = txtEmail.getText();
        String designation= txtDesignation.getText();
        LocalDate joinedDate = dtJoinedDate.getValue();
        String employeType = cmbEmployeeType.getSelectionModel().getSelectedItem().toString();
        String contactNumber =txtContactNumber.getText();
        String username = txtUserName.getText();
        String password = txtPassword.getText();

        EmployeeDTO employee = new EmployeeDTO(employeeId,name,address,nicNumber,dateofBirth,email,designation,joinedDate,employeType,contactNumber,username,password);
        boolean isEmployeeIdMatched = employeeId.matches("^E(M|S|C)-(1|2|3)\\d{2}$");
        boolean isNameMatched = name.matches("^[a-zA-Z][a-zA-Z\\s]{0,40}$");
        boolean isAddressMatched = address.matches("^[a-zA-Z][a-zA-Z\\s]{0,100}$");
        boolean isNicMatched = nicNumber.matches("^[1-9]\\d{8}V$");
        boolean isContactMatched = contactNumber.matches("^(070|071|072|074|075|078|077|076)([0-9]{7})$");
        boolean isEmailMatched = email.matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
        boolean isDesignationMatched = name.matches("^[a-zA-Z][a-zA-Z\\s]{0,40}$");
        boolean isUserNameMatched =username.matches("^E(M|C|S)-(1|2|3)\\d{2}$");
        boolean isPasswordMatched =password.matches("^^E(M|C|S)-(1|2|3)\\d{2}@l$");

        boolean isAdded = false;
        if (isEmployeeIdMatched){
            if (isNameMatched){
                if (isAddressMatched){
                    if (isNicMatched){
                        if (isContactMatched){
                            if (isEmailMatched){
                                if (isDesignationMatched){
                                    if (isUserNameMatched){
                                        if(isPasswordMatched){
                                            try {
                                                isAdded = employeeBoImpl.editEmployee(employee);
                                                if(isAdded){
                                                    Notifications notifications = Notifications.create().title("Register Employee").text("Employee added succesfully.").hideAfter(Duration.seconds(3)).position(Pos.BASELINE_RIGHT);
                                                    notifications.showInformation();


                                                }
                                            } catch (SQLException e) {
                                                Notifications notifications = Notifications.create().title("Data Type Error").text("Please check the data type of feilds.").hideAfter(Duration.seconds(3)).position(Pos.BASELINE_RIGHT);
                                                notifications.showInformation();

                                            } catch (ClassNotFoundException e) {
                                                throw new RuntimeException(e);
                                            }

                                        }else{
                                            txtPassword.setFocusColor(Paint.valueOf("Red"));
                                            txtPassword.requestFocus();
                                        }
                                    }else{
                                        txtUserName.setFocusColor(Paint.valueOf("Red"));
                                        txtUserName.requestFocus();
                                    }
                                }else{
                                    txtDesignation.setFocusColor(Paint.valueOf("Red"));
                                    txtDesignation.requestFocus();
                                }
                            }else{
                                txtEmail.setFocusColor(Paint.valueOf("Red"));
                                txtEmail.requestFocus();
                            }
                        }else{
                            txtContactNumber.setFocusColor(Paint.valueOf("Red"));
                            txtContactNumber.requestFocus();
                        }
                    }else{
                        txtContactNumber.setFocusColor(Paint.valueOf("Red"));
                        txtNicNumber.requestFocus();
                    }
                }else{
                    txtAddress.setFocusColor(Paint.valueOf("Red"));
                    txtAddress.requestFocus();
                }
            }else{
                txtEmployeeName.setFocusColor(Paint.valueOf("Red"));
                txtEmployeeName.requestFocus();
            }
        }else{
            txtEmployeeId.setFocusColor(Paint.valueOf("Red"));
            txtEmployeeId.requestFocus();
        }

    }

    @FXML
    void btnHomeOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.DASHBOARD,brdrPaneRegisterEmployee);
    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) {

    }

    @FXML
    void btnProfileSettingsOnAction(ActionEvent event) {

    }

    @FXML
    void btnRegisterEmployeeOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveEmployeeOnAction(ActionEvent event) {
        String employeeId = txtEmployeeId.getText();
        String name = txtEmployeeName.getText();
        String address = txtAddress.getText();
        String nicNumber = txtNicNumber.getText();
        LocalDate dateofBirth =dtDateofBirth.getValue();
        String email = txtEmail.getText();
        String designation= txtDesignation.getText();
        LocalDate joinedDate = dtJoinedDate.getValue();
        String employeType = cmbEmployeeType.getSelectionModel().getSelectedItem().toString();
        String contactNumber =txtContactNumber.getText();
        String username = txtUserName.getText();
        String password = txtPassword.getText();

        EmployeeDTO employee = new EmployeeDTO(employeeId,name,address,nicNumber,dateofBirth,email,designation,joinedDate,employeType,contactNumber,username,password);
        boolean isEmployeeIdMatched = employeeId.matches("^E(M|S|C)-(1|2|3)\\d{2}$");
        boolean isNameMatched = name.matches("^[a-zA-Z][a-zA-Z\\s]{0,40}$");
        boolean isAddressMatched = address.matches("^[a-zA-Z][a-zA-Z\\s]{0,100}$");
        boolean isNicMatched = nicNumber.matches("^[1-9]\\d{8}V$");
        boolean isContactMatched = contactNumber.matches("^(070|071|072|074|075|078|077|076)([0-9]{7})$");
        boolean isEmailMatched = email.matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
        boolean isDesignationMatched = name.matches("^[a-zA-Z][a-zA-Z\\s]{0,40}$");
        boolean isUserNameMatched =username.matches("^E(M|C|S)-(1|2|3)\\d{2}$");
        boolean isPasswordMatched =password.matches("^^E(M|C|S)-(1|2|3)\\d{2}@l$");

        boolean isAdded = false;
        if (isEmployeeIdMatched){
            if (isNameMatched){
                if (isAddressMatched){
                    if (isNicMatched){
                        if (isContactMatched){
                            if (isEmailMatched){
                                if (isDesignationMatched){
                                    if (isUserNameMatched){
                                        if(isPasswordMatched){
                                            try {
                                                isAdded = employeeBoImpl.addEmployee(employee);
                                                if(isAdded){
                                                    Notifications notifications = Notifications.create().title("Register Employee").text("Employee added succesfully.").hideAfter(Duration.seconds(3)).position(Pos.BASELINE_RIGHT);
                                                    notifications.showInformation();


                                                }
                                            } catch (SQLException e) {
                                                Notifications notifications = Notifications.create().title("Data Type Error").text("Please check the data type of feilds.").hideAfter(Duration.seconds(3)).position(Pos.BASELINE_RIGHT);
                                                notifications.showInformation();

                                            } catch (ClassNotFoundException e) {
                                                throw new RuntimeException(e);
                                            }

                                        }else{
                                            txtPassword.setFocusColor(Paint.valueOf("Red"));
                                            txtPassword.requestFocus();
                                        }
                                    }else{
                                        txtUserName.setFocusColor(Paint.valueOf("Red"));
                                        txtUserName.requestFocus();
                                    }
                                }else{
                                    txtDesignation.setFocusColor(Paint.valueOf("Red"));
                                    txtDesignation.requestFocus();
                                }
                            }else{
                                txtEmail.setFocusColor(Paint.valueOf("Red"));
                                txtEmail.requestFocus();
                            }
                        }else{
                            txtContactNumber.setFocusColor(Paint.valueOf("Red"));
                            txtContactNumber.requestFocus();
                        }
                    }else{
                        txtContactNumber.setFocusColor(Paint.valueOf("Red"));
                        txtNicNumber.requestFocus();
                    }
                }else{
                    txtAddress.setFocusColor(Paint.valueOf("Red"));
                    txtAddress.requestFocus();
                }
            }else{
                txtEmployeeName.setFocusColor(Paint.valueOf("Red"));
                txtEmployeeName.requestFocus();
            }
        }else{
            txtEmployeeId.setFocusColor(Paint.valueOf("Red"));
            txtEmployeeId.requestFocus();
        }

    }

    @FXML
    void btnViewNotesOnAction(ActionEvent event) {

    }

    @FXML
    void btnViewStaticsOnAction(ActionEvent event) {

    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        String id = txtSearch.getText();
        try {
            EmployeeDTO employee = employeeBoImpl.searchEmployee(id);
            if(employee != null) {
                fillData(employee);
                txtSearch.setText("");
            } else {
                Notifications notifications = Notifications.create().title(" Search Employee").text("Employee Not Found").hideAfter(Duration.seconds(3)).position(Pos.TOP_CENTER);
                notifications.show();
                txtEmployeeId.setText("");
                txtEmployeeName.setText("");
                txtAddress.setText("");
                txtNicNumber.setText("");
                dtDateofBirth.setValue(null);
                txtEmail.setText("");
                txtDesignation.setText("");
                dtJoinedDate.setValue(null);
                cmbEmployeeType.setAccessibleText("");
                txtContactNumber.setText("");
                txtUserName.setText("");
                txtPassword.setText("");
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void fillData(EmployeeDTO employee) {
        txtEmployeeId.setText(employee.getEmpId());
        txtEmployeeName.setText(employee.getName());
        txtAddress.setText(employee.getAddress());
        txtNicNumber.setText(employee.getNic());
        dtDateofBirth.setValue(employee.getDob());
        txtEmail.setText(employee.getEmail());
        txtDesignation.setText(employee.getDesignation());
        dtJoinedDate.setValue(employee.getJoinedDate());
        cmbEmployeeType.setAccessibleText(employee.getEmployeeType());
        txtContactNumber.setText(employee.getContactNo());
        txtUserName.setText(employee.getUserName());
        txtPassword.setText(employee.getPassword());

    }

    public void txtSearchOnAction(ActionEvent actionEvent) {
        btnSearchOnAction(actionEvent);
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.MANAGE_EMPLOYEE,brdrPaneRegisterEmployee);
    }
}
