package lk.ijse.finalproject.dao.custom.impl;

import lk.ijse.finalproject.dao.custom.OrderDAO;
import lk.ijse.finalproject.dao.util.CrudUtil;
import lk.ijse.finalproject.entity.Order;
import lk.ijse.finalproject.entity.Storekeeper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {
    public  String generateNextOrderId() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT orderId FROM `Order` ORDER BY orderId DESC LIMIT 1");

        if (result.next()) {
            return generateNextOrderId(result.getString(1));
        }
        return generateNextOrderId(null);
    }

    private  String generateNextOrderId(String currentOrderId) {
        if (currentOrderId != null) {
            String[] split = currentOrderId.split("-");
            int id = Integer.parseInt(split[1]);
            id +=1;
            return String.valueOf("D0-") + id;
        }
        return "D0-1";

    }
    @Override
    public  boolean add(Order order) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO  `Order` VALUES(?, ?, ?, ?, ?)", order.getOrderId(), order.getDate(), order.getTime(), order.getTotalAmount(), order.getCustomerID());
    }

    @Override
    public boolean delete(String orderId) throws SQLException, ClassNotFoundException {
        try {
            return CrudUtil.execute("DELETE `Order` WHERE orderId=?",orderId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Order orderDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE `Order` SET date=?, time =?, totalAmount=? WHERE orderId=?",
                orderDTO.getDate(),orderDTO.getTime(),orderDTO.getTotalAmount(),orderDTO.getOrderId());
    }

    @Override
    public Order search(String orderId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM `Order` WHERE orderId=?",orderId);
        if (resultSet.next()){
            return new Order(
                    resultSet.getString(1),
                    resultSet.getObject(2,LocalDate.class),
                    resultSet.getObject(3,LocalTime.class),
                    resultSet.getDouble(4),
                    resultSet.getString(5));
        }
        return null;
    }

    public ArrayList<Order> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM `Order`");
        ArrayList<Order> arrayList = new ArrayList<>();
        while (resultSet.next()){
            arrayList.add(new Order(resultSet.getString(1),resultSet.getObject(2,LocalDate.class),resultSet.getObject(3, LocalTime.class),resultSet.getDouble(4),resultSet.getString(5)));

        }
        return  arrayList;
    }

    public  String generateCustomerCount() throws SQLException, ClassNotFoundException {
        String sql = "SELECT orderId FROM `Order` ORDER BY orderId DESC LIMIT 1";
        ResultSet result = CrudUtil.execute(sql);

        if (result.next()) {
            return generateCustomercount(result.getString(1));
        }
        return generateCustomercount("D0-1");
    }

    private  String generateCustomercount(String id) {
        if (id != null) {
            String[] split = id.split("D0-");
            int count = Integer.parseInt(split[1]);

            return String.valueOf(count);
        }
        return "1";

    }
}
