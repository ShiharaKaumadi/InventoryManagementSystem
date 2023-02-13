package lk.ijse.finalproject.dao.custom;

import lk.ijse.finalproject.dao.CrudDAO;
import lk.ijse.finalproject.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeDAO extends CrudDAO<Employee, String> {


    Employee login(String username, String password) throws SQLException, ClassNotFoundException;
    Employee loginUserName(String username) throws SQLException, ClassNotFoundException;
    Employee loginPassword(String password) throws SQLException, ClassNotFoundException;
    Employee SearchPassword(String email) throws SQLException, ClassNotFoundException;
    Employee showUserName(String userName) throws SQLException, ClassNotFoundException;
    ArrayList<Employee> searchDetails() throws SQLException, ClassNotFoundException;
}
