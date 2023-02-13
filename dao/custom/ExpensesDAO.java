package lk.ijse.finalproject.dao.custom;

import lk.ijse.finalproject.dao.CrudDAO;
import lk.ijse.finalproject.entity.Expenses;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ExpensesDAO extends CrudDAO<Expenses, String> {

    public  String getNextExpenseId() throws SQLException, ClassNotFoundException;
    public ArrayList<Expenses> getAllExpenses() throws SQLException, ClassNotFoundException;
    public Expenses search(String id) throws SQLException, ClassNotFoundException;
    public  boolean update(Expenses expenses) throws SQLException, ClassNotFoundException;
    public  double collectTotalExpenses() throws SQLException, ClassNotFoundException;
}
