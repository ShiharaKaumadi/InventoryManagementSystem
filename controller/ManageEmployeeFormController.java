package lk.ijse.finalproject.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import lk.ijse.finalproject.bo.custom.BOFactory;
import lk.ijse.finalproject.bo.custom.BOTypes;
import lk.ijse.finalproject.bo.custom.EmployeeBO;
import lk.ijse.finalproject.dao.custom.EmployeeDAO;
import lk.ijse.finalproject.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.finalproject.dto.EmployeeDTO;
import lk.ijse.finalproject.util.Navigation;
import lk.ijse.finalproject.util.Routes;
import lk.ijse.finalproject.views.tm.EmployeeTM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

public class ManageEmployeeFormController {
    public JFXButton btnSaveEmployee;
    public Pane paneProfile;
    public JFXTextField txtEmployeeId;
    public JFXTextField txtEmployeeName;
    public JFXTextField txtAddress;
    public JFXTextField txtNicNumber;
    public JFXTextField txtEmail;
    public JFXDatePicker dtpDatBirth;
    public JFXDatePicker dtbJoinedDate;
    public JFXTextField txtDesignation;
    public JFXTextField txtContactNumber;
    public JFXTextField txtUserName;
    public JFXTextField txtPassword;
    public JFXButton btnBack;
    public JFXComboBox cmbEmployeeType;
    public JFXButton btnEditEmployee;
    public JFXButton btnDeleteEmployee;
    public BorderPane brdrPaneViewNotes;
    public Pane paneSearchBar11;
    public ComboBox cmbFilter;
    public TableColumn colName;
    public TableColumn colEmpID;
    public TableColumn colDesignation;
    public TableColumn colEmail;
    public TableColumn colContactNo;
    public TableColumn colAddress;
    public TableView<EmployeeTM> tblEmployeeData;
    public JFXButton btnSearchOnAction;
    public TextField txtSearch;
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
    private JFXButton btnAddEmployee;

    @FXML
    private JFXButton btnReduce;

    @FXML
    private JFXButton btnIncrease;

    @FXML
    private TextField txtRecordPerPage;

   ObservableList<EmployeeTM> tmList = FXCollections.observableArrayList();
   EmployeeBO employeeBoImpl = (EmployeeBO) BOFactory.getBoFactory().getBO(BOTypes.EMPLOYEE);

    public  void initialize(){
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmpID.setCellValueFactory(new PropertyValueFactory<>("empId"));
        colDesignation.setCellValueFactory(new PropertyValueFactory<>("designation"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colContactNo.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        loadAllData();
        FilteredList <EmployeeTM> filteredList = new FilteredList<>(tmList,b->true);
        txtSearch.textProperty().addListener((observable,oldValue,newValue) -> {
            filteredList.setPredicate(employeeTM -> {
                if (newValue==null ||newValue.isEmpty()){
                    return  true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (employeeTM.getName().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                    return  true;
                } else if (employeeTM.getDesignation().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
                    return true;
                } else if (employeeTM.getAddress().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
                    return true;
                } else if (employeeTM.getContactNo().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
                    return true;
                } else if (employeeTM.getEmail().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
                    return true;
                } else if (employeeTM.getEmpId().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
                    return true;
                } else{
                    return false;
                }
            });
        });
        SortedList <EmployeeTM> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(tblEmployeeData.comparatorProperty());
        tblEmployeeData.setItems(sortedList);

    }

    private void loadAllData() {
        ArrayList<EmployeeDTO> list=null;

        try {
            list = employeeBoImpl.getAllEmployees();
            for (EmployeeDTO employeeDTO: list){
                EmployeeTM employeeTM = new EmployeeTM(employeeDTO.getName(), employeeDTO.getEmpId(), employeeDTO.getDesignation(), employeeDTO.getEmail(), employeeDTO.getContactNo(), employeeDTO.getAddress());
                tmList.add(employeeTM);
                tblEmployeeData.setItems(tmList);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }




    }

    @FXML
    void btnAddEmployeeOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.ADD_EMPLOYEE,brdrPaneRegisterEmployee);
    }

    @FXML
    void btnClickHamburgerOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.CLICK_HAM_MANAGE_EMPLOYEE,brdrPaneRegisterEmployee);
    }

    @FXML
    void btnHomeOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.DASHBOARD,brdrPaneRegisterEmployee);
    }

    @FXML
    void btnIncreaseOnAction(ActionEvent event) {

    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.LOGOUT,brdrPaneRegisterEmployee);
    }

    @FXML
    void btnProfileSettingsOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.PROFILE_SETTINGS,brdrPaneRegisterEmployee);
    }

    @FXML
    void btnReduceOnAction(ActionEvent event) {

    }

    @FXML
    void btnRegisterEmployeeOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.MANAGE_EMPLOYEE,brdrPaneRegisterEmployee);
    }

    @FXML
    void btnViewNotesOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.MANAGEMENT_NOTES,brdrPaneRegisterEmployee);
    }

    @FXML
    void btnViewStaticsOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.VIEW_STATISTICS, brdrPaneRegisterEmployee);
    }

    @FXML
    void txtRecordPerAction(ActionEvent event) {

    }

    public void btnSaveEmployeeOnAction(ActionEvent actionEvent) {
    }

    public void btnBackOnAction(ActionEvent actionEvent) {
    }

    public void btnEditEmployeeOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteEmployeeOnAction(ActionEvent actionEvent) {
    }
}
