package lk.ijse.finalproject.bo.custom.impl;

import lk.ijse.finalproject.bo.custom.OrderDetailBO;
import lk.ijse.finalproject.dao.DAOFactory;
import lk.ijse.finalproject.dao.DAOTypes;
import lk.ijse.finalproject.dao.custom.OrderDetailDAO;
import lk.ijse.finalproject.dto.OrderDetailDTO;
import lk.ijse.finalproject.entity.OrderDetail;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailBoImpl implements OrderDetailBO {
    OrderDetailDAO orderDetailDAO = (OrderDetailDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.ORDER_DETAIL);
    @Override
    public ArrayList<OrderDetailDTO> getTopSellingItemOrder() throws SQLException, ClassNotFoundException {
        ArrayList <OrderDetailDTO> orderDetailDTOS= new ArrayList<>();
        ArrayList<OrderDetail> topSellingItemOrder = orderDetailDAO.getTopSellingItemOrder();
        for (OrderDetail orderDetailDTO: topSellingItemOrder){
            orderDetailDTOS.add(new OrderDetailDTO(orderDetailDTO.getOrderId(),orderDetailDTO.getProductID(),orderDetailDTO.getDescription(),orderDetailDTO.getQty(),orderDetailDTO.getMeasuredUnits(),orderDetailDTO.getUnitPrice(),orderDetailDTO.getDailyIncome(),orderDetailDTO.getCategory(),orderDetailDTO.getSubCategory(),orderDetailDTO.getBrandName()));
        }
        return orderDetailDTOS;
    }

    @Override
    public double collectTotalIncomeValue() throws SQLException, ClassNotFoundException {
        return orderDetailDAO.collectIncome();
    }
}
