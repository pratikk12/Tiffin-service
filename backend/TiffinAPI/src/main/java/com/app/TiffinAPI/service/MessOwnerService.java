package com.app.TiffinAPI.service;

import com.app.TiffinAPI.entity.MessOwnerEntity;
import java.util.List;

public interface MessOwnerService {
    MessOwnerEntity addMessOwner(MessOwnerEntity messOwner);
    List<MessOwnerEntity> getAllMessOwners();
    MessOwnerEntity getMessOwnerById(Long id);
    MessOwnerEntity updateMessOwner(Long id, MessOwnerEntity updatedMessOwner);
    void deleteMessOwner(Long id);
}
