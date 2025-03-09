package com.app.TiffinAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.TiffinAPI.entity.DeliveryPersonEntity;
import java.util.Optional;

public interface DeliveryPersonRepository extends JpaRepository<DeliveryPersonEntity, Integer> {
    
    Optional<DeliveryPersonEntity> findByUsername(String username);
    
    Optional<DeliveryPersonEntity> findByEmail(String email);
    
    Optional<DeliveryPersonEntity> findByPhoneNumber(String phoneNumber);
}
