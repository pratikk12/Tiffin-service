package com.app.TiffinAPI.service.serviceImpl;
import com.app.TiffinAPI.repository.MessRepository;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.TiffinAPI.entity.MessEntity;
import com.app.TiffinAPI.entity.TiffinPlansEntity;
import com.app.TiffinAPI.repository.TiffinPlansRepository;
import com.app.TiffinAPI.service.TiffinPlansService;

@Service
public class TiffinPlansServiceImpl implements TiffinPlansService {

    @Autowired
    private TiffinPlansRepository tiffinPlansRepository;
    
    @Autowired
    private MessRepository messRepository;

    @Override
    public List<TiffinPlansEntity> getAllTiffinPlans() {
        return tiffinPlansRepository.findAll();
    }

    @Override
    public TiffinPlansEntity getTiffinPlanById(Long id) {
        return tiffinPlansRepository.findById(id).orElseThrow(() -> new RuntimeException("Tiffin Plan not found with id: " + id));
    }

    @Override
    public TiffinPlansEntity createTiffinPlan(TiffinPlansEntity tiffinPlan) {
        if (tiffinPlan.getMess() == null) {
            throw new RuntimeException("Mess is required for creating a Tiffin Plan.");
        }

        // Ensure the associated messId exists
        MessEntity messEntity = messRepository.findById(tiffinPlan.getMess().getMessId())
                .orElseThrow(() -> new RuntimeException("Mess not found with id: " + tiffinPlan.getMess().getMessId()));

        // Set the persistent mess entity
        tiffinPlan.setMess(messEntity);

        // Now save the tiffin plan
        return tiffinPlansRepository.save(tiffinPlan);
    }



    @Override
    public TiffinPlansEntity updateTiffinPlan(Long id, TiffinPlansEntity updatedPlan) {
        Optional<TiffinPlansEntity> existingPlanOpt = tiffinPlansRepository.findById(id);
        
        if (existingPlanOpt.isPresent()) {
            TiffinPlansEntity existingPlan = existingPlanOpt.get();
            existingPlan.setName(updatedPlan.getName());
            existingPlan.setDescription(updatedPlan.getDescription());
            existingPlan.setPrice(updatedPlan.getPrice());
            existingPlan.setMess(updatedPlan.getMess());
            return tiffinPlansRepository.save(existingPlan);
        } else {
            throw new RuntimeException("Tiffin Plan not found with id: " + id);
        }
    }

    @Override
    public void deleteTiffinPlan(Long id) {
        if (!tiffinPlansRepository.existsById(id)) {
            throw new RuntimeException("Tiffin Plan not found with id: " + id);
        }
        tiffinPlansRepository.deleteById(id);
    }
}
