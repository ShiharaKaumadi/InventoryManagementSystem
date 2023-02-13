package lk.ijse.finalproject.bo.custom;

import javafx.event.ActionEvent;
import lk.ijse.finalproject.dto.MinDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MinBO extends SuperBO{
    ArrayList<MinDTO> getAllMinTableData() throws SQLException, ClassNotFoundException;

    String getNextMinId() throws SQLException, ClassNotFoundException;

    boolean addMin(MinDTO minDTO) throws SQLException, ClassNotFoundException;
    public void btnMinPrintOnAction(ActionEvent actionEvent);
}
