package lk.ijse.finalproject.dao;

import lk.ijse.finalproject.entity.Storekeeper;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO <T, ID> extends SuperDAO{
    //keep most common methods
    //reduce boilerplate codes
    //act as a super interface to dao interface for lose coupling
    public boolean add(T t) throws SQLException, ClassNotFoundException;
    public boolean delete(ID id) throws SQLException, ClassNotFoundException;
    public boolean update(T t) throws SQLException, ClassNotFoundException;
    public T search(ID id) throws SQLException, ClassNotFoundException;
    public ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
}
