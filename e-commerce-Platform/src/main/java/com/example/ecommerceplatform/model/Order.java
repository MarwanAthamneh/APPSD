package com.example.ecommerceplatform.model;

import com.example.ecommerceplatform.model.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    private String status;

    private double totalAmount;

    public Order(User user, Date orderDate, String status, double totalAmount) {
        this.user = user;
        this.orderDate = orderDate;
        this.status = status;
        this.totalAmount = totalAmount;
    }
}