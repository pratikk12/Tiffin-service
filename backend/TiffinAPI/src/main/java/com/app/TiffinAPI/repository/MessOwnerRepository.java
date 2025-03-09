package com.app.TiffinAPI.repository;

import com.app.TiffinAPI.entity.MessOwnerEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessOwnerRepository extends JpaRepository<MessOwnerEntity, Long> {
	Optional<MessOwnerEntity> findByEmail(String email);
}
