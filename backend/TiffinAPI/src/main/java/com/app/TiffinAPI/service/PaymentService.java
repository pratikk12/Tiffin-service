package com.app.TiffinAPI.service;

import com.app.TiffinAPI.entity.PaymentEntity;
import java.util.List;

public interface PaymentService {
    PaymentEntity processPayment(PaymentEntity payment);
    PaymentEntity getPaymentById(Long paymentId);
    List<PaymentEntity> getAllPayments();
}
