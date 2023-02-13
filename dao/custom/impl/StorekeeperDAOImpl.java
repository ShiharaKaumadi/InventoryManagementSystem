package lk.ijse.finalproject.dao.custom.impl;

import lk.ijse.finalproject.dao.custom.StorekeeperDAO;
import lk.ijse.finalproject.dao.util.CrudUtil;
import lk.ijse.finalproject.dto.StoreKeeperDTO;
import lk.ijse.finalproject.entity.Storekeeper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StorekeeperDAOImpl implements StorekeeperDAO {
    @Override
    public boolean add(Storekeeper storeKeeperDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO Storekeeper VALUES (?,?)",storeKeeperDTO.getStoreKeeperId(),storeKeeperDTO.getEmpID());
    }

    @Override
    public boolean delete(String storeKeeperId) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE Storekeeper WHERE storeKeeperId=?",storeKeeperId);

    }

    @Override
    public boolean update(Storekeeper storeKeeperDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Storekeeper SET empID=? WHERE storeKeeperId=?",storeKeeperDTO.getEmpID(),storeKeeperDTO.getStoreKeeperId());
    }

    @Override
    public Storekeeper search(String storeKeeperId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Storekeeper WHERE storeKeeperId=?",storeKeeperId);
        while (resultSet.next()) {
            return new Storekeeper(resultSet.getString(1),resultSet.getString(2));
        }
        return null;
    }

    @Override
    public ArrayList<Storekeeper> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Storekeeper");
        ArrayList <Storekeeper> details = new ArrayList<>();
        while (resultSet.next()) {
            Storekeeper storeKeeperDTO = new Storekeeper(resultSet.getString(1),resultSet.getString(2));
            details.add(storeKeeperDTO);
        }
        return details;
    }
}
