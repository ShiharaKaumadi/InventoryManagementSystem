package lk.ijse.finalproject.dao.custom.impl;

import lk.ijse.finalproject.dao.custom.PurchaseOrderDAO;
import lk.ijse.finalproject.dao.util.CrudUtil;
import lk.ijse.finalproject.dto.PurchaseOrderDTO;
import lk.ijse.finalproject.entity.PurchaseOrder;
import lk.ijse.finalproject.entity.Storekeeper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class PurchaseOrderDAOImpl implements PurchaseOrderDAO {
    @Override
    public boolean add(PurchaseOrder purchaseOrderDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO PurchaseOrder VALUES (?,?,?,?,?,?,?,?,?,?,?)",purchaseOrderDTO.getPurchaseOrderId(),
                purchaseOrderDTO.getPurchaseCategory(),purchaseOrderDTO.getProductID(),purchaseOrderDTO.getProductName(),
                purchaseOrderDTO.getMeasuredUnits(),purchaseOrderDTO.getQty(),purchaseOrderDTO.getUnitRate(),
                purchaseOrderDTO.getOrderDate(),purchaseOrderDTO.getDeliverBefore(),purchaseOrderDTO.getSupplierID(),purchaseOrderDTO.getStoreKeeperID());
    }

    @Override
    public boolean delete(String purchaseOrderId) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM PurchaseOrder WHERE purchaseOrderId=?",purchaseOrderId);

    }

    @Override
    public boolean update(PurchaseOrder purchaseOrderDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE PurchaseOrder SET purchaseCategory=?,productID=?,productName=?,measuredUnits=?,qty=?,unitRate=?,orderDate=?,deliverBefore=?,supplierID=?,storeKeeperID=? WHERE purchaseOrderId=?",
                purchaseOrderDTO.getPurchaseCategory(),
                purchaseOrderDTO.getProductID(),
                purchaseOrderDTO.getProductName(),
                purchaseOrderDTO.getMeasuredUnits(),
                purchaseOrderDTO.getQty(),
                purchaseOrderDTO.getUnitRate(),
                purchaseOrderDTO.getOrderDate(),
                purchaseOrderDTO.getDeliverBefore(),
                purchaseOrderDTO.getSupplierID(),
                purchaseOrderDTO.getStoreKeeperID(),
                purchaseOrderDTO.getPurchaseOrderId());

    }

    @Override
    public PurchaseOrder search(String purchaseOrderId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM PurchaseOrder WHERE purchaseOrderId=?",purchaseOrderId);
        while (resultSet.next()) {
            return new PurchaseOrder(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),
                    resultSet.getDouble(6),resultSet.getDouble(7), LocalDate.parse(resultSet.getString(8)),LocalDate.parse(resultSet.getString(9)),
                    resultSet.getString(10),resultSet.getString(11));
        }
        return null;
    }

    @Override
    public ArrayList<PurchaseOrder> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM PurchaseOrder");
        ArrayList<PurchaseOrder> details = new ArrayList<>();
        while (resultSet.next()) {
            PurchaseOrder purchaseOrderDTO = new PurchaseOrder(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),
                    resultSet.getDouble(6),resultSet.getDouble(7), LocalDate.parse(resultSet.getString(8)),LocalDate.parse(resultSet.getString(9)),
                    resultSet.getString(10),resultSet.getString(11));
            details.add(purchaseOrderDTO);
        }
        return details;
    }

    @Override
    public ArrayList<String> productsEligibleForPO() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT description FROM Quotation");
        ArrayList<String> idList = new ArrayList<>();

        while (resultSet.next()) {
            idList.add(resultSet.getString(1));
        }
        return idList;
    }

    @Override
    public String generateNextPurchaseOrderID() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT purchaseOrderId FROM PurchaseOrder ORDER BY purchaseOrderId DESC LIMIT 1");

        if (result.next()) {
            return generateNextOrderId(result.getString(1));
        }
        return generateNextOrderId(null);
    }

    private  String generateNextOrderId(String currentOrderId) {
        if (currentOrderId != null) {
            String[] split = currentOrderId.split("-PO-");
            int id = Integer.parseInt(split[1]);
            id +=1;
            return String.valueOf(LocalDate.now()+"-PO-") + id;
        }
        return LocalDate.now()+"-PO-"+1;


    }
}
