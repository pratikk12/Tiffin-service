package com.app.TiffinAPI.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.TiffinAPI.entity.OrdersEntity;
//import com.app.TiffinAPI.enums.DeliveryStatus;
import com.app.TiffinAPI.enums.OrderStatus;
//import com.app.TiffinAPI.enums.OrdersStatus;
import com.app.TiffinAPI.repository.OrdersRepository;
import com.app.TiffinAPI.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public OrdersEntity placeOrder(OrdersEntity order) {
        return ordersRepository.save(order);
    }

    @Override
    public OrdersEntity getOrderById(Integer orderId) {
        return ordersRepository.findById(orderId).orElse(null);
    }

    @Override
    public List<OrdersEntity> getAllOrders() {
        return ordersRepository.findAll();
    }

    @Override
    public OrdersEntity updateOrderStatus(Integer orderId, String status) {
        Optional<OrdersEntity> optionalOrder = ordersRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            OrdersEntity order = optionalOrder.get();
            order.setStatus(OrderStatus.valueOf(status.toUpperCase())); // Ensure input matches enum
            return ordersRepository.save(order);
        }
        return null;
    }


    @Override
    public void deleteOrder(Integer orderId) {
        ordersRepository.deleteById(orderId);
    }
}
