package lk.ijse.finalproject.dao;

import lk.ijse.finalproject.dao.custom.impl.*;

public class DAOFactory {
    public static DAOFactory daoFactory;
    private DAOFactory(){

    }
    public static DAOFactory getDaoFactory(){
        return (daoFactory==null)?daoFactory= new DAOFactory():daoFactory;
    }

    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case CUSTOMER :
                return new CustomerDAOImpl();
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            case EXPENSES:
                return new ExpensesDAOImpl();
            case GRN:
                return new GrnDAOImpl();
            case MRN:
                return new MrnDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            case ORDER_DETAIL:
                return new OrderDetailDAOImpl();
            case QUERY:
                return new QueryDAOImpl();
            case STOCK:
                return new StockDAOImpl();
            case SUPPLIER:
                return  new SupplierDAOImpl();
            case MIN:
                return new MinDAOImpl();
            case QUOTATION:
                return new QuotationDAOImpl();
            case PURCHASE_ORDER:
                return new PurchaseOrderDAOImpl();
            case RETURNITEMS:
                return new ReturnsDAOImpl();
            default:
                return null;


        }
    }
}
