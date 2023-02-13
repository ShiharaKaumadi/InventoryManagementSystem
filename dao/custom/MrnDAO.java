package lk.ijse.finalproject.dao.custom;

import lk.ijse.finalproject.dao.CrudDAO;
import lk.ijse.finalproject.entity.Mrn;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MrnDAO extends CrudDAO<Mrn, String> {
    public  String getNextMrnId() throws SQLException, ClassNotFoundException;
    public ArrayList<String> insert() throws SQLException, ClassNotFoundException;
    public ArrayList<Mrn> getAllMrnDetails() throws SQLException, ClassNotFoundException;


    ArrayList<Mrn> getMrnDetails() throws SQLException, ClassNotFoundException;
}
