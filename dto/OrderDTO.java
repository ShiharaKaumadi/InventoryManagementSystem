package lk.ijse.finalproject.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class OrderDTO {
    private String orderId;
    private LocalDate date;
    private LocalTime time;
    private double totalAmount;
    private String customerId;

    public OrderDTO() {
    }

    public OrderDTO(String orderId, LocalDate date, LocalTime time, double totalAmount, String customerId) {
        this.orderId = orderId;
        this.date = date;
        this.time = time;
        this.totalAmount = totalAmount;
        this.customerId = customerId;
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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
