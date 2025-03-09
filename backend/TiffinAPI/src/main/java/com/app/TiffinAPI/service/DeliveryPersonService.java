package com.app.TiffinAPI.service;

import com.app.TiffinAPI.entity.DeliveryPersonEntity;
import java.util.List;
import java.util.Optional;

public interface DeliveryPersonService {
    
    DeliveryPersonEntity addDeliveryPerson(DeliveryPersonEntity deliveryPerson);
    
    List<DeliveryPersonEntity> getAllDeliveryPersons();
    
    Optional<DeliveryPersonEntity> getDeliveryPersonById(int id);
    
    DeliveryPersonEntity updateDeliveryPerson(int id, DeliveryPersonEntity updatedDeliveryPerson);
    
    void deleteDeliveryPerson(int id);
}
