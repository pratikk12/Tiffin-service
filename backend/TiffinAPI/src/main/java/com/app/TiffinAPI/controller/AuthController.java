package com.app.TiffinAPI.controller;



//import com.app.tiffinAPI.entity.UserEntity;
//import com.tiffin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import com.app.TiffinAPI.entity.MessOwnerEntity;
import com.app.TiffinAPI.entity.UserEntity;
import com.app.TiffinAPI.repository.MessOwnerRepository;
import com.app.TiffinAPI.repository.UserRepository;

import java.util.Optional;

@CrossOrigin("http://localhost:5173") // Allow frontend connection
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@
	
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MessOwnerRepository messOwnerRepository;
    
    @PostMapping("/register")
    public ResponseEntity<UserEntity> registerUser(@RequestBody UserEntity user) {
        UserEntity savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserEntity loginRequest) {
        Optional<UserEntity> user = userRepository.findByEmail(loginRequest.getEmail());

        if (user.isPresent() && user.get().getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.ok(user.get()); // Successful login
        } else {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
        
    }
    
    @PostMapping("/messowner")
    public ResponseEntity<MessOwnerEntity> registerMessOwner(@RequestBody MessOwnerEntity messOwner) {
        MessOwnerEntity savedMessOwner = messOwnerRepository.save(messOwner);
        return ResponseEntity.ok(savedMessOwner);
    }
    
    @PostMapping("/messlogin")
    public ResponseEntity<?> loginOwner(@RequestBody MessOwnerEntity loginRequest) {
        Optional<MessOwnerEntity> user = messOwnerRepository.findByEmail(loginRequest.getEmail());

        if (user.isPresent() && user.get().getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.ok(user.get()); // Successful login
        } else {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
        
    }
}
