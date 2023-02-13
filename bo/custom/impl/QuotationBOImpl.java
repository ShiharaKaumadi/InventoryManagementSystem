package lk.ijse.finalproject.bo.custom.impl;

import lk.ijse.finalproject.bo.custom.QuotationBO;
import lk.ijse.finalproject.dao.DAOFactory;
import lk.ijse.finalproject.dao.DAOTypes;
import lk.ijse.finalproject.dao.custom.QueryDAO;
import lk.ijse.finalproject.dao.custom.QuotationDAO;
import lk.ijse.finalproject.dto.CustomDTO;
import lk.ijse.finalproject.dto.QuotationDTO;
import lk.ijse.finalproject.dto.customSuppliersDTO;
import lk.ijse.finalproject.entity.Quotation;

import java.sql.SQLException;
import java.util.ArrayList;

public class QuotationBOImpl implements QuotationBO {
    QueryDAO queryDAOImpl = (QueryDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.QUERY);
    QuotationDAO quotationDAOImpl = (QuotationDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.QUOTATION);
    @Override
    public String sendEmailToSupplier(String skId) throws SQLException, ClassNotFoundException {
       return queryDAOImpl.sendEmailToSupplier(skId);
    }

    @Override
    public boolean addQuotation(QuotationDTO quotationDTO) throws SQLException, ClassNotFoundException {
        return quotationDAOImpl.add(new Quotation(quotationDTO.getQuotationId(),quotationDTO.getSupplierCategory(),quotationDTO.getDescription(),quotationDTO.getQty(),quotationDTO.getMeasuredUnits(),quotationDTO.getMaximumAmount(),quotationDTO.getCalledDate(),quotationDTO.getOpenedDate(),quotationDTO.getStorekeeperID(),quotationDTO.getSupplierID()));
    }

    @Override
    public QuotationDTO searchQuotation(String quotationId) throws SQLException, ClassNotFoundException {
        Quotation quotationDTO = quotationDAOImpl.search(quotationId);
        return new QuotationDTO(quotationDTO.getQuotationId(),quotationDTO.getSupplierCategory(),quotationDTO.getDescription(),quotationDTO.getQty(),quotationDTO.getMeasuredUnits(),quotationDTO.getMaximumAmount(),quotationDTO.getCalledDate(),quotationDTO.getOpenedDate(),quotationDTO.getStorekeeperID(),quotationDTO.getSupplierID());
    }

    @Override
    public boolean updateQuotation(QuotationDTO quotationDTO) throws SQLException, ClassNotFoundException {
        return quotationDAOImpl.update(new Quotation(quotationDTO.getQuotationId(),quotationDTO.getSupplierCategory(),quotationDTO.getDescription(),quotationDTO.getQty(),quotationDTO.getMeasuredUnits(),quotationDTO.getMaximumAmount(),quotationDTO.getCalledDate(),quotationDTO.getOpenedDate(),quotationDTO.getStorekeeperID(),quotationDTO.getSupplierID()));
    }

    @Override
    public boolean deleteQuotation(String id) throws SQLException, ClassNotFoundException {
        return quotationDAOImpl.delete(id);
    }
}
