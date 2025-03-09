package com.app.TiffinAPI.service;

import com.app.TiffinAPI.entity.UserEntity;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserEntity> getAllUsers();
    Optional<UserEntity> getUserById(Long id);
    UserEntity getUserByEmail(String email);
    UserEntity saveUser(UserEntity user);  
    UserEntity createUser(UserEntity user);
    UserEntity updateUser(Long id, UserEntity user);
    void deleteUser(Long id);
}
