package lk.ijse.finalproject.dao.custom;

import lk.ijse.finalproject.dao.CrudDAO;
import lk.ijse.finalproject.dto.GrnDTO;
import lk.ijse.finalproject.entity.Grn;

import java.sql.SQLException;

public interface GrnDAO extends CrudDAO<Grn,String> {
    public  boolean add(Grn grn) throws SQLException, ClassNotFoundException;
    public  String getNextGrnId() throws SQLException, ClassNotFoundException;
}
