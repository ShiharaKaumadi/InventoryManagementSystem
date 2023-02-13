package lk.ijse.finalproject.bo.custom;

import lk.ijse.finalproject.dto.GrnDTO;

import java.sql.SQLException;

public interface GrnBO extends SuperBO{
    String getNextGrnId() throws SQLException, ClassNotFoundException;

    boolean addGrn(GrnDTO grn) throws SQLException, ClassNotFoundException;
}
