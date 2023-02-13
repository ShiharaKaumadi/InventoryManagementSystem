package lk.ijse.finalproject.bo.custom;

import lk.ijse.finalproject.dto.PlaceOrderDTO;
import lk.ijse.finalproject.dto.StockDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PlaceOrderBO extends SuperBO {
    boolean placeOrder(PlaceOrderDTO placeOrder) throws SQLException, ClassNotFoundException;

    ArrayList<String> loadAllCustomerIds()throws SQLException, ClassNotFoundException;

    ArrayList<String> collectAvailableProductCodes()throws SQLException, ClassNotFoundException;

    String generateCustomerCount()throws SQLException, ClassNotFoundException;

    String generateNextOrderId()throws SQLException, ClassNotFoundException;

    StockDTO searchItem(String code)throws SQLException, ClassNotFoundException;
}
