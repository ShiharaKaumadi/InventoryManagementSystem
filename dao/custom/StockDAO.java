package lk.ijse.finalproject.dao.custom;

import lk.ijse.finalproject.dao.CrudDAO;
import lk.ijse.finalproject.entity.OrderDetail;
import lk.ijse.finalproject.entity.StockAtStore;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StockDAO extends CrudDAO<StockAtStore,String> {


    ArrayList<String> collectAvailableProductCodes() throws SQLException, ClassNotFoundException;
    ArrayList<String> insertDescription() throws SQLException, ClassNotFoundException;

     StockAtStore searchItem(String code) throws SQLException, ClassNotFoundException ;

    StockAtStore searchDetails(String description) throws SQLException, ClassNotFoundException;

    boolean updateQty(ArrayList<OrderDetail> orderDetails) throws SQLException, ClassNotFoundException;

    ArrayList<StockAtStore> getAllStockValue() throws SQLException, ClassNotFoundException ;

    double collectStockValue() throws SQLException, ClassNotFoundException;

    public ArrayList<String> collectAvailableItemCategories() throws SQLException, ClassNotFoundException;
    public ArrayList<String> collectAvailableItemSubCategories() throws SQLException, ClassNotFoundException;

    public ArrayList<String> collectProductBrandNames() throws SQLException, ClassNotFoundException;
    public ArrayList<String> collectProductNames() throws SQLException, ClassNotFoundException;


    ArrayList<StockAtStore> getNotAvailableList()throws SQLException, ClassNotFoundException;

    ArrayList<String> getUnAvailableIDList()throws SQLException, ClassNotFoundException;


}
