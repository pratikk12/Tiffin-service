package com.app.TiffinAPI.service.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.TiffinAPI.entity.DeliveryEntity;
import com.app.TiffinAPI.enums.DeliveryStatus;

import com.app.TiffinAPI.repository.DeliveryRepository;
import com.app.TiffinAPI.service.DeliveryService;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Override
    public DeliveryEntity createDelivery(DeliveryEntity delivery) {
        return deliveryRepository.save(delivery);
    }

    @Override
    public DeliveryEntity getDeliveryById(int id) {
        return deliveryRepository.findById(id).orElse(null);
    }

    @Override
    public List<DeliveryEntity> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    @Override
    public DeliveryEntity updateDeliveryStatus(int id, String status) {
        Optional<DeliveryEntity> deliveryOpt = deliveryRepository.findById(id);
        if (deliveryOpt.isPresent()) {
            DeliveryEntity delivery = deliveryOpt.get();
            delivery.setStatus(DeliveryStatus.valueOf(status.toUpperCase()));  // Use DeliveryStatus
            return deliveryRepository.save(delivery);
        }
        return null;
    }


    @Override
    public void deleteDelivery(int id) {
        deliveryRepository.deleteById(id);
    }
}