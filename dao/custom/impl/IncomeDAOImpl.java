package lk.ijse.finalproject.dao.custom.impl;

import lk.ijse.finalproject.dao.custom.IncomeDAO;
import lk.ijse.finalproject.dao.util.CrudUtil;
import lk.ijse.finalproject.entity.Income;
import lk.ijse.finalproject.entity.Storekeeper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IncomeDAOImpl implements IncomeDAO {
    @Override
    public boolean add(Income incomeDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Income VALUES(?,?,?,?,?)",incomeDTO.getIncomeId(),incomeDTO.getDailyIncome(),incomeDTO.getWeeklyIncome(),incomeDTO.getMonthlyIncome(),incomeDTO.getYearlyIncome());
    }

    @Override
    public boolean delete(String incomeId) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE Income WHERE incomeId=?",incomeId);
    }

    @Override
    public boolean update(Income incomeDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Income SET dailyIncome=?,weeklyIncome=?,monthlyIncome=?,yearlyIncome=? WHERE incomeId=?");
    }

    @Override
    public Income search(String incomeId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Income WHERE incomeId=?", incomeId);
        while (resultSet.next()) {
            return new Income(resultSet.getString(1),resultSet.getDouble(2),resultSet.getDouble(3),resultSet.getDouble(4),resultSet.getDouble(5));
        }
        return null;
    }

    @Override
    public ArrayList<Income> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Income");
        ArrayList <Income> details = new ArrayList<>();
        while (resultSet.next()) {
            Income incomeDTO = new Income(resultSet.getString(1),resultSet.getDouble(2),resultSet.getDouble(3),resultSet.getDouble(4),resultSet.getDouble(5));
            details.add(incomeDTO);
        }
        return details;
    }
}
