package lk.ijse.finalproject.bo.custom;

import lk.ijse.finalproject.dto.MrnDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MrnBO extends SuperBO {
    ArrayList<MrnDTO> getAllMrnDetails() throws SQLException, ClassNotFoundException;

    ArrayList<String> chooseMrnId() throws SQLException, ClassNotFoundException;

    String getNextMrnId() throws SQLException, ClassNotFoundException;

    boolean addMrn(MrnDTO newMrn) throws SQLException, ClassNotFoundException;

    MrnDTO searchMrn(String code)throws SQLException, ClassNotFoundException;

    boolean updateMrn(MrnDTO mrn)throws SQLException, ClassNotFoundException;


    boolean deleteMrn(String mrnId) throws SQLException, ClassNotFoundException;

    ArrayList<MrnDTO> getMrnDetails()throws SQLException, ClassNotFoundException;
}
