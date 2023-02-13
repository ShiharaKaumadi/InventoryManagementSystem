package lk.ijse.finalproject.bo.custom.impl;

import javafx.event.ActionEvent;
import lk.ijse.finalproject.bo.custom.ExpensesBO;
import lk.ijse.finalproject.dao.DAOFactory;
import lk.ijse.finalproject.dao.DAOTypes;
import lk.ijse.finalproject.dao.custom.ExpensesDAO;
import lk.ijse.finalproject.db.DBConnection;
import lk.ijse.finalproject.dto.EmployeeDTO;
import lk.ijse.finalproject.dto.ExpensesDTO;
import lk.ijse.finalproject.entity.Expenses;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ExpensesBoImpl implements ExpensesBO {
    ExpensesDAO expensesDAO = (ExpensesDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.EXPENSES);
    @Override
    public ArrayList<ExpensesDTO> getAllExpenses() throws SQLException, ClassNotFoundException {
        ArrayList < ExpensesDTO> arrayList = new ArrayList<>();
        ArrayList<Expenses> all = expensesDAO.getAll();
        for (Expenses expenses:all){
            arrayList.add(new ExpensesDTO(expenses.getExpId(),expenses.getDescription(),expenses.getCashierID(),expenses.getDate(),expenses.getAmount()));
        }
        return arrayList;
    }

    @Override
    public String getNextExpenseId() throws SQLException, ClassNotFoundException {
        return expensesDAO.getNextExpenseId();
    }

    @Override
    public boolean addExpenseDetails(ExpensesDTO expenses) throws SQLException, ClassNotFoundException {
        return expensesDAO.add(new Expenses(expenses.getExpId(),expenses.getDescription(),expenses.getCashierId(),expenses.getDate(),expenses.getAmount()));
    }

    @Override
    public boolean updateExpenseDetail(ExpensesDTO expenses) throws SQLException, ClassNotFoundException {
        return expensesDAO.update(new Expenses(expenses.getExpId(),expenses.getDescription(),expenses.getCashierId(),expenses.getDate(),expenses.getAmount()));
    }

    @Override
    public void btnGenerateExpenseReportOnAction(ActionEvent actionEvent) {
        HashMap<String, Object> hashMap = new HashMap<>();
//        hashMap.put("expId",lblExpId.getText());
//        hashMap.put("description",txtDescription.getText());
//        hashMap.put("date",dtDate.getValue());
//        hashMap.put("amount",txtAmount.getText());
        InputStream inputStream = this.getClass().getResourceAsStream("/lk/ijse/finalproject/report/Expenses.jrxml");
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());
            JasperPrintManager.printReport(jasperPrint, false);
            //JasperPrintManager.printReport(jasperPrint,true); //print hardcopy
            JasperViewer.viewReport(jasperPrint);

        } catch (JRException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ExpensesDTO searchExpense(String id) throws SQLException, ClassNotFoundException {
        Expenses expenses = expensesDAO.search(id);
        return new ExpensesDTO(expenses.getExpId(),expenses.getDescription(),expenses.getCashierID(),expenses.getDate(),expenses.getAmount());
    }

    @Override
    public double collectTotalExpenses() throws SQLException, ClassNotFoundException {
        return expensesDAO.collectTotalExpenses();
    }

    @Override
    public boolean deleteExpense(String id) throws SQLException, ClassNotFoundException {
        return expensesDAO.delete(id);
    }
}
