package com.app.TiffinAPI.service;

import java.util.List;
import com.app.TiffinAPI.entity.DeliveryEntity;

public interface DeliveryService {
    DeliveryEntity createDelivery(DeliveryEntity delivery);
    DeliveryEntity getDeliveryById(int id);
    List<DeliveryEntity> getAllDeliveries();
    DeliveryEntity updateDeliveryStatus(int id, String status);
    void deleteDelivery(int id);
}