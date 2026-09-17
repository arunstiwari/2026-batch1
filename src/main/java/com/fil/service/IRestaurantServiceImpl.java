package com.fil.service;

import com.fil.model.Order;
import com.fil.model.RestaurantResponse;

public class IRestaurantServiceImpl implements IRestaurantService {
    @Override
    public RestaurantResponse notifyNewOrder(Order createdOrder) {
        return new RestaurantResponse();
    }
}
