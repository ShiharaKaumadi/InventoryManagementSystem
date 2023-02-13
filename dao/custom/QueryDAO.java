package lk.ijse.finalproject.dao.custom;

import lk.ijse.finalproject.dao.SuperDAO;
import lk.ijse.finalproject.dto.CustomDTO;
import lk.ijse.finalproject.dto.customSuppliersDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
    ArrayList<CustomDTO> getOrderDetailsFromOrderId(String orderId) throws SQLException, ClassNotFoundException;
    String sendEmailToSupplier(String empId)throws SQLException, ClassNotFoundException;
    ArrayList<String> productsEligibleForPO() throws SQLException, ClassNotFoundException;
}
