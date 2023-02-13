package lk.ijse.finalproject.dao.custom.impl;

import lk.ijse.finalproject.dao.custom.ReturnsDAO;
import lk.ijse.finalproject.dao.util.CrudUtil;
import lk.ijse.finalproject.entity.ReturnItems;
import lk.ijse.finalproject.entity.Storekeeper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ReturnsDAOImpl implements ReturnsDAO {
    @Override
    public boolean add(ReturnItems returnsDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO ReturnItems VALUES(?,?,?,?,?)",returnsDTO.getReturnId(),returnsDTO.getReturnDate(),returnsDTO.getProductID(),returnsDTO.getQty(),returnsDTO.getCustomerID());
    }

    @Override
    public boolean delete(String returnId) throws SQLException, ClassNotFoundException {
         return CrudUtil.execute("DELETE ReturnItems WHERE returnId=?",returnId);

    }

    @Override
    public boolean update(ReturnItems returnsDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE ReturnItems SET returnDate=?,productID=?,qty=?,customerID=? WHERE returnId=?",returnsDTO.getReturnDate(),returnsDTO.getProductID(),returnsDTO.getQty(),returnsDTO.getCustomerID(),returnsDTO.getReturnId());
    }

    @Override
    public ReturnItems search(String returnId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM ReturnItems WHERE returnId=?", returnId);
        while (resultSet.next()){
            return new ReturnItems(
                    resultSet.getString(1),
                    LocalDate.parse(resultSet.getString(2)),
                    resultSet.getString(3),
                    resultSet.getDouble(4),
                    resultSet.getString(5));


        }
        return null;
    }

    @Override
    public ArrayList<ReturnItems> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM ReturnItems");
        ArrayList <ReturnItems> details = new ArrayList<>();
        while (resultSet.next()){
            ReturnItems returnsDTO = new ReturnItems(resultSet.getString(1),LocalDate.parse(resultSet.getString(2)),resultSet.getString(3),resultSet.getDouble(4),resultSet.getString(5));
            details.add(returnsDTO);
        }
        return details;
    }

    @Override
    public String generateNextReturnId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT returnId FROM  ReturnItems ORDER BY returnId DESC LIMIT 1";
        ResultSet resultSet = CrudUtil.execute(sql);
        if (resultSet.next()){
            return generateNextExpId(resultSet.getString(1));
        }
        return generateNextExpId(null);
    }

    private  String generateNextExpId(String currentExpId) {
        if (currentExpId !=null){
            String[] ids = currentExpId.split(("-RTN-"));
            int id = Integer.parseInt(ids[1]);
            System.out.println(id);

            id += 1;


            return (LocalDate.now()+"-RTN-")+id;
        }
        return (LocalDate.now()+"-RTN-")+1;

    }
}
