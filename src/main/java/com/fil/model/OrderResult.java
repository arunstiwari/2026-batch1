package com.fil.model;

public class OrderResult {
    private final String orderStatus;
    private final String eta;
    private final String liveAddressOfDeliveryPartner;
    private String message;

    public OrderResult(String orderStatus, String eta, String liveAddressOfDeliveryPartner, String message) {
        this.orderStatus = orderStatus;
        this.eta = eta;
        this.liveAddressOfDeliveryPartner = liveAddressOfDeliveryPartner;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
