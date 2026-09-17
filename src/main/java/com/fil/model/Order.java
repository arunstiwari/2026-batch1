package com.fil.model;

import java.util.List;

public class Order {
    private String orderId;
    private double totalAmount;
    private List<OrderItem> orderItems;
    private String orderStatus;
    private String transactionStatus;

    public Order(String orderId, double totalAmount, List<OrderItem> orderItems, String orderStatus) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.orderItems = orderItems;
        this.orderStatus = orderStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus){
        this.orderStatus = orderStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }
}
