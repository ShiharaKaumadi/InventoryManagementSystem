package lk.ijse.finalproject.bo.custom;

import lk.ijse.finalproject.bo.custom.impl.*;

public class BOFactory {
    public static BOFactory boFactory;
    private BOFactory(){

    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)?boFactory= new BOFactory():boFactory;

    }

    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case CUSTOMER :
                return new CustomerBOImpl();
            case STOCK:
                return new StockBoImpl();
            case GRN:
                return new GrnBoImpl();
            case MRN:
                return new MrnBoImpl();
            case MIN:
                return new MinBoImpl();
            case ORDER:
                return new OrderBoImpl();
            case ORDER_DETAIL:
                return new OrderDetailBoImpl();
            case EMPLOYEE:
                return new EmployeeBoImpl();
            case EXPENSES:
                return new ExpensesBoImpl();
            case CASHIER:
                return new CashierBoImpl();
            case MANAGER:
                return new ManagerBoImpl();
            case SUPPLIER:
                return new SupplierBoImpl();
            case STOREKEEPER:
                return new StorekeeperBoImpl();
            case QUOTATION:
                return new QuotationBOImpl();
            case PURCHASE_ORDER:
                return new PurchaseOrderBOImpl();
            case RETURNS:
                return new ReturnsBOImpl();
            default:
                return null;
        }
    }
}
