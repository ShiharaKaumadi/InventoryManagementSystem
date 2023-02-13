package lk.ijse.finalproject.dao.custom;

import lk.ijse.finalproject.dao.CrudDAO;
import lk.ijse.finalproject.dto.PlaceOrderDTO;

import java.sql.SQLException;

public interface PlaceOrderDAO  {
    public  boolean placeOrder(PlaceOrderDTO placeOrder) throws SQLException, ClassNotFoundException;
}
