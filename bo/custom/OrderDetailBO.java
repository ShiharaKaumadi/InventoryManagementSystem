package lk.ijse.finalproject.bo.custom;

import lk.ijse.finalproject.dto.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDetailBO extends SuperBO{
    ArrayList<OrderDetailDTO> getTopSellingItemOrder() throws SQLException, ClassNotFoundException;

    double collectTotalIncomeValue() throws SQLException, ClassNotFoundException;
}
