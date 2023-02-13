package lk.ijse.finalproject.dao.custom.impl;

import lk.ijse.finalproject.dao.custom.StockDAO;
import lk.ijse.finalproject.dao.util.CrudUtil;
import lk.ijse.finalproject.entity.OrderDetail;
import lk.ijse.finalproject.entity.StockAtStore;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StockDAOImpl implements StockDAO {
    public  boolean add(StockAtStore stockAtStore) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO StockAtStore VALUES(?,?,?,?,?,?,?,?,?)",
                stockAtStore.getProductId(),
                stockAtStore.getItemDescription(),
                stockAtStore.getQtyOnHand(),
                stockAtStore.getMeasuredUnits(),
                stockAtStore.getUnitRate(),
                stockAtStore.getCategory(),
                stockAtStore.getSubCategory(),
                stockAtStore.getBrandName(),
                stockAtStore.getItemImage());
    }

    @Override
    public boolean delete(String productId) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("Delete From StockAtStore where productId=?",productId);
    }

    @Override
    public boolean update(StockAtStore stockDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE StockAtStore SET itemDescription=?, qtyOnHand=?,measuredUnits=?,unitRate=?, category=?, subCategory=?, brandName=? WHERE productId=?",
                stockDTO.getItemDescription(),stockDTO.getQtyOnHand(),stockDTO.getMeasuredUnits(),stockDTO.getUnitRate(),stockDTO.getCategory(),stockDTO.getSubCategory(),stockDTO.getBrandName());
    }

    public  ArrayList<String> collectAvailableProductCodes() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT productId FROM StockAtStore WHERE qtyOnHand>100");

        ArrayList<String> idList = new ArrayList<>();

        while (result.next()) {
            idList.add(result.getString(1));
        }
        return idList;

    }

    public ArrayList<String> collectAvailableItemCategories() throws SQLException, ClassNotFoundException{
        ResultSet result = CrudUtil.execute("SELECT DISTINCT(Category) FROM StockAtStore WHERE qtyOnHand>100");

        ArrayList<String> categoryList = new ArrayList<>();

        while (result.next()) {
            categoryList.add(result.getString(1));
        }
        return categoryList;
    }

    public ArrayList<String> collectAvailableItemSubCategories() throws SQLException, ClassNotFoundException{
        ResultSet result = CrudUtil.execute("SELECT DISTINCT(subCategory) FROM StockAtStore WHERE qtyOnHand>100");

        ArrayList<String> subCategoryList = new ArrayList<>();

        while (result.next()) {
            subCategoryList.add(result.getString(1));
        }
        return subCategoryList;
    }

    @Override
    public ArrayList<String> collectProductBrandNames() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT DISTINCT(brandName) FROM StockAtStore WHERE qtyOnHand>100");

        ArrayList<String> brandNameList = new ArrayList<>();

        while (result.next()) {
            brandNameList.add(result.getString(1));
        }
        return brandNameList;
    }

    @Override
    public ArrayList<String> collectProductNames() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT DISTINCT(itemDescription) FROM StockAtStore WHERE qtyOnHand>100");

        ArrayList<String> descriptionList = new ArrayList<>();

        while (result.next()) {
            descriptionList.add(result.getString(1));
        }
        return descriptionList;
    }



    public  ArrayList<String> insertDescription() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT itemDescription FROM StockAtStore");

        ArrayList<String> productList = new ArrayList<>();

        while (result.next()) {
            productList.add(result.getString(1));
        }
        return productList;
    }

    public StockAtStore search(String code) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT  * FROM StockAtStore WHERE productId = ?", code);

        if (result.next()) {
            StockAtStore stockAtStore = new StockAtStore(
                    result.getString(1),
                    result.getString(2),
                    result.getDouble(3),
                    result.getString(4),
                    result.getDouble(5),
                    result.getString(6),
                    result.getString(7),
                    result.getString(8),
                    result.getBlob(9)
            );
            return stockAtStore;

        }
        return null;
    }

    public StockAtStore searchItem(String code) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT  * FROM StockAtStore WHERE productId = ?", code);

        if (result.next()) {
            StockAtStore stockAtStore = new StockAtStore(
                    result.getString(1),
                    result.getString(2),
                    result.getDouble(3),
                    result.getString(4),
                    result.getDouble(5),
                    result.getString(6),
                    result.getString(7),
                    result.getString(8),
                    result.getBlob(9)


            );
            return stockAtStore;

        }
        return null;
    }

    public StockAtStore searchDetails(String description) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT  * FROM StockAtStore WHERE itemDescription = ?", description);

        if (result.next()) {
            StockAtStore stockAtStore = new StockAtStore(
                    result.getString(1),
                    result.getString(2),
                    result.getDouble(3),
                    result.getString(4),
                    result.getDouble(5),
                    result.getString(6),
                    result.getString(7),
                    result.getString(8),
                    result.getBlob(9)

            );
            return stockAtStore;

        }
        return null;
    }


    public  boolean updateQty(ArrayList<OrderDetail> orderDetails) throws SQLException, ClassNotFoundException {
        for (OrderDetail orderDetail : orderDetails) {
            if (!updateQty(new StockAtStore(orderDetail.getProductID(),orderDetail.getDescription(),orderDetail.getQty(),orderDetail.getMeasuredUnits(),orderDetail.getUnitPrice(),orderDetail.getCategory(),orderDetail.getSubCategory(),orderDetail.getBrandName())))  {
                System.out.println("updated");
                return false;
            }
        }
        return true;
    }

    private  boolean updateQty(StockAtStore stockAtStore) throws SQLException, ClassNotFoundException {
        System.out.println("2");
        return CrudUtil.execute("UPDATE StockAtStore SET qtyOnHand = qtyOnHand - ? WHERE productId = ?", stockAtStore.getQtyOnHand(), stockAtStore.getProductId());
    }

    public ArrayList<StockAtStore> getAll() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM StockAtStore");

        ArrayList<StockAtStore> productList = new ArrayList<>();

        while (result.next()) {
            productList.add(new StockAtStore(result.getString("productId"),result.getString("itemDescription"),result.getDouble("qtyOnHand"),result.getString("measuredUnits"),result.getDouble("unitRate"),result.getString("category"),result.getString("subCategory"),result.getString("brandName"),result.getBlob("itemImage")));
        }
        return productList;
    }

    public ArrayList<StockAtStore> getAllStockValue() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT itemDescription,qtyOnHand, unitRate,SUM(unitRate*qtyOnHand) FROM StockAtStore");

        ArrayList<StockAtStore> productList = new ArrayList<>();

        while (result.next()) {
            productList.add(new StockAtStore(result.getString("itemDescription"),result.getDouble("qtyOnHand"),result.getDouble("unitRate")));
        }
        return productList;
    }

    public  double collectStockValue() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT SUM(qtyOnHand*unitRate) FROM StockAtStore");
        if (result.next()) {
            return result.getDouble(1);

        }
        return 0;
    }

    public ArrayList<StockAtStore> getNotAvailableList() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT itemDescription,qtyOnHand FROM StockAtStore WHERE qtyOnHand<=100");

        ArrayList<StockAtStore> productList = new ArrayList<>();

        while (result.next()) {
            productList.add(new StockAtStore(result.getString("itemDescription"),result.getDouble("qtyOnHand")));
        }
        return productList;
    }

    @Override
    public ArrayList<String> getUnAvailableIDList() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT productId FROM StockAtStore WHERE qtyOnHand<=100");
        ArrayList<String> details = new ArrayList<>();
        while (result.next()) {
            details.add(result.getString(1));
        }
      return details;
    }
}
