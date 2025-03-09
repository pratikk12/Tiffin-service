package com.app.TiffinAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.TiffinAPI.entity.TiffinPlansEntity;

@Repository
public interface TiffinPlansRepository extends JpaRepository<TiffinPlansEntity, Long> {
}
