package lk.ijse.finalproject.bo.custom.impl;

import javafx.scene.control.Label;
import lk.ijse.finalproject.bo.custom.StockBO;
import lk.ijse.finalproject.dao.DAOFactory;
import lk.ijse.finalproject.dao.DAOTypes;
import lk.ijse.finalproject.dao.custom.OrderDetailDAO;
import lk.ijse.finalproject.dao.custom.StockDAO;
import lk.ijse.finalproject.dao.custom.impl.StockDAOImpl;
import lk.ijse.finalproject.dto.OrderDetailDTO;
import lk.ijse.finalproject.dto.StockDTO;
import lk.ijse.finalproject.entity.OrderDetail;
import lk.ijse.finalproject.entity.StockAtStore;
import lk.ijse.finalproject.views.tm.CurrentStockTM;
import rex.utils.S;

import java.sql.SQLException;
import java.util.ArrayList;

public class StockBoImpl implements StockBO {
    StockDAO stockDAOImpl = (StockDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.STOCK);
    OrderDetailDAO orderDetailDAO = (OrderDetailDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.ORDER_DETAIL);

    @Override
    public boolean addNewStock(StockDTO stockAtStore) throws SQLException, ClassNotFoundException {
        return stockDAOImpl.add(new StockAtStore(stockAtStore.getStockCode(), stockAtStore.getItemDescription(), stockAtStore.getQtyOnHand(), stockAtStore.getMeasuredUnits(), stockAtStore.getUnitRate(), stockAtStore.getCategory(), stockAtStore.getSubCategory(), stockAtStore.getBrand(), stockAtStore.getImgSrc()));
    }

    @Override
    public ArrayList<StockDTO> getAllStockDetails() throws SQLException, ClassNotFoundException {
        ArrayList<StockDTO> stockDTOS = new ArrayList<>();
        ArrayList<StockAtStore> all = stockDAOImpl.getAll();
        for (StockAtStore stockAtStore : all) {
            stockDTOS.add(new StockDTO(stockAtStore.getProductId(), stockAtStore.getItemDescription(), stockAtStore.getQtyOnHand(), stockAtStore.getMeasuredUnits(), stockAtStore.getUnitRate(), stockAtStore.getCategory(), stockAtStore.getSubCategory(), stockAtStore.getBrandName(), stockAtStore.getItemImage()));
        }
        return stockDTOS;
    }

    @Override
    public double collectStockValue() throws SQLException, ClassNotFoundException {
        return stockDAOImpl.collectStockValue();
    }

    @Override
    public ArrayList<StockDTO> getStockValuePerEachItem() throws SQLException, ClassNotFoundException {
        ArrayList<StockDTO> stockDTOS = new ArrayList<>();
        ArrayList<StockAtStore> all = stockDAOImpl.getAllStockValue();
        for (StockAtStore stockAtStore : all) {
            stockDTOS.add(new StockDTO(stockAtStore.getProductId(), stockAtStore.getItemDescription(), stockAtStore.getQtyOnHand(), stockAtStore.getMeasuredUnits(), stockAtStore.getUnitRate(), stockAtStore.getCategory(), stockAtStore.getSubCategory(), stockAtStore.getBrandName(), stockAtStore.getItemImage()));
        }
        return stockDTOS;
    }


    @Override
    public ArrayList<String> collectProductNames() throws SQLException, ClassNotFoundException {
        return stockDAOImpl.collectProductNames();
    }

    @Override
    public ArrayList<String> collectAvailableItemCategories() throws SQLException, ClassNotFoundException {
        return stockDAOImpl.collectAvailableItemCategories();
    }

    @Override
    public ArrayList<String> collectProductBrandNames() throws SQLException, ClassNotFoundException {
        return stockDAOImpl.collectProductBrandNames();
    }

    @Override
    public ArrayList<String> collectAvailableItemSubCategories() throws SQLException, ClassNotFoundException {
        return stockDAOImpl.collectAvailableItemSubCategories();
    }

    @Override
    public ArrayList<String> collectAvailableProductCodes() throws SQLException, ClassNotFoundException {
        return stockDAOImpl.collectAvailableProductCodes();
    }

    @Override
    public ArrayList<String> chooseDescription() throws SQLException, ClassNotFoundException {
        return stockDAOImpl.collectProductNames();
    }

    @Override
    public StockDTO searchStockDetails(String code) throws SQLException, ClassNotFoundException {
        StockAtStore stockAtStore = stockDAOImpl.search(code);
        return new StockDTO(stockAtStore.getProductId(), stockAtStore.getItemDescription(), stockAtStore.getQtyOnHand(), stockAtStore.getMeasuredUnits(), stockAtStore.getUnitRate(), stockAtStore.getCategory(), stockAtStore.getSubCategory(), stockAtStore.getBrandName(), stockAtStore.getItemImage());
    }

    @Override
    public StockDTO searchDetailsWithDescription(String description) throws SQLException, ClassNotFoundException {
        StockAtStore stockAtStore = stockDAOImpl.searchDetails(description);
        return new StockDTO(stockAtStore.getProductId(), stockAtStore.getItemDescription(), stockAtStore.getQtyOnHand(), stockAtStore.getMeasuredUnits(), stockAtStore.getUnitRate(), stockAtStore.getCategory(), stockAtStore.getSubCategory(), stockAtStore.getBrandName(), stockAtStore.getItemImage());
    }

    @Override
    public ArrayList<OrderDetailDTO> getTopItemList() throws SQLException, ClassNotFoundException {
        ArrayList <OrderDetailDTO> orderDetailDTOS = new ArrayList<>();
        ArrayList<OrderDetail> topSellingItemOrder = orderDetailDAO.getTopSellingItemOrder();
        for (OrderDetail orderDetail: topSellingItemOrder){
            orderDetailDTOS.add(new OrderDetailDTO(orderDetail.getOrderId(),orderDetail.getProductID(),orderDetail.getDescription(),orderDetail.getQty(),orderDetail.getMeasuredUnits(),orderDetail.getUnitPrice(),orderDetail.getDailyIncome(),orderDetail.getCategory(),orderDetail.getSubCategory(),orderDetail.getBrandName()));
        }
        return orderDetailDTOS;
    }

    @Override
    public ArrayList<StockDTO> getNotAvailableItemList() throws SQLException, ClassNotFoundException {
        ArrayList <StockDTO> stockDetailDTOS = new ArrayList<>();
        ArrayList<StockAtStore> notAvailableList = stockDAOImpl.getNotAvailableList();
        for (StockAtStore stockAtStore: notAvailableList){
            stockDetailDTOS.add(new StockDTO(stockAtStore.getProductId(),stockAtStore.getItemDescription(),stockAtStore.getQtyOnHand(),stockAtStore.getMeasuredUnits(),stockAtStore.getUnitRate(),stockAtStore.getCategory(),stockAtStore.getSubCategory(),stockAtStore.getBrandName(),stockAtStore.getItemImage()));
        }
        return stockDetailDTOS;
    }

    @Override
    public void deleteStock(String id) throws SQLException, ClassNotFoundException {
        stockDAOImpl.delete(id);
    }

    @Override
    public ArrayList<String> collectUnAvailableProductCodes() throws SQLException, ClassNotFoundException {
        return stockDAOImpl.getUnAvailableIDList();
    }


}
