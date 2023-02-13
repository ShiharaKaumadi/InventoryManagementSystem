package lk.ijse.finalproject.dao.custom.impl;

import lk.ijse.finalproject.dao.custom.ManagerDAO;
import lk.ijse.finalproject.dao.util.CrudUtil;
import lk.ijse.finalproject.entity.Manager;
import lk.ijse.finalproject.entity.Storekeeper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManagerDAOImpl implements ManagerDAO {
    @Override
    public boolean add(Manager managerDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Manager VALUES(?,?)",managerDTO.getManagerId(),managerDTO.getEmpID());
    }

    @Override
    public boolean delete(String managerId) throws SQLException, ClassNotFoundException {
            return CrudUtil.execute("DELETE Manager WHERE managerId=?",managerId);

    }

    @Override
    public boolean update(Manager managerDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Manager SET empID=? WHERE managerID=?",managerDTO.getEmpID(),managerDTO.getManagerId());
    }

    @Override
    public Manager search(String managerId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Manager WHERE managerId=?", managerId);
        while (resultSet.next()) {
            return new Manager(resultSet.getString(1),resultSet.getString(2));
        }
        return null;
    }

    @Override
    public ArrayList<Manager> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Manager");
        ArrayList <Manager> details = new ArrayList<>();
        while (resultSet.next()) {
            Manager managerDTO = new Manager(resultSet.getString(1),resultSet.getString(2));
            details.add(managerDTO);
        }
        return details;
    }
}
