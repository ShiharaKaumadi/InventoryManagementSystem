package lk.ijse.finalproject.dto;

public class CustomerDTO {
    private String customerId;
    private String customerName;
    private String contactNo;
    private String email;
    private String cashierID;

    public CustomerDTO() {
    }

    public CustomerDTO(String customerId, String customerName, String contactNo, String email, String cashierID) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.contactNo = contactNo;
        this.email = email;
        this.cashierID = cashierID;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCashierID() {
        return cashierID;
    }

    public void setCashierID(String cashierID) {
        this.cashierID = cashierID;
    }
}
