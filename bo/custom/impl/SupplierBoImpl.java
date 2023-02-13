package lk.ijse.finalproject.bo.custom.impl;

import lk.ijse.finalproject.bo.custom.SupplierBO;
import lk.ijse.finalproject.dao.DAOFactory;
import lk.ijse.finalproject.dao.DAOTypes;
import lk.ijse.finalproject.dao.custom.SupplierDAO;
import lk.ijse.finalproject.dto.SupplierDTO;
import lk.ijse.finalproject.entity.Supplier;
import rex.utils.S;

import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierBoImpl implements SupplierBO {
    SupplierDAO supplierDAO = (SupplierDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.SUPPLIER);
    @Override
    public ArrayList<SupplierDTO> selectAllSuppliers() throws SQLException, ClassNotFoundException {
        ArrayList <SupplierDTO> supplierDTOS = new ArrayList<>();
        ArrayList<Supplier> suppliers = supplierDAO.selectAllSuppliers();
        for (Supplier supplier: suppliers){
            supplierDTOS.add(new SupplierDTO(supplier.getSupplierId(),supplier.getCompanyName(),supplier.getAddress(),supplier.getEmail(),supplier.getContactNo(),supplier.getContactPerson(),supplier.getSupplierCategory(),supplier.getSupplierSubCategory(),supplier.getSupplierBrandName(),supplier.getProductID()));
        }
        return supplierDTOS;
    }


    @Override
    public boolean addSupplier(SupplierDTO supplier) throws SQLException, ClassNotFoundException {
        return supplierDAO.add(new Supplier(supplier.getSupplierId(),supplier.getCompanyName(),supplier.getAddress(),supplier.getEmail(),supplier.getContactNo(),supplier.getContactPerson(),supplier.getSupplierCategory(),supplier.getSupplierSubCategory(),supplier.getBrandName(),supplier.getProductId()));
    }

    @Override
    public SupplierDTO searchSupplier(String id) throws SQLException, ClassNotFoundException {
        Supplier supplier = supplierDAO.search(id);
        return new SupplierDTO(supplier.getSupplierId(),supplier.getCompanyName(),supplier.getAddress(),supplier.getEmail(),supplier.getContactNo(),supplier.getContactPerson(),supplier.getSupplierCategory(),supplier.getSupplierSubCategory(),supplier.getSupplierBrandName(),supplier.getProductID());
    }

    @Override
    public boolean updateSupplier(SupplierDTO supplier) throws SQLException, ClassNotFoundException {
        return supplierDAO.update(new Supplier(supplier.getSupplierId(),supplier.getCompanyName(),supplier.getAddress(),supplier.getEmail(),supplier.getContactNo(),supplier.getContactPerson(),supplier.getSupplierCategory(),supplier.getSupplierSubCategory(),supplier.getBrandName(),supplier.getProductId()));
    }

    @Override
    public boolean deleteSupplier(String id) throws SQLException, ClassNotFoundException {
        return supplierDAO.delete(id);
    }

    @Override
    public ArrayList<SupplierDTO> getAllSuppliers() throws SQLException, ClassNotFoundException {
        ArrayList <SupplierDTO> supplierDTOS = new ArrayList<>();
        ArrayList<Supplier> all = supplierDAO.getAll();
        for (Supplier supplier:all){
            supplierDTOS.add(new SupplierDTO(supplier.getSupplierId(),supplier.getCompanyName(),supplier.getAddress(),supplier.getEmail(),supplier.getContactNo(),supplier.getContactPerson(),supplier.getSupplierCategory(),supplier.getSupplierSubCategory(),supplier.getSupplierBrandName(),supplier.getProductID()));
        }
        return supplierDTOS;
    }
}
