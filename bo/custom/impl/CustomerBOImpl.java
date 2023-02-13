package lk.ijse.finalproject.bo.custom.impl;

import lk.ijse.finalproject.bo.custom.CustomerBO;
import lk.ijse.finalproject.dao.DAOFactory;
import lk.ijse.finalproject.dao.DAOTypes;
import lk.ijse.finalproject.dao.custom.CustomerDAO;
import lk.ijse.finalproject.dto.CustomerDTO;
import lk.ijse.finalproject.entity.Customer;

import java.sql.SQLException;

public class CustomerBOImpl implements CustomerBO {
    private final CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.CUSTOMER);
    @Override
    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        Customer search = customerDAO.search(id);
        return new CustomerDTO(search.getCustomerId(),search.getCustomerName(),search.getContactNo(),search.getEmail(),search.getCashierID());
    }

    @Override
    public boolean addCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException {
        return customerDAO.add(new Customer(customer.getCustomerId(),customer.getCustomerName(),customer.getContactNo(),customer.getEmail(),customer.getCashierID()));
    }

    @Override
    public boolean updateCustomerDetails(CustomerDTO customer) throws SQLException, ClassNotFoundException {
        return customerDAO.update(new Customer(customer.getCustomerId(),customer.getCustomerName(),customer.getContactNo(),customer.getEmail(),customer.getCashierID()));
    }

    @Override
    public String generateNextCustomerId() {
        try {
            return customerDAO.generateNextOrderId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }
}
