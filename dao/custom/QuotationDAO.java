package lk.ijse.finalproject.dao.custom;

import lk.ijse.finalproject.dao.CrudDAO;
import lk.ijse.finalproject.dto.QuotationDTO;
import lk.ijse.finalproject.entity.Quotation;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QuotationDAO extends CrudDAO<Quotation,String> {
    ArrayList<String> productDescriptionsEligibleForPO() throws SQLException, ClassNotFoundException;
}
