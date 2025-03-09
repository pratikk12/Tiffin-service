package com.app.TiffinAPI.repository;

import com.app.TiffinAPI.entity.MessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessRepository extends JpaRepository<MessEntity, Long> {
}
