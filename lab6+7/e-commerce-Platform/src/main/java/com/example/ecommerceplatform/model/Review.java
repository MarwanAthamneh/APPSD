package com.example.ecommerceplatform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private User user;

    private int rating;

    private String comment;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datePosted;

    public Review(Product product, User user, int rating, String comment, Date datePosted) {
        this.product = product;
        this.user = user;
        this.rating = rating;
        this.comment = comment;
        this.datePosted = datePosted;
    }
}