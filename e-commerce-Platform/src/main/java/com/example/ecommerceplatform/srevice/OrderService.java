package com.example.ecommerceplatform.srevice;

import com.example.ecommerceplatform.model.Cart;
import com.example.ecommerceplatform.model.Order;
import com.example.ecommerceplatform.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> findById(Long orderId) {
        return orderRepository.findById(orderId);

    }

    public void deleteById(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
