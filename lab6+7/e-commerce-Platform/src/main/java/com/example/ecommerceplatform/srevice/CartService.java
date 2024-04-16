package com.example.ecommerceplatform.srevice;

import com.example.ecommerceplatform.model.Cart;
import com.example.ecommerceplatform.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart save(Cart cart) {
       return cartRepository.save(cart);
    }

    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    public Optional<Cart> findById(Long cartId) {
        return cartRepository.findById(cartId);
    }

    public void deleteById(Long cartId) {
        cartRepository.deleteById(cartId);
    }
}
