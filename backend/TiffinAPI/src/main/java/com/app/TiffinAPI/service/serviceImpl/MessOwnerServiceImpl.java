package com.app.TiffinAPI.service.serviceImpl;

import com.app.TiffinAPI.entity.MessOwnerEntity;
import com.app.TiffinAPI.repository.MessOwnerRepository;
import com.app.TiffinAPI.service.MessOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MessOwnerServiceImpl implements MessOwnerService {

    @Autowired
    private MessOwnerRepository messOwnerRepository;

    @Override
    public MessOwnerEntity addMessOwner(MessOwnerEntity messOwner) {
        return messOwnerRepository.save(messOwner);
    }

    @Override
    public List<MessOwnerEntity> getAllMessOwners() {
        return messOwnerRepository.findAll();
    }

    @Override
    public MessOwnerEntity getMessOwnerById(Long id) {
        Optional<MessOwnerEntity> messOwner = messOwnerRepository.findById(id);
        return messOwner.orElse(null);
    }

    @Override
    public MessOwnerEntity updateMessOwner(Long id, MessOwnerEntity updatedMessOwner) {
        Optional<MessOwnerEntity> existingMessOwner = messOwnerRepository.findById(id);
        if (existingMessOwner.isPresent()) {
            MessOwnerEntity messOwner = existingMessOwner.get();
            messOwner.setName(updatedMessOwner.getName());
            messOwner.setAddress(updatedMessOwner.getAddress());
            messOwner.setPhoneNumber(updatedMessOwner.getPhoneNumber());
            return messOwnerRepository.save(messOwner);
        }
        return null;
    }

    @Override
    public void deleteMessOwner(Long id) {
        messOwnerRepository.deleteById(id);
    }
}
