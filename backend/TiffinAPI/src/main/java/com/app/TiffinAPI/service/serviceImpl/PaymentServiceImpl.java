package com.app.TiffinAPI.service.serviceImpl;

import com.app.TiffinAPI.entity.PaymentEntity;
import com.app.TiffinAPI.repository.PaymentRepository;
import com.app.TiffinAPI.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public PaymentEntity processPayment(PaymentEntity payment) {
        // Business logic for processing payments
        return paymentRepository.save(payment);
    }

    @Override
    public PaymentEntity getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId).orElseThrow(() -> new RuntimeException("Payment not found"));
    }

    @Override
    public List<PaymentEntity> getAllPayments() {
        return paymentRepository.findAll();
    }
}
