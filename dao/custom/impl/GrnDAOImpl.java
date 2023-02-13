package lk.ijse.finalproject.dao.custom.impl;

import lk.ijse.finalproject.dao.custom.GrnDAO;
import lk.ijse.finalproject.dao.util.CrudUtil;
import lk.ijse.finalproject.entity.Grn;
import lk.ijse.finalproject.entity.Storekeeper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class GrnDAOImpl implements GrnDAO {
    public  boolean add(Grn grn) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Grn VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                grn.getGrnId(),
                grn.getProductID(),
                grn.getProductName(),
                grn.getCategory(),
                grn.getSubCategory(),
                grn.getBrandName(),
                grn.getMeasuredUnits(),
                grn.getUnitRate(),
                grn.getDate(),
                grn.getStorekeeperID(),
                grn.getQtyReceived(),
                grn.getQtyAccepted(),
                grn.getStockReceivedDate(),
                grn.getReasonForRejection());


    }

    @Override
    public boolean delete(String grnId) throws SQLException, ClassNotFoundException {
        try {
            return CrudUtil.execute("DELETE Grn WHERE grnId=?",grnId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Grn grnDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Grn SET productID=?,productName=?, category=?,subCategory=?,brandName=?,measuredUnits=?,unitRate=?,date=?,storekeeperId=?,qtyReceived=?,qtyAccepted=?,stockReceivedDate=?,reasonForRejection=? WHERE grnId=?",
                grnDTO.getProductID(),grnDTO.getProductName(),grnDTO.getCategory(),
                grnDTO.getSubCategory(),grnDTO.getBrandName(),grnDTO.getMeasuredUnits(),grnDTO.getUnitRate(),
                grnDTO.getDate(),grnDTO.getStorekeeperID(),grnDTO.getQtyReceived(),grnDTO.getQtyAccepted(),
                grnDTO.getStockReceivedDate(),grnDTO.getReasonForRejection());
    }

    @Override
    public Grn search(String grnId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Grn WHERE grnId=?",grnId);
        if (resultSet.next()){
            return new Grn(
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
                    resultSet.getDouble(12),
                    resultSet.getObject(13,LocalDate.class),
                    resultSet.getString(14));
        }
        return null;
    }

    @Override
    public ArrayList<Grn> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Grn");
        ArrayList<Grn> grnList = new ArrayList<>();

        while (resultSet.next()) {
            grnList.add(new Grn( resultSet.getString(1),
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
                    resultSet.getDouble(12),
                    resultSet.getObject(13,LocalDate.class),
                    resultSet.getString(14)));
        }
        return grnList;
    }

    public  String getNextGrnId() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT grnId FROM Grn ORDER BY grnId DESC LIMIT 1");

        if(result.next()) {
            return generateNextGrnId(result.getString(1));
        }
        return generateNextGrnId(null);
    }

    private  String generateNextGrnId(String currentGrnId) {
        if(currentGrnId != null) {

            String[] ids = currentGrnId.split("-GRN-");
            int id = Integer.parseInt(ids[1]);
            id += 1;

            return String.valueOf(LocalDate.now()) + "-GRN-"+id;
        }
        return String.valueOf(LocalDate.now()) + "-GRN-"+1;
    }

}
