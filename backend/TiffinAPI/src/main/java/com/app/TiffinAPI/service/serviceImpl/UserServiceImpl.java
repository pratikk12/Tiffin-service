package com.app.TiffinAPI.service.serviceImpl;

import com.app.TiffinAPI.entity.UserEntity;
import com.app.TiffinAPI.repository.UserRepository;
import com.app.TiffinAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
    
    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }
    
    @Override
    public UserEntity getUserByEmail(String email) {
    	 return userRepository.findByEmail(email)
    	            .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }

    @Override
    public UserEntity updateUser(Long id, UserEntity user) {
        return userRepository.findById(id).map(existingUser -> {
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setUserName(user.getUserName());
            existingUser.setPassword(user.getPassword());
            existingUser.setPhoneNumber(user.getPhoneNumber());
            existingUser.setAddress(user.getAddress());
            
            return userRepository.save(existingUser);
        }).orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + id));
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found with ID: " + id);
        }
        userRepository.deleteById(id);
    }
}
