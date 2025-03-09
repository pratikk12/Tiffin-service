package com.app.TiffinAPI.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import com.app.TiffinAPI.enums.OrderStatus;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrdersEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
    
    @ManyToOne
    @JoinColumn(name = "mess_id", nullable = false)
    private MessEntity mess;
    
    @ManyToOne
    @JoinColumn(name = "plan_id", nullable = false)
    private TiffinPlansEntity plan;
    
    @Column(name = "order_date", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp orderDate;
    
    @Column(name = "delivery_address", nullable = false, columnDefinition = "TEXT")
    private String deliveryAddress;
    
    @Column(name = "total_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmount;
    
    @Enumerated(EnumType.STRING) // This will store the enum as a string in the database
    @Column(name = "status", nullable = false)
    private OrderStatus status;
}
