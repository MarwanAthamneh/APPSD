package com.example.ecommerceplatform.model.user;


import com.example.ecommerceplatform.model.token.Token;
import com.example.ecommerceplatform.model.user.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;

    private String firstName;

    private String lastName;

    private String address;

    private String phoneNumber;

    private LocalDate dateRegistered;
    @OneToMany(mappedBy = "user")
    @Setter(AccessLevel.PRIVATE)
    @ToString.Exclude
    private List<Token> tokens;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Size(max = 255)
    private Role role;


    public User(String username, String password, String email, String firstName, String lastName, String address, String phoneNumber, LocalDate dateRegistered , Role role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateRegistered = dateRegistered;
        this.role=role;
    }
// Getters and setters
}
