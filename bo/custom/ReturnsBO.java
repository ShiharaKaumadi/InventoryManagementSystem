package lk.ijse.finalproject.bo.custom;

import lk.ijse.finalproject.dto.ReturnsDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReturnsBO extends SuperBO{
    ArrayList<ReturnsDTO> getAllReturns() throws SQLException, ClassNotFoundException;

    String getNextReturnId() throws SQLException, ClassNotFoundException;

    boolean saveReturn(ReturnsDTO returnsDTO) throws SQLException, ClassNotFoundException;

    ReturnsDTO searchReturnItem(String id) throws SQLException, ClassNotFoundException;

    boolean editReturnDetails(ReturnsDTO returnsDTO)throws SQLException, ClassNotFoundException;

    boolean deleteReturn(String id)throws SQLException, ClassNotFoundException;
}
