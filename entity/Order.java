package lk.ijse.finalproject.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Order {
    private String orderId;
    private LocalDate date;
    private LocalTime time;
    private double totalAmount;
    private String customerID;

    public Order() {
    }

    public Order(String orderId, LocalDate date, LocalTime time, double totalAmount, String customerID) {
        this.orderId = orderId;
        this.date = date;
        this.time = time;
        this.totalAmount = totalAmount;
        this.customerID = customerID;
    }



    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", totalAmount=" + totalAmount +
                ", customerID='" + customerID + '\'' +
                '}';
    }
}
