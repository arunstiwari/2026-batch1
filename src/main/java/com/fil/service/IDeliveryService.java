package com.fil.service;

import com.fil.model.DeliveryRequest;
import com.fil.model.DeliveryResponse;

public interface IDeliveryService {
    DeliveryResponse notifyOrderDispatch(DeliveryRequest deliveryRequest);
}
