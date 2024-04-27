package com.example.ecommerceplatform.controller;

import com.example.ecommerceplatform.model.Cart;
import com.example.ecommerceplatform.model.Order;
import com.example.ecommerceplatform.srevice.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adsweb/api/v1/orders")
public class OrderController {

    private final OrderService orderService;
@Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Create operationms
    @PostMapping("")
    public Order createOrder() {
        return orderService.save(new Order());
    }

    // Read operations
    @GetMapping("")
    public List<Order> getAllOrders() {
        return orderService.findAll();
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
        Optional<Order> optionalOrder = orderService.findById(orderId);
        return optionalOrder.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    // Update operation
    @PutMapping("/{orderId}")
    public ResponseEntity<Order> updateCart(@PathVariable Long orderId, @RequestBody Cart orderDetails) {
        Optional<Order> optionalOrder = orderService.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            orderService.save(order);
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete operation
    @DeleteMapping("/{orderId}")
    public ResponseEntity<?> deleteCart(@PathVariable Long orderId) {
        orderService.deleteById(orderId);
        return ResponseEntity.ok().build();
    }

}
