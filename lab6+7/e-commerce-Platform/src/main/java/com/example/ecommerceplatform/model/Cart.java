package com.example.ecommerceplatform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "cart")
    private List<OrderItem> items;

    private double totalAmount;

    public Cart(User user, List<OrderItem> items, double totalAmount) {
        this.user = user;
        this.items = items;
        this.totalAmount = totalAmount;
    }
}