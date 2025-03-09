package com.app.TiffinAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.TiffinAPI.entity.OrdersEntity;
import com.app.TiffinAPI.service.OrdersService;

@RestController
@RequestMapping("api/orders")
@CrossOrigin("*")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @PostMapping("/place")
    public ResponseEntity<OrdersEntity> placeOrder(@RequestBody OrdersEntity order) {
        return ResponseEntity.ok(ordersService.placeOrder(order));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrdersEntity> getOrderById(@PathVariable Integer orderId) {
        OrdersEntity order = ordersService.getOrderById(orderId);
        return (order != null) ? ResponseEntity.ok(order) : ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrdersEntity>> getAllOrders() {
        return ResponseEntity.ok(ordersService.getAllOrders());
    }

    @PutMapping("/updateStatus/{orderId}")
    public ResponseEntity<OrdersEntity> updateOrderStatus(@PathVariable Integer orderId, @RequestParam String status) {
        OrdersEntity updatedOrder = ordersService.updateOrderStatus(orderId, status);
        return (updatedOrder != null) ? ResponseEntity.ok(updatedOrder) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer orderId) {
        ordersService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }
}
