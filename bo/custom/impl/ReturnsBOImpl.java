package lk.ijse.finalproject.bo.custom.impl;

import lk.ijse.finalproject.bo.custom.ReturnsBO;
import lk.ijse.finalproject.dao.DAOFactory;
import lk.ijse.finalproject.dao.DAOTypes;
import lk.ijse.finalproject.dao.custom.OrderDAO;
import lk.ijse.finalproject.dao.custom.ReturnsDAO;
import lk.ijse.finalproject.dao.custom.StockDAO;
import lk.ijse.finalproject.db.DBConnection;
import lk.ijse.finalproject.dto.OrderDTO;
import lk.ijse.finalproject.dto.ReturnsDTO;
import lk.ijse.finalproject.entity.ReturnItems;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ReturnsBOImpl implements ReturnsBO {
    ReturnsDAO returnsDAOImpl = (ReturnsDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.RETURNITEMS);
    StockDAO stockDAOImpl = (StockDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.STOCK);
    OrderDAO orderDAOImpl = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.ORDER);
    @Override
    public ArrayList<ReturnsDTO> getAllReturns() throws SQLException, ClassNotFoundException {
        ArrayList <ReturnsDTO> returnsDTOS = new ArrayList<>();
        ArrayList<ReturnItems> all = returnsDAOImpl.getAll();
        for (ReturnItems returnItems:all){
            returnsDTOS.add(new ReturnsDTO(returnItems.getReturnId(),returnItems.getReturnDate(),returnItems.getProductID(),returnItems.getQty(),returnItems.getCustomerID()));
        }
        return returnsDTOS;
    }

    @Override
    public String getNextReturnId()  throws SQLException, ClassNotFoundException {
        return returnsDAOImpl.generateNextReturnId();
    }

    @Override
    public boolean saveReturn(ReturnsDTO returnItems) throws SQLException, ClassNotFoundException {
        return returnsDAOImpl.add(new ReturnItems(returnItems.getReturnId(),returnItems.getReturnDate(),returnItems.getProductID(),returnItems.getQty(),returnItems.getCustomerID()));
    }

    @Override
    public ReturnsDTO searchReturnItem(String id) throws SQLException, ClassNotFoundException {
        ReturnItems returnItems = returnsDAOImpl.search(id);
        return new ReturnsDTO(returnItems.getReturnId(),returnItems.getReturnDate(),returnItems.getProductID(),returnItems.getQty(),returnItems.getCustomerID());
    }

    @Override
    public boolean editReturnDetails(ReturnsDTO returnItems) throws SQLException, ClassNotFoundException {
        return returnsDAOImpl.update(new ReturnItems(returnItems.getReturnId(),returnItems.getReturnDate(),returnItems.getProductID(),returnItems.getQty(),returnItems.getCustomerID()));
    }

    @Override
    public boolean deleteReturn(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
