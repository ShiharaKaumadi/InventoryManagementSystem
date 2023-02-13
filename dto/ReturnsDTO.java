package lk.ijse.finalproject.dto;

import java.time.LocalDate;

public class ReturnsDTO {
    private String returnId;
    private LocalDate returnDate;
    private String productID;
    private double qty;
    private String customerID;

    public ReturnsDTO() {
    }

    public ReturnsDTO(String returnId, LocalDate returnDate, String productID, double qty, String customerID) {
        this.returnId = returnId;
        this.returnDate = returnDate;
        this.productID = productID;
        this.qty = qty;
        this.customerID = customerID;
    }

    public ReturnsDTO(String returnId, LocalDate returnDate, String productID, String customerID) {
        this.returnId = returnId;
        this.returnDate = returnDate;
        this.productID = productID;
        this.customerID = customerID;
    }

    public String getReturnId() {
        return returnId;
    }

    public void setReturnId(String returnId) {
        this.returnId = returnId;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "ReturnItems{" +
                "returnId='" + returnId + '\'' +
                ", returnDate=" + returnDate +
                ", productID='" + productID + '\'' +
                ", customerID='" + customerID + '\'' +
                '}';
    }
}
