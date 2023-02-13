package lk.ijse.finalproject.bo.custom.impl;

import lk.ijse.finalproject.bo.custom.EmployeeBO;
import lk.ijse.finalproject.dao.DAOFactory;
import lk.ijse.finalproject.dao.DAOTypes;
import lk.ijse.finalproject.dao.custom.EmployeeDAO;
import lk.ijse.finalproject.dto.EmployeeDTO;
import lk.ijse.finalproject.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBoImpl implements EmployeeBO {

    EmployeeDAO employeeDAO= (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.EMPLOYEE);
    @Override
    public boolean addEmployee(EmployeeDTO employee) throws SQLException, ClassNotFoundException {
        return employeeDAO.add(new Employee(employee.getEmpId(),employee.getName(),employee.getAddress(),employee.getNic(),employee.getDob(),employee.getEmail(),employee.getDesignation(),employee.getJoinedDate(),employee.getEmployeeType(),employee.getContactNo(),employee.getUserName(),employee.getPassword()));
    }

    @Override
    public EmployeeDTO searchEmployee(String id) throws SQLException, ClassNotFoundException {
        Employee employee = employeeDAO.search(id);
        return new EmployeeDTO(employee.getEmpId(),employee.getName(),employee.getAddress(),employee.getNicNumber(),employee.getDob(),employee.getEmail(),employee.getDesignation(),employee.getJoinedDate(),employee.getEmployeeType(),employee.getContactNo(),employee.getUserName(),employee.getPassword());
    }

    @Override
    public ArrayList<EmployeeDTO> getAllEmployees() throws SQLException, ClassNotFoundException {
        ArrayList<EmployeeDTO> employeeDTOS = new ArrayList<>();
        ArrayList<Employee> employee1 = employeeDAO.getAll();
        for (Employee employee: employee1){
            employeeDTOS.add(new EmployeeDTO(employee.getEmpId(),employee.getName(),employee.getAddress(),employee.getNicNumber(),employee.getDob(),employee.getEmail(),employee.getDesignation(),employee.getJoinedDate(),employee.getEmployeeType(),employee.getContactNo(),employee.getUserName(),employee.getPassword()));
        }
        return employeeDTOS;
    }

    @Override
    public EmployeeDTO SearchPassword(String to) throws SQLException, ClassNotFoundException {
        Employee employee = employeeDAO.SearchPassword(to);
        return new EmployeeDTO(employee.getEmpId(),employee.getName(),employee.getAddress(),employee.getNicNumber(),employee.getDob(),employee.getEmail(),employee.getDesignation(),employee.getJoinedDate(),employee.getEmployeeType(),employee.getContactNo(),employee.getUserName(),employee.getPassword());
    }

    @Override
    public boolean editEmployee(EmployeeDTO employee) throws SQLException, ClassNotFoundException {
        return employeeDAO.update(new Employee(employee.getEmpId(),employee.getName(),employee.getAddress(),employee.getNic(),employee.getDob(),employee.getEmail(),employee.getDesignation(),employee.getJoinedDate(),employee.getEmployeeType(),employee.getContactNo(),employee.getUserName(),employee.getPassword()));

    }
}
