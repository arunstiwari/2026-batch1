package com.fil.repository;

import com.fil.model.Order;

import java.util.ArrayList;

public class IOrderRepositoryImpl implements IOrderRepository {
    @Override
    public Order save(Order orderInfo) {
        return new Order("323232",100,new ArrayList<>(),"");
    }
}
