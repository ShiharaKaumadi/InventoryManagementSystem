package lk.ijse.finalproject.bo.custom.impl;

import lk.ijse.finalproject.bo.custom.OrderBO;
import lk.ijse.finalproject.dao.DAOFactory;
import lk.ijse.finalproject.dao.DAOTypes;
import lk.ijse.finalproject.dao.custom.OrderDAO;
import lk.ijse.finalproject.dto.OrderDTO;
import lk.ijse.finalproject.entity.Order;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderBoImpl implements OrderBO {
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.ORDER);
    @Override
    public ArrayList<OrderDTO> getTotalIncome() throws SQLException, ClassNotFoundException {
        ArrayList <OrderDTO> orderDTOS = new ArrayList<>();
        ArrayList<Order> all = orderDAO.getAll();
        for (Order order:all){
            orderDTOS.add(new OrderDTO(order.getOrderId(),order.getDate(),order.getTime(),order.getTotalAmount(),order.getCustomerID()));
        }
        return orderDTOS;
    }
}
