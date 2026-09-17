package com.fil.service;

import com.fil.model.Customer;
import com.fil.model.Order;
import com.fil.model.PaymentResult;

public interface IPaymentService {
    PaymentResult initatePaymentForCustomer(Customer customerInfo, Order orderInfo);
}
