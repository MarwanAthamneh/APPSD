package com.example.ecommerceplatform.srevice;

import com.example.ecommerceplatform.model.OrderItem;
import com.example.ecommerceplatform.repository.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    private OrderItemRepository orderItemRepository;


    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public OrderItem save(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public List<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }

    public Optional<OrderItem> findById(Long orderItemId) {
        return orderItemRepository.findById(orderItemId);
    }

    public void deleteById(Long orderItemId) {
        orderItemRepository.deleteById(orderItemId);
    }
}
