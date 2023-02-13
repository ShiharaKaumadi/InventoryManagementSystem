package lk.ijse.finalproject.bo.custom;

import javafx.event.ActionEvent;
import lk.ijse.finalproject.dto.ExpensesDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ExpensesBO extends SuperBO{
    ArrayList<ExpensesDTO> getAllExpenses() throws SQLException, ClassNotFoundException;

    String getNextExpenseId() throws SQLException, ClassNotFoundException;

    boolean addExpenseDetails(ExpensesDTO expenses) throws SQLException, ClassNotFoundException;

    boolean updateExpenseDetail(ExpensesDTO expenses) throws SQLException, ClassNotFoundException;

    void btnGenerateExpenseReportOnAction(ActionEvent actionEvent)throws SQLException, ClassNotFoundException;

    ExpensesDTO searchExpense(String id)throws SQLException, ClassNotFoundException;

    double collectTotalExpenses() throws SQLException, ClassNotFoundException;

    boolean deleteExpense(String id) throws SQLException, ClassNotFoundException;
}
