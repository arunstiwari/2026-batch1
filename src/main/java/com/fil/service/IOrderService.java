package com.fil.service;

import com.fil.model.Customer;
import com.fil.model.Cart;
import com.fil.model.OrderResult;

public interface IOrderService {
    OrderResult placeOrder(Cart cart, Customer customerInfo);
}
