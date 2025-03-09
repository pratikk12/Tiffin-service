package com.app.TiffinAPI.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
	@Table(name = "messowner")
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public class MessOwnerEntity {
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "owner_id")
	    private Long ownerId;

	    @Column(name = "name", nullable = false)
	    private String name;
	    
	    @Column(name = "username", nullable = false, unique = true)
	    private String userName;

	    @Column(name = "email", nullable = false, unique = true)
	    private String email;
	    
	    @Column(name = "password", nullable = false, unique = true)
	    private String password;

	    @Column(name = "phone_number", nullable = false, unique = true)
	    private String phoneNumber;

	    @Column(name = "address", nullable = false)
	    private String address;
	}

