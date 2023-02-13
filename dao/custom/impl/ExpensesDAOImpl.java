package lk.ijse.finalproject.dao.custom.impl;

import lk.ijse.finalproject.dao.custom.ExpensesDAO;
import lk.ijse.finalproject.dao.util.CrudUtil;
import lk.ijse.finalproject.entity.Expenses;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ExpensesDAOImpl implements ExpensesDAO {
    public  boolean add(Expenses expenses) throws SQLException, ClassNotFoundException {
        String sql ="INSERT INTO Expenses VALUES (?,?,?,?,?)";
        return CrudUtil.execute(sql,expenses.getExpId(),expenses.getDescription(),expenses.getCashierID(),expenses.getDate(),expenses.getAmount());
    }

    @Override
    public boolean delete(String expId) throws SQLException, ClassNotFoundException {
        try {
            return CrudUtil.execute("DELETE FROM Expenses WHERE expId=?",expId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public  String getNextExpenseId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT expId FROM  Expenses ORDER BY expId DESC LIMIT 1";
        ResultSet resultSet = CrudUtil.execute(sql);
        if (resultSet.next()){
            return generateNextExpId(resultSet.getString(1));
        }
        return generateNextExpId(null);
    }

    private  String generateNextExpId(String currentExpId) {
        if (currentExpId !=null){
            String[] ids = currentExpId.split(("EXP-"));
            int id = Integer.parseInt(ids[1]);
            System.out.println(id);

            id += 1;


            return ("EXP-")+id;
        }
        return ("EXP-")+1;

    }

    public ArrayList<Expenses> getAllExpenses() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Expenses");
        ArrayList<Expenses> arrayList = new ArrayList<>();
        while (resultSet.next()){
            arrayList.add(new Expenses(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getObject(4, LocalDate.class ),resultSet.getDouble(5)));

        }
        return  arrayList;
    }

    public Expenses search(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Expenses WHERE expId=?",id);
        if (resultSet.next()){
            return new Expenses(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getObject(4,LocalDate.class),
                    resultSet.getDouble(5));
        }
        return null;

    }

    @Override
    public ArrayList<Expenses> getAll() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM Expenses");
        ArrayList<Expenses> expensesList = new ArrayList<>();

        while (result.next()) {
            expensesList.add(new Expenses(result.getString(1),result.getString(2),result.getString(3),result.getObject(4,LocalDate.class),result.getDouble(5)));
        }
        return expensesList;
    }

    public  boolean update(Expenses expenses) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Expenses SET description =?, cashierId =?, date=?, amount=? WHERE expId=?",expenses.getDescription(),expenses.getCashierID(),expenses.getDate(),expenses.getAmount(),expenses.getExpId());
    }

    public  double collectTotalExpenses() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT SUM(amount) FROM Expenses");

        if (result.next()) {
            return result.getDouble(1);

        }
        return 0;
    }
}
