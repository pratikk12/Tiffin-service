	package com.app.TiffinAPI.controller;
	
	import com.app.TiffinAPI.entity.DeliveryPersonEntity;
	import com.app.TiffinAPI.service.DeliveryPersonService;
	import org.springframework.web.bind.annotation.*;
	import org.springframework.beans.factory.annotation.Autowired;
	
	import java.util.List;
	import java.util.Optional;
	
	@RestController
	@RequestMapping("/api/delivery-persons")
	public class DeliveryPersonController {
	
	    @Autowired
	    private DeliveryPersonService deliveryPersonService;
	
	    // Add a new Delivery Person
	    @PostMapping
	    public DeliveryPersonEntity addDeliveryPerson(@RequestBody DeliveryPersonEntity deliveryPerson) {
	        return deliveryPersonService.addDeliveryPerson(deliveryPerson);
	    }
	
	    // Get all Delivery Persons
	    @GetMapping
	    public List<DeliveryPersonEntity> getAllDeliveryPersons() {
	        return deliveryPersonService.getAllDeliveryPersons();
	    }
	
	    // Get Delivery Person by ID
	    @GetMapping("/{id}")
	    public Optional<DeliveryPersonEntity> getDeliveryPersonById(@PathVariable int id) {
	        return deliveryPersonService.getDeliveryPersonById(id);
	    }
	
	    // Update Delivery Person by ID
	    @PutMapping("/{id}")
	    public DeliveryPersonEntity updateDeliveryPerson(@PathVariable int id, @RequestBody DeliveryPersonEntity updatedDeliveryPerson) {
	        return deliveryPersonService.updateDeliveryPerson(id, updatedDeliveryPerson);
	    }
	
	    // Delete Delivery Person by ID
	    @DeleteMapping("/{id}")
	    public String deleteDeliveryPerson(@PathVariable int id) {
	        deliveryPersonService.deleteDeliveryPerson(id);
	        return "Delivery person with ID " + id + " deleted successfully.";
	    }
	}
