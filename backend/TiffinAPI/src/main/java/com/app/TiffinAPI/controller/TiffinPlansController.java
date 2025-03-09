package com.app.TiffinAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.TiffinAPI.entity.TiffinPlansEntity;
import com.app.TiffinAPI.service.TiffinPlansService;

@RestController
@RequestMapping("/api/tiffinplans")
@CrossOrigin(origins = "*") // Allow cross-origin requests
public class TiffinPlansController {

    @Autowired
    private TiffinPlansService tiffinPlansService;

    @GetMapping
    public ResponseEntity<List<TiffinPlansEntity>> getAllTiffinPlans() {
        return ResponseEntity.ok(tiffinPlansService.getAllTiffinPlans());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TiffinPlansEntity> getTiffinPlanById(@PathVariable Long id) {
        return ResponseEntity.ok(tiffinPlansService.getTiffinPlanById(id));
    }

    @PostMapping
    public ResponseEntity<TiffinPlansEntity> createTiffinPlan(@RequestBody TiffinPlansEntity tiffinPlan) {
        return ResponseEntity.ok(tiffinPlansService.createTiffinPlan(tiffinPlan));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TiffinPlansEntity> updateTiffinPlan(@PathVariable Long id, @RequestBody TiffinPlansEntity updatedPlan) {
        return ResponseEntity.ok(tiffinPlansService.updateTiffinPlan(id, updatedPlan));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTiffinPlan(@PathVariable Long id) {
        tiffinPlansService.deleteTiffinPlan(id);
        return ResponseEntity.ok("Tiffin Plan deleted successfully");
    }
}
