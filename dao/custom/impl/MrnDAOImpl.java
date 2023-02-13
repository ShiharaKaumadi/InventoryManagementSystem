package lk.ijse.finalproject.dao.custom.impl;

import lk.ijse.finalproject.dao.custom.MrnDAO;
import lk.ijse.finalproject.dao.util.CrudUtil;
import lk.ijse.finalproject.entity.Mrn;
import lk.ijse.finalproject.entity.Storekeeper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class MrnDAOImpl implements MrnDAO {
    public  boolean add(Mrn mrn) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Mrn VALUES (?,?,?,?,?,?,?,?,?,?,?)",
                mrn.getMrnId(),
                mrn.getProductID(),
                mrn.getProductName(),
                mrn.getMeasuredUnits(),
                mrn.getDate(),
                mrn.getRequiredDate(),
                mrn.getStorekeeperID(),
                mrn.getRequestQty(),
                mrn.getCategory(),
                mrn.getSubCategory(),
                mrn.getBrandName());

    }

    @Override
    public boolean delete(String mrnId) throws SQLException, ClassNotFoundException {
        try {
            return CrudUtil.execute("DELETE FROM Mrn WHERE mrnId=?",mrnId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Mrn mrnDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Mrn SET productID=?,productName=?,measuredUnits=?,requiredDate=?,requestQty=?,Category=?, subCategory=?, brandName=? WHERE mrnId=?",
                mrnDTO.getProductID(),mrnDTO.getProductName(),mrnDTO.getMeasuredUnits(),mrnDTO.getRequiredDate(),
                mrnDTO.getRequestQty(),mrnDTO.getCategory(),mrnDTO.getSubCategory(),mrnDTO.getBrandName(),mrnDTO.getMrnId());
    }

    @Override
    public Mrn search(String mrnId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Mrn WHERE mrnId=?",mrnId);
        if (resultSet.next()){
            return new Mrn(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getObject(5,LocalDate.class),
                    resultSet.getObject(6,LocalDate.class),
                    resultSet.getString(7),
                    resultSet.getDouble(8),
                    resultSet.getString(9),
                    resultSet.getString(10),
                    resultSet.getString(11));
        }
        return null;
    }

    @Override
    public ArrayList<Mrn> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Mrn");
        ArrayList<Mrn> mrnList = new ArrayList<>();

            while (resultSet.next()) {
                mrnList.add(new Mrn(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getObject(5,LocalDate.class),
                        resultSet.getObject(6,LocalDate.class),
                        resultSet.getString(7),
                        resultSet.getDouble(8),
                        resultSet.getString(9),
                        resultSet.getString(10),
                        resultSet.getString(11)));
            }
            return mrnList;
        }


    public  String getNextMrnId() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT mrnId FROM Mrn ORDER BY mrnId DESC LIMIT 1");

        if(result.next()) {
            return generateNextMrnId(result.getString(1));
        }
        return generateNextMrnId(null);
    }

    private  String generateNextMrnId(String currentMrnId) {
        if(currentMrnId != null) {

            String[] ids = currentMrnId.split("-MRN-");
            int id = Integer.parseInt(ids[1]);
            id += 1;

            return String.valueOf(LocalDate.now()) + "-MRN-"+id;
        }
        return String.valueOf(LocalDate.now()) + "-MRN-"+1;
    }

    public  ArrayList<String> insert() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT mrnId FROM Mrn");

        ArrayList<String> idList = new ArrayList<>();

        while (result.next()) {
            idList.add(result.getString(1));
        }
        return idList;

    }

    public ArrayList<Mrn> getAllMrnDetails() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT mrnId,productId, productName,measuredUnits, requestQty,requiredDate, Category,subCategory, brandName FROM Mrn");

        ArrayList<Mrn> mrnList = new ArrayList<>();

        while (result.next()) {
            mrnList.add(new Mrn(result.getString("mrnId"),result.getString("productId"),result.getString("productName"),result.getString("measuredUnits"),result.getObject("requiredDate",LocalDate.class),result.getDouble("requestQty"),result.getString("category"),result.getString("subCategory"),result.getString("brandName")));
        }
        return mrnList;
    }

    @Override
    public ArrayList<Mrn> getMrnDetails() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Mrn");
        ArrayList<Mrn> mrnList = new ArrayList<>();

        while (resultSet.next()) {
            mrnList.add(new Mrn(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getObject(5,LocalDate.class),
                    resultSet.getObject(6,LocalDate.class),
                    resultSet.getString(7),
                    resultSet.getDouble(8),
                    resultSet.getString(9),
                    resultSet.getString(10),
                    resultSet.getString(11)));
        }
        return mrnList;
    }


}
