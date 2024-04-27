package com.example.ecommerceplatform.controller;

import com.example.ecommerceplatform.model.Cart;
import com.example.ecommerceplatform.srevice.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adsweb/api/v1/carts")
public class CartController {

    private final CartService cartService;
@Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // Create operations
    @PostMapping("")
    public Cart createCart() {
        return cartService.save(new Cart());
    }

    // Read operations
    @GetMapping("")
    public List<Cart> getAllCarts() {
        return cartService.findAll();
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getCartById(@PathVariable Long cartId) {
        Optional<Cart> optionalCart = cartService.findById(cartId);
        return optionalCart.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    // Update operation
    @PutMapping("/{cartId}")
    public ResponseEntity<Cart> updateCart(@PathVariable Long cartId, @RequestBody Cart cartDetails) {
        Optional<Cart> optionalCart = cartService.findById(cartId);
        if (optionalCart.isPresent()) {
            Cart cart = optionalCart.get();
            cartService.save(cart);
            return ResponseEntity.ok(cart);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete operation
    @DeleteMapping("/{cartId}")
    public ResponseEntity<?> deleteCart(@PathVariable Long cartId) {
        cartService.deleteById(cartId);
        return ResponseEntity.ok().build();
    }

}
