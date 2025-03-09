package com.app.TiffinAPI.service;


import java.util.List;
import com.app.TiffinAPI.entity.TiffinPlansEntity;

public interface TiffinPlansService {
    List<TiffinPlansEntity> getAllTiffinPlans();
    TiffinPlansEntity getTiffinPlanById(Long id);
    TiffinPlansEntity createTiffinPlan(TiffinPlansEntity tiffinPlan);
    TiffinPlansEntity updateTiffinPlan(Long id, TiffinPlansEntity updatedPlan);
    void deleteTiffinPlan(Long id);
}
