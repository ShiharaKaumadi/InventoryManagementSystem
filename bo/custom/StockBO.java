package lk.ijse.finalproject.bo.custom;

import lk.ijse.finalproject.dto.OrderDetailDTO;
import lk.ijse.finalproject.dto.StockDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StockBO extends SuperBO{

    boolean addNewStock(StockDTO stockAtStore) throws SQLException, ClassNotFoundException;
    ArrayList<StockDTO> getAllStockDetails() throws SQLException, ClassNotFoundException;

    double collectStockValue() throws SQLException, ClassNotFoundException;
    ArrayList<StockDTO> getStockValuePerEachItem() throws SQLException, ClassNotFoundException;


    ArrayList<String> collectProductNames() throws SQLException, ClassNotFoundException;

    ArrayList<String> collectAvailableItemCategories() throws SQLException, ClassNotFoundException;

    ArrayList<String> collectProductBrandNames() throws SQLException, ClassNotFoundException;

    ArrayList<String> collectAvailableItemSubCategories() throws SQLException, ClassNotFoundException;

    ArrayList<String> collectAvailableProductCodes() throws SQLException, ClassNotFoundException;

    ArrayList<String> chooseDescription() throws SQLException, ClassNotFoundException;

    StockDTO searchStockDetails(String code) throws SQLException, ClassNotFoundException;

    StockDTO searchDetailsWithDescription(String description) throws SQLException, ClassNotFoundException;

    ArrayList<OrderDetailDTO> getTopItemList()throws SQLException, ClassNotFoundException;

    ArrayList<StockDTO> getNotAvailableItemList()throws SQLException, ClassNotFoundException;

    void deleteStock(String id)throws SQLException, ClassNotFoundException;

    ArrayList<String> collectUnAvailableProductCodes() throws SQLException, ClassNotFoundException;
}
