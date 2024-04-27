package com.example.ecommerceplatform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private double price;

    private int quantityAvailable;

    private String imageUrl;

    private String brand;

    private String fragranceNotes;


    private String gender;

    private LocalDate dateAdded;

    public Product(String name, String description, double price, int quantityAvailable, String imageUrl, String brand, String fragranceNotes, String gender, LocalDate dateAdded) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
        this.imageUrl = imageUrl;
        this.brand = brand;
        this.fragranceNotes = fragranceNotes;
        this.gender = gender;
        this.dateAdded = dateAdded;
    }
}