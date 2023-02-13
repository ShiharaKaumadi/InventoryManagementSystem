package lk.ijse.finalproject.bo.custom.impl;

import lk.ijse.finalproject.bo.custom.MrnBO;
import lk.ijse.finalproject.dao.DAOFactory;
import lk.ijse.finalproject.dao.DAOTypes;
import lk.ijse.finalproject.dao.custom.MrnDAO;
import lk.ijse.finalproject.db.DBConnection;
import lk.ijse.finalproject.dto.MrnDTO;
import lk.ijse.finalproject.entity.Mrn;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class MrnBoImpl implements MrnBO{
    MrnDAO mrnDAOImpl = (MrnDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.MRN);
    @Override
    public ArrayList<MrnDTO> getAllMrnDetails() throws SQLException, ClassNotFoundException {
        ArrayList <MrnDTO> mrnDTOS = new ArrayList<>();
        ArrayList<Mrn> allMrnDetails = mrnDAOImpl.getAllMrnDetails();
        for (Mrn mrn:allMrnDetails){
            mrnDTOS.add(new MrnDTO(mrn.getMrnId(),mrn.getProductID(),mrn.getProductName(),mrn.getMeasuredUnits(),mrn.getRequiredDate(),mrn.getRequestQty(),mrn.getCategory(),mrn.getSubCategory(),mrn.getBrandName()));
        }
        return mrnDTOS;
    }

    @Override
    public ArrayList<String> chooseMrnId() throws SQLException, ClassNotFoundException {
        return mrnDAOImpl.insert();
    }

    @Override
    public String getNextMrnId() throws SQLException, ClassNotFoundException {
        return mrnDAOImpl.getNextMrnId();
    }

    @Override
    public boolean addMrn(MrnDTO mrn) throws SQLException, ClassNotFoundException {
        return mrnDAOImpl.add(new Mrn(mrn.getMrnId(),mrn.getStockCode(),mrn.getStockDescription(),mrn.getMeasuredUnits(),mrn.getRequiredDate(),mrn.getRequestedQty(),mrn.getCategory(),mrn.getSubCategory(),mrn.getBrandName()));
    }

    @Override
    public MrnDTO searchMrn(String code) throws SQLException, ClassNotFoundException {
        Mrn mrn = mrnDAOImpl.search(code);
        return new MrnDTO(mrn.getMrnId(),mrn.getProductID(),mrn.getProductName(),mrn.getMeasuredUnits(),mrn.getRequiredDate(),mrn.getRequestQty(),mrn.getCategory(),mrn.getSubCategory(),mrn.getBrandName());
    }

    @Override
    public boolean updateMrn(MrnDTO mrn) throws SQLException, ClassNotFoundException {
        return mrnDAOImpl.update(new Mrn(mrn.getMrnId(),mrn.getStockCode(),mrn.getStockDescription(),mrn.getMeasuredUnits(),mrn.getRequiredDate(),mrn.getRequestedQty(),mrn.getCategory(),mrn.getSubCategory(),mrn.getBrandName()));
    }

    @Override
    public boolean deleteMrn(String mrnId) throws SQLException, ClassNotFoundException {
        return mrnDAOImpl.delete(mrnId);
    }

    @Override
    public ArrayList<MrnDTO> getMrnDetails() throws SQLException, ClassNotFoundException {
        ArrayList <MrnDTO> mrnDTOS = new ArrayList<>();
        ArrayList<Mrn> mrnDetails = mrnDAOImpl.getMrnDetails();
        for (Mrn mrn :mrnDetails){
            mrnDTOS.add(new MrnDTO(mrn.getMrnId(),mrn.getProductID(),mrn.getProductName(),mrn.getMeasuredUnits(),mrn.getRequiredDate(),mrn.getRequestQty(),mrn.getCategory(),mrn.getSubCategory(),mrn.getBrandName()));
        }
        return mrnDTOS;
    }


}
