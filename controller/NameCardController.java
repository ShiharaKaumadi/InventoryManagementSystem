package lk.ijse.finalproject.controller;

import com.jfoenix.controls.JFXButton;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import lk.ijse.finalproject.dao.custom.EmployeeDAO;
import lk.ijse.finalproject.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.finalproject.dto.EmployeeDTO;
import lk.ijse.finalproject.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public class NameCardController {
    public Pane paneNameCard;
    public Pane paneCard;
    public Label lblEmpName;
    public Label lblEmpID;
    public Label lblDesignation;
    public Label lblEmailEmp;
    public Label lblMobilePhone;
    public JFXButton btnMore;
    public Label lblEmpAddress;
    EmployeeDAO employeeDAOImpl = new EmployeeDAOImpl();


    public ArrayList<EmployeeDTO> showEmployeeList() throws SQLException, ClassNotFoundException {
        ArrayList <EmployeeDTO> employeeDTOS = new ArrayList<>();
        ArrayList<Employee> employeeArrayList = employeeDAOImpl.searchDetails();

        for(Employee employeeDTO1 :employeeArrayList){
            EmployeeDTO employeeDTO2 = new EmployeeDTO(employeeDTO1.getName(),employeeDTO1.getEmpId(), employeeDTO1.getDesignation(),employeeDTO1.getEmail(),employeeDTO1.getContactNo(),employeeDTO1.getAddress() );
            lblEmpName.setText(employeeDTO1.getName());
            lblEmpID.setText(employeeDTO1.getEmpId());
            lblDesignation.setText(employeeDTO1.getDesignation());
            lblEmailEmp.setText(employeeDTO1.getEmail());
            lblMobilePhone.setText(employeeDTO1.getContactNo());
            lblEmpAddress.setText(employeeDTO1.getAddress() );
            employeeDTOS.add(employeeDTO2);

        }
        return employeeDTOS;
    }
}
