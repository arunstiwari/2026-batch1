package com.fil.service;

import com.fil.model.*;
import com.fil.repository.IOrderRepository;

public class OrderService implements IOrderService {
    private IValidationCartService validationCartService;
    private IPaymentService paymentService;
    private IOrderRepository orderRepository;
    private IRestaurantService restaurantService;
    private IDeliveryService deliveryService;

    public OrderService(IValidationCartService validationCartService, IPaymentService paymentService,
                        IOrderRepository orderRepository, IRestaurantService restaurantService, IDeliveryService deliveryService) {
        this.validationCartService = validationCartService;
        this.paymentService = paymentService;
        this.orderRepository = orderRepository;
        this.restaurantService = restaurantService;
        this.deliveryService = deliveryService;
    }

    public OrderResult placeOrder(Cart cart, Customer customerInfo) {
        System.out.println("Going to Place Order");
        /**
         * 1. Validate Cart
         * 2. Payment Initiation
         * 3. Notification to Restaturant Service
         * 4. Notification to Delivery Service
         * 5. Send a Response to Client/User (Order Placed, ETA, with Live Map)
         */
         String result = validationCartService.validateCart(cart);
         String orderStatus ="PENDING";
        Order orderInfo = new Order("ord-23232",cart.getTotalAmount(),cart.getOrderItems(), orderStatus);
        Order createdOrder = orderRepository.save(orderInfo);
        PaymentResult paymentResult = paymentService.initatePaymentForCustomer(customerInfo, createdOrder);
        createdOrder.setOrderStatus("CREATED");
        createdOrder.setTransactionStatus("FULLY PAID");
        RestaurantResponse restaurantResponse = restaurantService.notifyNewOrder(createdOrder);
        DeliveryRequest deliveryRequest = new DeliveryRequest(customerInfo.getAddress(), restaurantResponse.getAddress(),
                createdOrder.getOrderId());
       DeliveryResponse deliveryResponse =  deliveryService.notifyOrderDispatch(deliveryRequest);
       String message ="success";
       String eta ="20 min";
       String liveAddressOfDeliveryPartner ="";
        OrderResult orderResult = new OrderResult(orderStatus, eta, liveAddressOfDeliveryPartner, message);
        return orderResult;
    }
}
