package com.app.TiffinAPI.service;

import java.util.List;
import com.app.TiffinAPI.entity.OrdersEntity;

public interface OrdersService {
    OrdersEntity placeOrder(OrdersEntity order);
    OrdersEntity getOrderById(Integer orderId);
    List<OrdersEntity> getAllOrders();
    OrdersEntity updateOrderStatus(Integer orderId, String status);
    void deleteOrder(Integer orderId);
}
