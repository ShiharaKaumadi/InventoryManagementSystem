package lk.ijse.finalproject.bo.custom;

import lk.ijse.finalproject.dto.EmployeeDTO;

import javax.mail.PasswordAuthentication;
import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeBO extends SuperBO {
    boolean addEmployee(EmployeeDTO employee) throws SQLException, ClassNotFoundException;

    EmployeeDTO searchEmployee(String id) throws SQLException, ClassNotFoundException;

    ArrayList<EmployeeDTO> getAllEmployees() throws SQLException, ClassNotFoundException;

    EmployeeDTO SearchPassword(String to) throws SQLException, ClassNotFoundException;

    boolean editEmployee(EmployeeDTO employee) throws SQLException, ClassNotFoundException;
}
