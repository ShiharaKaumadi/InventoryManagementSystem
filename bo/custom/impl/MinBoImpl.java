package lk.ijse.finalproject.bo.custom.impl;

import javafx.event.ActionEvent;
import lk.ijse.finalproject.bo.custom.MinBO;
import lk.ijse.finalproject.dao.DAOFactory;
import lk.ijse.finalproject.dao.DAOTypes;
import lk.ijse.finalproject.dao.custom.MinDAO;
import lk.ijse.finalproject.db.DBConnection;
import lk.ijse.finalproject.dto.MinDTO;
import lk.ijse.finalproject.entity.Min;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;

public class MinBoImpl implements MinBO {
    MinDAO minDAOImpl = (MinDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.MIN);
    @Override
    public ArrayList<MinDTO> getAllMinTableData() throws SQLException, ClassNotFoundException {
        ArrayList<MinDTO> arrayList = new ArrayList<>();
        ArrayList<Min> all = minDAOImpl.getAll();
        for(Min min :all){
           arrayList.add(new MinDTO(min.getMinId(),min.getProductID(),min.getProductName(),min.getCategory(),min.getSubCategory(),min.getBrandName(),min.getMeasuredUnits(),min.getUnitRate(),min.getDate(),min.getStorekeeperID(),min.getQtyIssued(),min.getPurpose(),min.getRequestPerson()));
        }
        return arrayList;
    }

    @Override
    public String getNextMinId() throws SQLException, ClassNotFoundException {
        return minDAOImpl.getNextMinId();
    }

    @Override
    public boolean addMin(MinDTO min) throws SQLException, ClassNotFoundException {
        return minDAOImpl.add(new Min(min.getMinId(),min.getStockCode(),min.getStockItemDescription(),min.getCategory(),min.getSubCategory(),min.getBrandName(),min.getMeasuredUnits(),min.getUnitRate(),min.getIssuedDate(),min.getStorekeeperId(),min.getQtyIssued(),min.getPurpose(),min.getRequestPersonId()));
    }

    @Override
    public void btnMinPrintOnAction(ActionEvent actionEvent) {
        InputStream inputStream = this.getClass().getResourceAsStream("/lk/ijse/finalproject/report/MinForm.jrxml");


        try {

            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null, DBConnection.getInstance().getConnection());
            // JasperPrintManager.printReport(jasperPrint,true);
            JasperViewer.viewReport(jasperPrint,false);

        } catch (JRException | SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}
