package com.fil;

import com.fil.model.Address;
import com.fil.model.Cart;
import com.fil.model.Customer;
import com.fil.model.OrderResult;
import com.fil.repository.IOrderRepository;
import com.fil.repository.IOrderRepositoryImpl;
import com.fil.service.*;

import java.util.ArrayList;

public class FoodDeliveryApplication {
    public static void main(String[] args) {
        IValidationCartService cartValidationService = new IValidationCartServiceImpl();
        IPaymentService paymentService = new IPaymentServiceImpl();
        IOrderRepository orderRepository = new IOrderRepositoryImpl();
        IRestaurantService restaurantService = new IRestaurantServiceImpl();
        IDeliveryService deliveryService = new IDeliveryServiceImpl();
        IOrderService orderService = new OrderService(cartValidationService, paymentService,
                orderRepository, restaurantService,deliveryService);
        Cart cart = new Cart();
        cart.setTotalAmount(100);
        cart.setOrderItems(new ArrayList<>());
        Customer customer = new Customer();
        customer.setAddress(new Address());
        OrderResult orderResult = orderService.placeOrder(cart, customer);
        if(orderResult.getMessage().equals("success")){
            System.out.println("Order is successfully created");
        }else {
            throw new RuntimeException("Order is not placed");
        }
    }
}
