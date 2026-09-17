package com.fil.repository;

import com.fil.model.Order;

public interface IOrderRepository {
    Order save(Order orderInfo);
}
