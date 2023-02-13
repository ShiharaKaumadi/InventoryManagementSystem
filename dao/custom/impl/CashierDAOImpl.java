package lk.ijse.finalproject.dao.custom.impl;

import lk.ijse.finalproject.dao.custom.CashierDAO;
import lk.ijse.finalproject.dao.util.CrudUtil;
import lk.ijse.finalproject.entity.Cashier;
import lk.ijse.finalproject.entity.Storekeeper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CashierDAOImpl implements CashierDAO {
    @Override
    public boolean add(Cashier cashierDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Cashier VALUES (?,?)",cashierDTO.getCashierId(),cashierDTO.getEmpID());
    }

    @Override
    public boolean delete(String cashierId) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE Cashier WHERE cashierId=?",cashierId);

    }

    @Override
    public boolean update(Cashier cashierDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Cashier SET empID =? WHERE cashierId=?",cashierDTO.getEmpID(),cashierDTO.getCashierId());
    }

    @Override
    public Cashier search(String cashierId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Cashier WHERE cashierId=?",cashierId);
        while (resultSet.next()) {
            return new Cashier(resultSet.getString(1),resultSet.getString(2));
        }
        return null;
    }

    @Override
    public ArrayList<Cashier> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Cashier ");
        ArrayList <Cashier> details = new ArrayList<>();
        while (resultSet.next()) {
            Cashier cashierDTO = new Cashier(resultSet.getString(1),resultSet.getString(2));
            details.add(cashierDTO);
        }
        return details;
    }
}
