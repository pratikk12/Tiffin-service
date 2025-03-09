package com.app.TiffinAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.TiffinAPI.entity.DeliveryEntity;

public interface DeliveryRepository extends JpaRepository<DeliveryEntity, Integer> {
}
