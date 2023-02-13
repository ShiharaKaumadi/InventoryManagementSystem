package lk.ijse.finalproject.dao.custom;

import lk.ijse.finalproject.dao.CrudDAO;
import lk.ijse.finalproject.dto.SupplierDTO;
import lk.ijse.finalproject.entity.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierDAO extends CrudDAO<Supplier,String> {
    ArrayList<Supplier> selectAllSuppliers() throws SQLException, ClassNotFoundException;
    String count() throws SQLException, ClassNotFoundException;
}
