package com.app.TiffinAPI.controller;

import com.app.TiffinAPI.entity.MessEntity;
import com.app.TiffinAPI.service.MessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mess")
@CrossOrigin("*")
public class MessController {

    @Autowired
    private MessService messService;

    @PostMapping
    public ResponseEntity<MessEntity> addMess(@RequestBody MessEntity mess) {
        MessEntity createdMess = messService.addMess(mess);
        return ResponseEntity.ok(createdMess);
    }

    @GetMapping
    public ResponseEntity<List<MessEntity>> getAllMess() {
        return ResponseEntity.ok(messService.getAllMess());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessEntity> getMessById(@PathVariable Long id) {  
        Optional<MessEntity> mess = messService.getMessById(id);
        return mess.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessEntity> updateMess(@PathVariable Long id, @RequestBody MessEntity mess) {
        MessEntity updatedMess = messService.updateMess(id, mess);
        return updatedMess != null ? ResponseEntity.ok(updatedMess) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMess(@PathVariable Long id) {
        messService.deleteMess(id);
        return ResponseEntity.ok("Mess deleted successfully!");
    }
}
