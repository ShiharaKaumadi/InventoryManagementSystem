package lk.ijse.finalproject.dao.custom;

import lk.ijse.finalproject.dao.CrudDAO;
import lk.ijse.finalproject.dto.PurchaseOrderDTO;
import lk.ijse.finalproject.entity.PurchaseOrder;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PurchaseOrderDAO extends CrudDAO<PurchaseOrder,String> {
    ArrayList<String> productsEligibleForPO() throws SQLException, ClassNotFoundException;

    String generateNextPurchaseOrderID()throws SQLException, ClassNotFoundException;
}
