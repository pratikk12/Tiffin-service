package com.app.TiffinAPI.entity;


import lombok.Data;
import java.sql.Timestamp;

import com.app.TiffinAPI.enums.DeliveryStatus;

//import com.app.TiffinAPI.enums.DeliveryStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "delivery")
@Data
public class DeliveryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private int deliveryId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private OrdersEntity order;

    @ManyToOne
    @JoinColumn(name = "delivery_person_id", nullable = false)
    private DeliveryPersonEntity deliveryPerson;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "ENUM('Out for Delivery','Delivered','Failed')", nullable = true)
    private DeliveryStatus status = DeliveryStatus.OUT_FOR_DELIVERY;

    @Column(name = "delivered_at", nullable = true)
    private Timestamp deliveredAt;
}
