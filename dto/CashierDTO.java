package lk.ijse.finalproject.dto;

public class CashierDTO {
    private String cashierId;
    private String empID;

    public CashierDTO() {

    }

    public CashierDTO(String cashierId, String empID) {
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
