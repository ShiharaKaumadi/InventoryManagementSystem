package lk.ijse.finalproject.entity;

import lk.ijse.finalproject.dto.OrderDetailDTO;


import java.util.ArrayList;

public class PlaceOrder {
    private String customerId;
    private String orderId;
    private double totalAmount;
    private ArrayList<OrderDetail> orderDetails = new ArrayList<>();

    public PlaceOrder() {
    }

    public PlaceOrder(String customerId, String orderId, double totalAmount,ArrayList<OrderDetail> orderDetails) {
        this.customerId = customerId;
        this.orderId = orderId;
        this.setTotalAmount(totalAmount);
        this.orderDetails = orderDetails;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public ArrayList<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(ArrayList<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
