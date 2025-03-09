package com.app.TiffinAPI.controller;

import com.app.TiffinAPI.entity.MessOwnerEntity;
import com.app.TiffinAPI.service.MessOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messowner")
@CrossOrigin("*")
public class MessOwnerController {

    @Autowired
    private MessOwnerService messOwnerService;

    @PostMapping
    public MessOwnerEntity addMessOwner(@RequestBody MessOwnerEntity messOwner) {
        return messOwnerService.addMessOwner(messOwner);
    }

    @GetMapping
    public List<MessOwnerEntity> getAllMessOwners() {
        return messOwnerService.getAllMessOwners();
    }

    @GetMapping("/{id}")
    public MessOwnerEntity getMessOwnerById(@PathVariable Long id) {
        return messOwnerService.getMessOwnerById(id);
    }

    @PutMapping("/{id}")
    public MessOwnerEntity updateMessOwner(@PathVariable Long id, @RequestBody MessOwnerEntity messOwner) {
        return messOwnerService.updateMessOwner(id, messOwner);
    }

    @DeleteMapping("/{id}")
    public String deleteMessOwner(@PathVariable Long id) {
        messOwnerService.deleteMessOwner(id);
        return "Mess Owner deleted successfully!";
    }
}
