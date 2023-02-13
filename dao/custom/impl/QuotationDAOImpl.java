package lk.ijse.finalproject.dao.custom.impl;

import lk.ijse.finalproject.dao.custom.QuotationDAO;
import lk.ijse.finalproject.dao.util.CrudUtil;
import lk.ijse.finalproject.entity.Quotation;
import lk.ijse.finalproject.entity.Storekeeper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class QuotationDAOImpl implements QuotationDAO{
    @Override
    public boolean add(Quotation quotationDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Quotation VALUES (?,?,?,?,?,?,?,?,?,?)",quotationDTO.getQuotationId(),
                quotationDTO.getSupplierCategory(),quotationDTO.getDescription(),quotationDTO.getQty(),quotationDTO.getMeasuredUnits(),
                quotationDTO.getMaximumAmount(),quotationDTO.getCalledDate(),quotationDTO.getOpenedDate(),quotationDTO.getStorekeeperID(),
                quotationDTO.getSupplierID());
    }

    @Override
    public boolean delete(String quotationId) throws SQLException, ClassNotFoundException {
       return CrudUtil.execute("DELETE FROM Quotation WHERE quotationId=?",quotationId);

    }

    @Override
    public boolean update(Quotation quotationDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Quotation SET supplierCategory=?,description=?,qty=?,measuredUnits=?,maximumAmount=?,calledDate=?,openedDate=?,storekeeperID=?,supplierID=? WHERE quotationId=?",
                quotationDTO.getSupplierCategory(),quotationDTO.getDescription(),quotationDTO.getQty(),quotationDTO.getMeasuredUnits(),quotationDTO.getMaximumAmount(),quotationDTO.getCalledDate(),quotationDTO.getOpenedDate(),quotationDTO.getStorekeeperID(),quotationDTO.getSupplierID(),quotationDTO.getQuotationId());
    }

    @Override
    public Quotation search(String quotationId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Quotation WHERE quotationId=?",quotationId);
        while (resultSet.next()){
            return new Quotation(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getDouble(4),resultSet.getString(5),resultSet.getDouble(6), LocalDate.parse(resultSet.getString(7)),LocalDate.parse(resultSet.getString(8)),resultSet.getString(9),resultSet.getString(10));
        }
        return null;
    }

    @Override
    public ArrayList<Quotation> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Quotation");
        ArrayList <Quotation> details = new ArrayList<>();
        while (resultSet.next()) {
            Quotation quotationDTO = new Quotation(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getDouble(4),resultSet.getString(5),resultSet.getDouble(6), LocalDate.parse(resultSet.getString(7)),LocalDate.parse(resultSet.getString(8)),resultSet.getString(9),resultSet.getString(10));
            details.add(quotationDTO);
        }
        return details;
    }

    @Override
    public ArrayList<String> productDescriptionsEligibleForPO() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT description FROM Quotation");
        ArrayList<String> descriptionList = new ArrayList<>();

        while (resultSet.next()) {
            descriptionList.add(resultSet.getString(1));
        }
        return descriptionList;
    }
}
