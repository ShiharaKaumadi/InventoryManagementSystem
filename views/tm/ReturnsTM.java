package lk.ijse.finalproject.views.tm;

import java.time.LocalDate;

public class ReturnsTM {
    private String returnId;
    private LocalDate returnDate;
    private String productId;
    private double qty;
    private String customerId;

    public ReturnsTM() {
    }

    public ReturnsTM(String returnId, LocalDate returnDate, String productId, double qty, String customerId) {
        this.returnId = returnId;
        this.returnDate = returnDate;
        this.productId = productId;
        this.qty = qty;
        this.customerId = customerId;
    }

    public ReturnsTM(String returnId, LocalDate returnDate, String productId, String customerId) {
        this.returnId = returnId;
        this.returnDate = returnDate;
        this.productId = productId;
        this.customerId = customerId;
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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }
}
