package lk.ijse.finalproject.bo.custom;

import lk.ijse.finalproject.dto.CustomDTO;
import lk.ijse.finalproject.dto.QuotationDTO;
import lk.ijse.finalproject.dto.customSuppliersDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QuotationBO extends SuperBO{
    String sendEmailToSupplier(String skId) throws SQLException, ClassNotFoundException;

    boolean addQuotation(QuotationDTO quotationDTO) throws SQLException, ClassNotFoundException;

    QuotationDTO searchQuotation(String quotationId) throws SQLException, ClassNotFoundException;

    boolean updateQuotation(QuotationDTO quotationDTO) throws SQLException, ClassNotFoundException;

    boolean deleteQuotation(String id) throws SQLException, ClassNotFoundException;
}
