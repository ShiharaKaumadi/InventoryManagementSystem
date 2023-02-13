package lk.ijse.finalproject.dao.custom;

import lk.ijse.finalproject.dao.CrudDAO;
import lk.ijse.finalproject.dto.MinDTO;
import lk.ijse.finalproject.dto.MrnDTO;
import lk.ijse.finalproject.entity.Min;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MinDAO extends CrudDAO<Min, String> {
    String getNextMinId() throws SQLException, ClassNotFoundException;


}
