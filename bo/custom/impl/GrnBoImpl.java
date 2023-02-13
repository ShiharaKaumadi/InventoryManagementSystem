package lk.ijse.finalproject.bo.custom.impl;

import lk.ijse.finalproject.bo.custom.GrnBO;
import lk.ijse.finalproject.dao.DAOFactory;
import lk.ijse.finalproject.dao.DAOTypes;
import lk.ijse.finalproject.dao.custom.GrnDAO;
import lk.ijse.finalproject.dto.GrnDTO;
import lk.ijse.finalproject.entity.Grn;

import java.sql.SQLException;

public class GrnBoImpl implements GrnBO {
    GrnDAO grnDAOImpl = (GrnDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.GRN);
    @Override
    public String getNextGrnId() throws SQLException, ClassNotFoundException {
        return grnDAOImpl.getNextGrnId();
    }

    @Override
    public boolean addGrn(GrnDTO grn) throws SQLException, ClassNotFoundException {
        return grnDAOImpl.add(new Grn(grn.getGrnId(),grn.getStockCode(),grn.getStockItemDescription(),grn.getCategory(),grn.getSubCategory(),grn.getBrandName(),grn.getMeasuredUnits(),grn.getUnitRate(),grn.getGrnDate(),grn.getStoreKeeperId(),grn.getQtyReceived(),grn.getQtyAccepted(),grn.getStockReceivedDate(),grn.getReasonForRejection()));
    }
}
