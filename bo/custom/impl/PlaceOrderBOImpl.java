package lk.ijse.finalproject.bo.custom.impl;

import lk.ijse.finalproject.bo.custom.PlaceOrderBO;
import lk.ijse.finalproject.dao.DAOFactory;
import lk.ijse.finalproject.dao.DAOTypes;
import lk.ijse.finalproject.dao.custom.CustomerDAO;
import lk.ijse.finalproject.dao.custom.OrderDAO;
import lk.ijse.finalproject.dao.custom.OrderDetailDAO;
import lk.ijse.finalproject.dao.custom.StockDAO;
import lk.ijse.finalproject.db.DBConnection;
import lk.ijse.finalproject.dto.OrderDTO;
import lk.ijse.finalproject.dto.PlaceOrderDTO;
import lk.ijse.finalproject.dto.StockDTO;
import lk.ijse.finalproject.entity.Order;
import lk.ijse.finalproject.entity.StockAtStore;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class PlaceOrderBOImpl implements PlaceOrderBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.CUSTOMER);
    OrderDAO orderDAOImpl = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.ORDER);
    StockDAO stockDAOImpl = (StockDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.STOCK);
    OrderDetailDAO orderDetailDAOImpl = (OrderDetailDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.ORDER_DETAIL);
    public boolean placeOrder(PlaceOrderDTO placeOrder) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean isOrderAdded = orderDAOImpl.add(new Order(placeOrder.getOrderId(), LocalDate.now(), LocalTime.now(),placeOrder.getTotalAmount(),placeOrder.getCustomerId()));
            if (isOrderAdded) {
                System.out.println("isOrderAdded");
                boolean isUpdated = stockDAOImpl.updateQty(placeOrder.getOrderDetails());
                if (isUpdated) {
                    System.out.println("isUpdated");
                    boolean isOrderDetailAdded = orderDetailDAOImpl.saveOrderDetails(placeOrder.getOrderDetails());
                    if (isOrderDetailAdded) {
                        System.out.println("isOrderDetailAdded");
                        DBConnection.getInstance().getConnection().commit();
                        return true;
                    }
                }
            }
            DBConnection.getInstance().getConnection().rollback();
            return false;
        } finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }
    }

    @Override
    public ArrayList<String> loadAllCustomerIds() throws SQLException, ClassNotFoundException {
       return customerDAO.loadCustomerIds();
    }

    @Override
    public ArrayList<String> collectAvailableProductCodes() throws SQLException, ClassNotFoundException {
        return stockDAOImpl.collectAvailableProductCodes();
    }

    @Override
    public String generateCustomerCount() throws SQLException, ClassNotFoundException {
        return orderDAOImpl.generateCustomerCount();
    }

    @Override
    public String generateNextOrderId() throws SQLException, ClassNotFoundException {
        return orderDAOImpl.generateNextOrderId();
    }

    @Override
    public StockDTO searchItem(String code) throws SQLException, ClassNotFoundException {
        StockAtStore stockAtStore = stockDAOImpl.search(code);
        return new StockDTO(stockAtStore.getProductId(),stockAtStore.getItemDescription(),stockAtStore.getQtyOnHand(),stockAtStore.getMeasuredUnits(),stockAtStore.getUnitRate(),stockAtStore.getCategory(),stockAtStore.getSubCategory(),stockAtStore.getBrandName(),stockAtStore.getItemImage());
    }


}
