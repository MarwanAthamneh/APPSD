package com.example.ecommerceplatform.controller;

import com.example.ecommerceplatform.model.OrderItem;
import com.example.ecommerceplatform.srevice.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adsweb/api/v1/orderitems")
public class OrderItemController {

    private final OrderItemService orderItemService;
@Autowired
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    // Create operation
    @PostMapping("")
    public OrderItem createOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemService.save(orderItem);
    }

    // Read operation
    @GetMapping("/find")
    public List<OrderItem> getAllOrderItems() {
        return orderItemService.findAll();
    }

    // Update operation
    @PutMapping("/{orderItemId}")
    public ResponseEntity<OrderItem> updateOrderItem(@PathVariable Long orderItemId, @RequestBody OrderItem orderItemDetails) {
        Optional<OrderItem> optionalOrderItem = orderItemService.findById(orderItemId);
        if (optionalOrderItem.isPresent()) {
            OrderItem orderItem = optionalOrderItem.get();

            orderItemService.save(orderItem);
            return ResponseEntity.ok(orderItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete operation
    @DeleteMapping("/{orderItemId}")
    public ResponseEntity<?> deleteOrderItem(@PathVariable Long orderItemId) {
        orderItemService.deleteById(orderItemId);
        return ResponseEntity.ok().build();
    }
}
