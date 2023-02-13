package lk.ijse.finalproject.dao.custom.impl;

import lk.ijse.finalproject.dao.custom.MinDAO;
import lk.ijse.finalproject.dao.util.CrudUtil;
import lk.ijse.finalproject.entity.Min;
import lk.ijse.finalproject.entity.Storekeeper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class MinDAOImpl implements MinDAO {
    @Override
    public boolean add(Min minDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Min VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)",minDTO.getMinId(),minDTO.getProductID(),minDTO.getProductName(),minDTO.getCategory(),minDTO.getSubCategory(),minDTO.getBrandName(),minDTO.getMeasuredUnits(),minDTO.getUnitRate(),minDTO.getDate(),minDTO.getStorekeeperID(),minDTO.getQtyIssued(),minDTO.getPurpose(),minDTO.getRequestPerson());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Min minDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Min search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Min> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM `Min`");
        ArrayList<Min> minList = new ArrayList<>();

        while (resultSet.next()) {
            minList.add(new Min(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getDouble(8),
                    resultSet.getObject(9,LocalDate.class),
                    resultSet.getString(10),
                    resultSet.getDouble(11),
                    resultSet.getString(12),
                    resultSet.getString(13)));
        }
        return minList;
    }

    @Override
    public String getNextMinId() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT minId FROM Min ORDER BY minId DESC LIMIT 1");

        if(result.next()) {
            return generateNextMinId(result.getString(1));
        }
        return generateNextMinId(null);
    }

    private  String generateNextMinId(String currentMinId) {
        if(currentMinId != null) {

            String[] ids = currentMinId.split("-MIN-");
            System.out.println(ids[0]);
            System.out.println(ids[1]);
            int id = Integer.parseInt(ids[1]);
            id += 1;

            return String.valueOf(LocalDate.now()) + "-MIN-"+id;
        }
        return String.valueOf(LocalDate.now()) + "-MIN-1";
    }

}
