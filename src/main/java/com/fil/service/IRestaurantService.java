package com.fil.service;

import com.fil.model.Order;
import com.fil.model.RestaurantResponse;

public interface IRestaurantService {
    RestaurantResponse notifyNewOrder(Order createdOrder);
}
