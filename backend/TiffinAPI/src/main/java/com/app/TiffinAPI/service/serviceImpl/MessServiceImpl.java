package com.app.TiffinAPI.service.serviceImpl;

import com.app.TiffinAPI.entity.MessEntity;
import com.app.TiffinAPI.repository.MessRepository;
import com.app.TiffinAPI.service.MessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessServiceImpl implements MessService {

    @Autowired
    private MessRepository messRepository;

    @Override
    public MessEntity addMess(MessEntity mess) {
        return messRepository.save(mess);
    }

    @Override
    public List<MessEntity> getAllMess() {
        return messRepository.findAll();
    }

    @Override
    public Optional<MessEntity> getMessById(Long id) {
        return messRepository.findById(id);
    }

    @Override
    public MessEntity updateMess(Long id, MessEntity updatedMess) {
        return messRepository.findById(id)
                .map(existingMess -> {
                    existingMess.setMessName(updatedMess.getMessName());
                    existingMess.setAddress(updatedMess.getAddress());
                    existingMess.setCity(updatedMess.getCity());
                    existingMess.setContact(updatedMess.getContact());
                    existingMess.setDescription(updatedMess.getDescription());
                    return messRepository.save(existingMess);
                })
                .orElse(null);
    }

    @Override
    public void deleteMess(Long id) {
        if (!messRepository.existsById(id)) {
            throw new RuntimeException("Mess not found with id: " + id);
        }
        messRepository.deleteById(id);
    }
}
