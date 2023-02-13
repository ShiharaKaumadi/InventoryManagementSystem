package lk.ijse.finalproject.bo.custom;

import lk.ijse.finalproject.dto.PurchaseOrderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PurchaseOrderBO extends SuperBO {
    boolean addPurchaseOrder(PurchaseOrderDTO purchaseOrderDTO) throws SQLException, ClassNotFoundException;

    ArrayList<String> loadProductIdsEligibleForPO() throws SQLException, ClassNotFoundException;

    ArrayList<String> loadProductDescriptionsEligibleForPO() throws SQLException, ClassNotFoundException;

    String generateNextPurchaseOrderId()throws SQLException, ClassNotFoundException;


    PurchaseOrderDTO searchPurchaseOrder(String purchaseOrderId) throws SQLException, ClassNotFoundException;

    boolean updatePurchaseOrder(PurchaseOrderDTO purchaseOrderDTO1)throws SQLException, ClassNotFoundException;

    boolean deletePurchaseOrder(String id)throws SQLException, ClassNotFoundException;
}
