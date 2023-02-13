package lk.ijse.finalproject.dao.custom;

import lk.ijse.finalproject.dao.CrudDAO;
import lk.ijse.finalproject.dto.OrderDetailDTO;
import lk.ijse.finalproject.dto.StockDTO;
import lk.ijse.finalproject.entity.OrderDetail;
import rex.utils.S;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDetailDAO extends CrudDAO<OrderDetail, String > {
    public  boolean saveOrderDetails(ArrayList<OrderDetail> orderDetails) throws SQLException, ClassNotFoundException;
    public  boolean add(OrderDetail orderDetail) throws SQLException, ClassNotFoundException;
    public  double collectIncome() throws SQLException, ClassNotFoundException;
    public ArrayList<OrderDetail> getTopSellingItemOrder() throws SQLException, ClassNotFoundException;
}
