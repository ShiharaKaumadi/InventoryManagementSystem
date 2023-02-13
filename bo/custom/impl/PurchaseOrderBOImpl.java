package lk.ijse.finalproject.bo.custom.impl;

import lk.ijse.finalproject.bo.custom.PurchaseOrderBO;
import lk.ijse.finalproject.dao.DAOFactory;
import lk.ijse.finalproject.dao.DAOTypes;
import lk.ijse.finalproject.dao.custom.PurchaseOrderDAO;
import lk.ijse.finalproject.dao.custom.QueryDAO;
import lk.ijse.finalproject.dao.custom.QuotationDAO;
import lk.ijse.finalproject.dto.PurchaseOrderDTO;
import lk.ijse.finalproject.entity.PurchaseOrder;

import java.sql.SQLException;
import java.util.ArrayList;

public class PurchaseOrderBOImpl implements PurchaseOrderBO {
    PurchaseOrderDAO purchaseOrderDAOImpl = (PurchaseOrderDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.PURCHASE_ORDER);
    QuotationDAO quotationDAOImpl = (QuotationDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.QUOTATION);
    QueryDAO queryDAOImpl = (QueryDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.QUERY);
    @Override
    public boolean addPurchaseOrder(PurchaseOrderDTO purchaseOrderDTO) throws SQLException, ClassNotFoundException {
       return purchaseOrderDAOImpl.add(new PurchaseOrder(purchaseOrderDTO.getPurchaseOrderId(),purchaseOrderDTO.getPurchaseCategory(),purchaseOrderDTO.getProductID(),purchaseOrderDTO.getProductName(),purchaseOrderDTO.getMeasuredUnits(),purchaseOrderDTO.getQty(),purchaseOrderDTO.getUnitRate(),purchaseOrderDTO.getOrderDate(),purchaseOrderDTO.getDeliverBefore(),purchaseOrderDTO.getSupplierID(),purchaseOrderDTO.getStoreKeeperID()));
    }

    @Override
    public ArrayList<String> loadProductIdsEligibleForPO() throws SQLException, ClassNotFoundException{
        return queryDAOImpl.productsEligibleForPO();
    }

    @Override
    public ArrayList<String> loadProductDescriptionsEligibleForPO() throws SQLException, ClassNotFoundException {
        return quotationDAOImpl.productDescriptionsEligibleForPO();
    }

    @Override
    public String generateNextPurchaseOrderId() throws SQLException, ClassNotFoundException {
        return purchaseOrderDAOImpl.generateNextPurchaseOrderID();
    }

    @Override
    public PurchaseOrderDTO searchPurchaseOrder(String purchaseOrderId) throws SQLException, ClassNotFoundException {
        PurchaseOrder purchaseOrderDTO = purchaseOrderDAOImpl.search(purchaseOrderId);
        return new PurchaseOrderDTO(purchaseOrderDTO.getPurchaseOrderId(),purchaseOrderDTO.getPurchaseCategory(),purchaseOrderDTO.getProductID(),purchaseOrderDTO.getProductName(),purchaseOrderDTO.getMeasuredUnits(),purchaseOrderDTO.getQty(),purchaseOrderDTO.getUnitRate(),purchaseOrderDTO.getOrderDate(),purchaseOrderDTO.getDeliverBefore(),purchaseOrderDTO.getSupplierID(),purchaseOrderDTO.getStoreKeeperID());
    }

    @Override
    public boolean updatePurchaseOrder(PurchaseOrderDTO purchaseOrderDTO) throws SQLException, ClassNotFoundException {
        return purchaseOrderDAOImpl.update(new PurchaseOrder(purchaseOrderDTO.getPurchaseOrderId(),purchaseOrderDTO.getPurchaseCategory(),purchaseOrderDTO.getProductID(),purchaseOrderDTO.getProductName(),purchaseOrderDTO.getMeasuredUnits(),purchaseOrderDTO.getQty(),purchaseOrderDTO.getUnitRate(),purchaseOrderDTO.getOrderDate(),purchaseOrderDTO.getDeliverBefore(),purchaseOrderDTO.getSupplierID(),purchaseOrderDTO.getStoreKeeperID()));
    }
    @Override
    public boolean deletePurchaseOrder(String id) throws SQLException, ClassNotFoundException {
        return purchaseOrderDAOImpl.delete(id);
    }


}
