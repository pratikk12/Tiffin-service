package com.app.TiffinAPI.controller;

import com.app.TiffinAPI.entity.MessEntity;
import com.app.TiffinAPI.entity.UserEntity;
import com.app.TiffinAPI.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

//    @GetMapping("/all")
    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

//    public ResponseEntity<List<UserEntity>> getAllUsers() {
//        return ResponseEntity.ok(userService.getAllUsers());
//    }
    @GetMapping("/email")
    public ResponseEntity<UserEntity> getUserByEmail(@RequestParam String email) {
        UserEntity user = userService.getUserByEmail(email);
        return ResponseEntity.ok(user);
    }
	
	    @GetMapping("/{id}")
	    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id) {
	    	Optional<UserEntity> user = userService.getUserById(id);
	        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	       
	    }

    @PostMapping
    public ResponseEntity<UserEntity> registerUser(@RequestBody UserEntity user) {
    	UserEntity savedUser = userService.saveUser(user);
    	return ResponseEntity.ok(savedUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Long id, @RequestBody UserEntity user) {
    	UserEntity updateUser = userService.updateUser(id, user);
    	return updateUser != null ? ResponseEntity.ok(updateUser) : ResponseEntity.notFound().build();
    }
        

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok("User deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("User not found!");
        }
    }
}
