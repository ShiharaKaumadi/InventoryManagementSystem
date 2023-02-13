package lk.ijse.finalproject.dao.custom.impl;

import lk.ijse.finalproject.dao.custom.CustomerDAO;
import lk.ijse.finalproject.dao.util.CrudUtil;
import lk.ijse.finalproject.entity.Customer;
import lk.ijse.finalproject.entity.Storekeeper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public  boolean add(Customer customer) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Customer VALUES (?, ?, ?, ?, ?)", customer.getCustomerId(),customer.getCustomerName(),customer.getContactNo(),customer.getEmail(),customer.getCashierID());
    }

    @Override
    public boolean delete(String customerId) {
        try {
            return CrudUtil.execute("DELETE FROM Customer WHERE customerId=?",customerId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public  ArrayList<String> loadCustomerIds() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT customerId FROM Customer");
        ArrayList<String> idList = new ArrayList<>();
        while (result.next()) {
            idList.add(result.getString(1));
        }
        return idList;
    }

    @Override
    public String generateNextOrderId() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT customerId FROM Customer ORDER BY customerId DESC LIMIT 1");

        if (result.next()) {
            return generateNextOrderId(result.getString(1));
        }
        return generateNextOrderId(null);
    }

    private  String generateNextOrderId(String currentOrderId) {
        if (currentOrderId != null) {
            String[] split = currentOrderId.split("-");
            int id = Integer.parseInt(split[1]);
            id +=1;
            return String.valueOf("C-") + id;
        }
        return "C-1001";


    }

    @Override
    public Customer search(String id) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM Customer WHERE customerId = ?", id);

        if(result.next()) {
            return new Customer(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5)
            );
        }
        return null;
    }



    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT *  FROM Customer");
        ArrayList <Customer> details = new ArrayList<>();
        while(result.next()) {

            Customer  customerDTO= new Customer(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5));
            details.add(customerDTO) ;
            System.out.println(details);

        }
        return details;
    }

    public  boolean update(Customer customer)  {
        try {
            return CrudUtil.execute("UPDATE Customer SET customerName=?, contactNo=?, email=?,cashierId=? WHERE customerId=?",customer.getCustomerName(),customer.getContactNo(),customer.getEmail(),customer.getCashierID(),customer.getCustomerId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
