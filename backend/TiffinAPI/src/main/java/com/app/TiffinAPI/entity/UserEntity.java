package com.app.TiffinAPI.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id") // Ensure this matches the column name in your DB
    private Long id;
    

    @Column(name = "name") // Ensure this matches the column name in your DB
    private String name;
    
    @Column(name = "username") // Ensure this matches the column name in your DB
    private String userName;
    
    @Column(name = "email") // Ensure this matches the column name in your DB
    private String email;
    
    @Column(name = "password") // Ensure this matches the column name in your DB
    private String password;
    
    @Column(name = "phone_number") // Ensure this matches the column name in your DB
    private Long phoneNumber;
    
    @Column(name = "address") // Ensure this matches the column name in your DB
    private String address;
}
