package lk.ijse.finalproject.bo.custom;

import lk.ijse.finalproject.dto.SupplierDTO;
import lk.ijse.finalproject.entity.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierBO extends SuperBO{
    ArrayList<SupplierDTO> selectAllSuppliers() throws SQLException, ClassNotFoundException;

    boolean addSupplier(SupplierDTO supplier) throws SQLException, ClassNotFoundException;

    SupplierDTO searchSupplier(String id) throws SQLException, ClassNotFoundException;

    boolean updateSupplier(SupplierDTO supplier) throws SQLException, ClassNotFoundException;

    boolean deleteSupplier(String id) throws SQLException, ClassNotFoundException;

    ArrayList<SupplierDTO> getAllSuppliers() throws SQLException, ClassNotFoundException;
}
