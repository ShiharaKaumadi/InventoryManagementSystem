package lk.ijse.finalproject.dao.custom.impl;

import lk.ijse.finalproject.dao.custom.OrderDetailDAO;
import lk.ijse.finalproject.dao.util.CrudUtil;
import lk.ijse.finalproject.entity.OrderDetail;
import lk.ijse.finalproject.entity.Storekeeper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    public  boolean saveOrderDetails(ArrayList<OrderDetail> orderDetails) throws SQLException, ClassNotFoundException {
        for (OrderDetail orderDetail : orderDetails) {
            if (!add(orderDetail)) {
                return false;
            }
        }
        return true;
    }

    public  boolean add(OrderDetail orderDetail) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO OrderDetail VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        return CrudUtil.execute(sql, orderDetail.getOrderId(), orderDetail.getProductID(), orderDetail.getDescription(), orderDetail.getQty(),orderDetail.getMeasuredUnits(),orderDetail.getUnitPrice(),orderDetail.getDailyIncome(),orderDetail.getCategory(),orderDetail.getSubCategory(),orderDetail.getBrandName());
    }

    @Override
    public boolean delete(String orderId) throws SQLException, ClassNotFoundException {
        try {
            return CrudUtil.execute("DELETE OrderDetail WHERE orderID=?",orderId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(OrderDetail orderDetailDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE `Order` SET date=?, time =?, totalAmount=? WHERE orderId=?",
                orderDetailDTO.getProductID(),orderDetailDTO.getDescription(),orderDetailDTO.getQty(),orderDetailDTO.getMeasuredUnits(),orderDetailDTO.getUnitPrice(),orderDetailDTO.getDailyIncome(),orderDetailDTO.getCategory(),orderDetailDTO.getSubCategory(),orderDetailDTO.getBrandName());
    }

    @Override
    public OrderDetail search(String orderId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM OrderDetail WHERE orderId=?",orderId);
        if (resultSet.next()){
            return new OrderDetail(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4),
                    resultSet.getString(5),
                    resultSet.getDouble(6),
                    resultSet.getDouble(7),
                    resultSet.getString(8),
                    resultSet.getString(9),
                    resultSet.getString(10));
        }
        return null;
    }

    @Override
    public ArrayList<OrderDetail> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM OrderDetail");
        ArrayList<OrderDetail> arrayList = new ArrayList<>();
        while (resultSet.next()){
            arrayList.add(new OrderDetail(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4),
                    resultSet.getString(5),
                    resultSet.getDouble(6),
                    resultSet.getDouble(7),
                    resultSet.getString(8),
                    resultSet.getString(9),
                    resultSet.getString(10)));
        }
        return  arrayList;
    }


    public  double collectIncome() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT SUM(dailyIncome) FROM OrderDetail");

        if (result.next()) {
            return result.getDouble(1);

        }
        return 0;
    }

    @Override
    public ArrayList<OrderDetail> getTopSellingItemOrder() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT productID, SUM(qty),description, unitRate FROM OrderDetail GROUP BY productID ORDER BY SUM(qty) DESC");

        ArrayList<OrderDetail> topSellingList = new ArrayList<>();

        while (result.next()) {
            topSellingList.add(new OrderDetail(result.getString(1),result.getDouble(2),result.getString(3),result.getDouble(4)));

        }
        return topSellingList;
    }
}
