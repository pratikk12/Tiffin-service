package com.app.TiffinAPI.service;

import com.app.TiffinAPI.entity.MessEntity;
import java.util.List;
import java.util.Optional;

public interface MessService {
    MessEntity addMess(MessEntity mess);
    List<MessEntity> getAllMess();
    Optional<MessEntity> getMessById(Long id);
    MessEntity updateMess(Long id, MessEntity updatedMess);
    void deleteMess(Long id);
}
