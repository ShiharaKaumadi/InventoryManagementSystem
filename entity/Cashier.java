package lk.ijse.finalproject.entity;

public class Cashier {
    private String cashierId;
    private String empID;

    public Cashier() {

    }

    public Cashier(String cashierId, String empID) {
        this.cashierId = cashierId;
        this.empID = empID;
    }

    public String getCashierId() {
        return cashierId;
    }

    public void setCashierId(String cashierId) {
        this.cashierId = cashierId;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }
}
