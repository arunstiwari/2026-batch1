package com.fil.model;

public class DeliveryRequest {
    private  Address address;
    private  Address restaurantAddress;
    private final String orderId;

    public DeliveryRequest(Address address, Address restaurantAddress, String orderId) {
        this.address = address;
        this.restaurantAddress = restaurantAddress;
        this.orderId = orderId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(Address restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public String getOrderId() {
        return orderId;
    }
}
