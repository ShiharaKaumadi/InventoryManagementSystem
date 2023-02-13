package lk.ijse.finalproject.dao.custom;

import lk.ijse.finalproject.dao.CrudDAO;
import lk.ijse.finalproject.dto.ReturnsDTO;
import lk.ijse.finalproject.entity.ReturnItems;

import java.sql.SQLException;

public interface ReturnsDAO extends CrudDAO<ReturnItems,String> {
    String generateNextReturnId() throws SQLException, ClassNotFoundException;
}
