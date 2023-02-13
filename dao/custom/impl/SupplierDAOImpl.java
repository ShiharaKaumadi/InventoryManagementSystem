package lk.ijse.finalproject.dao.custom.impl;

import lk.ijse.finalproject.dao.custom.SupplierDAO;
import lk.ijse.finalproject.dao.util.CrudUtil;
import lk.ijse.finalproject.entity.Storekeeper;
import lk.ijse.finalproject.entity.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierDAOImpl implements SupplierDAO {
    public Supplier search(String id) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM Supplier WHERE supplierId = ?", id);

        if(result.next()) {
            return new Supplier(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6),
                    result.getString(7),
                    result.getString(8),
                    result.getString(9),
                    result.getString(10)
            );
        }
        return null;
    }

    public  boolean add(Supplier supplier) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Supplier VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", supplier.getSupplierId(), supplier.getCompanyName(), supplier.getAddress(), supplier.getEmail(), supplier.getContactNo(), supplier.getContactPerson(), supplier.getSupplierCategory(), supplier.getSupplierSubCategory(), supplier.getSupplierBrandName(), supplier.getProductID());
    }

    public  boolean update(Supplier supplier) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Supplier SET companyName=?, address=?, email=?,contactNo=?, contactPerson=?, supplierCategory=?,supplierSubCategory=?,supplierBrandName=?,productId=? WHERE supplierId=?",
                supplier.getCompanyName(),
                supplier.getAddress(),
                supplier.getEmail(),
                supplier.getContactNo(),
                supplier.getContactPerson(),
                supplier.getSupplierCategory(),
                supplier.getSupplierSubCategory(),
                supplier.getSupplierBrandName(),
                supplier.getProductID());
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("Delete From Supplier where supplierId=?",id);
    }


    public ArrayList<Supplier> selectAllSuppliers() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT supplierId,companyName,address,email,contactNo,contactPerson  FROM Supplier");
        ArrayList <Supplier> details = new ArrayList<>();
        while(result.next()) {

            Supplier supplier = new Supplier(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6));
            details.add(supplier) ;

        }
        return details;
    }

    public ArrayList<Supplier> getAll() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT *  FROM Supplier");
        ArrayList <Supplier> details = new ArrayList<>();
        while(result.next()) {

            Supplier supplier = new Supplier(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8), result.getString(9),result.getString(10));
            details.add(supplier) ;
            System.out.println(details);

        }
        return details;
    }

    @Override
    public String count() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT COUNT(supplierId) FROM Supplier");
        if (result.next()) {
            return(result.getString(1));
        }
        return (null);
    }


}
