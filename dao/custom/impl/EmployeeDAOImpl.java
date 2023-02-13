package lk.ijse.finalproject.dao.custom.impl;

import lk.ijse.finalproject.dao.custom.EmployeeDAO;
import lk.ijse.finalproject.dao.util.CrudUtil;
import lk.ijse.finalproject.entity.Employee;
import lk.ijse.finalproject.entity.Storekeeper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {
    public  boolean add(Employee employee) throws SQLException, ClassNotFoundException {

            return CrudUtil.execute("INSERT INTO Employee VALUES (?,?,?,?,?,?,?,?,?,?,?,?)",
                    employee.getEmpId(),
                    employee.getName(),
                    employee.getAddress(),
                    employee.getNicNumber(),
                    employee.getDob(),
                    employee.getEmail(),
                    employee.getDesignation(),
                    employee.getJoinedDate(),
                    employee.getEmployeeType(),
                    employee.getContactNo(),
                    employee.getUserName(),
                    employee.getPassword());

    }

    @Override
    public boolean delete(String empId) throws SQLException, ClassNotFoundException {
        try {
            return CrudUtil.execute("DELETE Employee WHERE empId=?",empId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Employee employeeDTO) throws SQLException, ClassNotFoundException {
        try {
            return CrudUtil.execute("UPDATE Employee SET name=?, address=?, nicNumber=?,dob=?, email=? designation =?,employeeType =?, contactNumber=? userName=?,password=?  WHERE empId=?",
                    employeeDTO.getName(),employeeDTO.getAddress(),employeeDTO.getNicNumber(),employeeDTO.getDob(),employeeDTO.getDesignation(),employeeDTO.getEmployeeType(),employeeDTO.getContactNo(),employeeDTO.getUserName(),employeeDTO.getPassword(),employeeDTO.getEmpId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    public Employee search(String empId) throws SQLException, ClassNotFoundException {
               ResultSet result = CrudUtil.execute("SELECT * FROM Employee WHERE empId = ?", empId);
                if(result.next()) {
                    return new Employee(
                            result.getString(1),
                            result.getString(2),
                            result.getString(3),
                            result.getString(4),
                            result.getObject(5, LocalDate.class),
                            result.getString(6),
                            result.getString(7),
                            result.getObject(8, LocalDate.class),
                            result.getString(9),
                            result.getString(10),
                            result.getString(11),
                            result.getString(12)
                    );
                }



            return null;
        }

        public Employee login(String username, String password) throws SQLException, ClassNotFoundException {
               ResultSet resultSet = CrudUtil.execute("SELECT * FROM Employee WHERE userName=? AND password=?", username, password);
                if (resultSet.next()){
                    return  new Employee(
                            resultSet.getString(11),
                            resultSet.getString(12)
                    );
                }

            return null;
        }

    public Employee loginUserName(String username) throws SQLException, ClassNotFoundException {

            ResultSet resultSet = CrudUtil.execute("SELECT * FROM Employee WHERE userName=?" , username);
            if (resultSet.next()){
                return  new Employee(
                        resultSet.getString(11));
            }


        return null;
    }
    public Employee loginPassword(String password) throws SQLException, ClassNotFoundException {

           ResultSet resultSet = CrudUtil.execute("SELECT * FROM Employee WHERE password=? ", password);
            if (resultSet.next()){
                return  new Employee(
                        resultSet.getString(12));
            }


        return null;
    }

    public Employee SearchPassword(String email) throws SQLException, ClassNotFoundException {
            ResultSet resultSet = CrudUtil.execute("SELECT password FROM Employee WHERE email=?", email);
            if (resultSet.next()){
                return  new Employee(
                        resultSet.getString(1));

            }

        return null;
    }

    public Employee showUserName(String userName) throws SQLException, ClassNotFoundException {


            ResultSet resultSet = CrudUtil.execute("SELECT name FROM Employee WHERE userName=?", userName);
            if (resultSet.next()){
                return  new Employee(
                        resultSet.getString(1));
            }


        return null;
    }

    @Override
    public ArrayList<Employee> searchDetails() throws SQLException, ClassNotFoundException {
        return null;
    }

    public ArrayList<Employee> getAll() throws SQLException, ClassNotFoundException {
           ResultSet result = CrudUtil.execute("SELECT * FROM Employee");
            ArrayList<Employee> employeeList = new ArrayList<>();

            while (result.next()) {
                employeeList.add(new Employee(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getObject(5,LocalDate.class),result.getString(6),result.getString(7),result.getObject(8,LocalDate.class),result.getString(9),result.getString(10),result.getString(11),result.getString(12)));
            }
            return employeeList;


    }

}
