package lk.ijse.finalproject.bo.custom;

import lk.ijse.finalproject.dto.CustomerDTO;

import java.sql.SQLException;

public interface CustomerBO extends SuperBO{
    CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException;

    boolean addCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException;

    boolean updateCustomerDetails(CustomerDTO customer) throws SQLException, ClassNotFoundException;

    String generateNextCustomerId();

    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;
}
