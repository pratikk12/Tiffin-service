package com.app.TiffinAPI.controller;

import com.app.TiffinAPI.entity.PaymentEntity;
import com.app.TiffinAPI.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public PaymentEntity processPayment(@RequestBody PaymentEntity payment) {
        return paymentService.processPayment(payment);
    }

    @GetMapping("/{id}")
    public PaymentEntity getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    @GetMapping
    public List<PaymentEntity> getAllPayments() {
        return paymentService.getAllPayments();
    }
}
