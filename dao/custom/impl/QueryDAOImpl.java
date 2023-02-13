package lk.ijse.finalproject.dao.custom.impl;

import lk.ijse.finalproject.dao.SuperDAO;
import lk.ijse.finalproject.dao.custom.QueryDAO;
import lk.ijse.finalproject.dao.util.CrudUtil;
import lk.ijse.finalproject.dto.CustomDTO;
import lk.ijse.finalproject.dto.customSuppliersDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {
    public ArrayList<CustomDTO> getOrderDetailsFromOrderId(String orderId)  throws SQLException, ClassNotFoundException  {
        ArrayList<CustomDTO> customDTOArrayList = new ArrayList<>();
        ResultSet resultSet = CrudUtil.execute("SELECT o.orderId,o.date,o.customerId,od.orderID,od.productID,od.description,od.qty,od.unitRate FROM `Order` o INNER JOIN OrderDetail od ON o.orderId=od.orderID WHERE o.orderId=?", orderId);
        while (resultSet.next()) {
            customDTOArrayList.add(new CustomDTO(resultSet.getString("orderId"), LocalDate.parse(resultSet.getString("date")),resultSet.getString("customerId"),resultSet.getString("productID"),resultSet.getString("description"),resultSet.getDouble("qty"),resultSet.getDouble("unitRate")));
        }
      return customDTOArrayList;
    }

    @Override
    public String sendEmailToSupplier(String empId) throws SQLException, ClassNotFoundException {

        ResultSet resultSet = CrudUtil.execute("SELECT s.storeKeeperId,s.empId,sk.empId,sk.email FROM Storekeeper s INNER Join  Employee sk  ON s.empId=sk.empId WHERE s.storeKeeperId=?",empId);
        while (resultSet.next()) {
            return resultSet.getString(4);
        }
        return null;
    }

    @Override
    public ArrayList<String> productsEligibleForPO() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT p.description,s.itemDescription, s.productId FROM Quotation p INNER Join  StockAtStore s  ON s.itemDescription=p.description");
        ArrayList<String> idList = new ArrayList<>();

        while (resultSet.next()) {
            idList.add(resultSet.getString(3));
        }
        return idList;
    }




}
