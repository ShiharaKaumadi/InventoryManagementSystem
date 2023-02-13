package lk.ijse.finalproject.dao.custom;

import lk.ijse.finalproject.dao.CrudDAO;
import lk.ijse.finalproject.dto.MrnDTO;
import lk.ijse.finalproject.dto.OrderDTO;
import lk.ijse.finalproject.entity.Order;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDAO extends CrudDAO<Order, String> {
    public  String generateNextOrderId() throws SQLException, ClassNotFoundException;

    public  String generateCustomerCount() throws SQLException, ClassNotFoundException;
}
