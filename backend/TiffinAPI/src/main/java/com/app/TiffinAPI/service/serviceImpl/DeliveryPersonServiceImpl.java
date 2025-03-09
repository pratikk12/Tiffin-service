package com.app.TiffinAPI.service.serviceImpl;

import com.app.TiffinAPI.entity.DeliveryPersonEntity;
import com.app.TiffinAPI.repository.DeliveryPersonRepository;
import com.app.TiffinAPI.service.DeliveryPersonService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryPersonServiceImpl implements DeliveryPersonService {

    @Autowired
    private DeliveryPersonRepository deliveryPersonRepository;

    @Override
    public DeliveryPersonEntity addDeliveryPerson(DeliveryPersonEntity deliveryPerson) {
        return deliveryPersonRepository.save(deliveryPerson);
    }

    @Override
    public List<DeliveryPersonEntity> getAllDeliveryPersons() {
        return deliveryPersonRepository.findAll();
    }

    @Override
    public Optional<DeliveryPersonEntity> getDeliveryPersonById(int id) {
        return deliveryPersonRepository.findById(id);
    }

    @Override
    public DeliveryPersonEntity updateDeliveryPerson(int id, DeliveryPersonEntity updatedDeliveryPerson) {
        return deliveryPersonRepository.findById(id)
            .map(existingPerson -> {
                existingPerson.setName(updatedDeliveryPerson.getName());
                existingPerson.setUsername(updatedDeliveryPerson.getUsername());
                existingPerson.setEmail(updatedDeliveryPerson.getEmail());
                existingPerson.setPhoneNumber(updatedDeliveryPerson.getPhoneNumber());
                existingPerson.setAddress(updatedDeliveryPerson.getAddress());
                return deliveryPersonRepository.save(existingPerson);
            })
            .orElseThrow(() -> new RuntimeException("Delivery Person not found"));
    }

    @Override
    public void deleteDeliveryPerson(int id) {
        deliveryPersonRepository.deleteById(id);
    }
}
