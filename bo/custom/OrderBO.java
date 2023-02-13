package lk.ijse.finalproject.bo.custom;

import lk.ijse.finalproject.dto.OrderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderBO extends SuperBO{

    ArrayList<OrderDTO> getTotalIncome() throws SQLException,ClassNotFoundException;
}
