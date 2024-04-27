package com.example.ecommerceplatform.controller;

import com.example.ecommerceplatform.model.user.User;
import com.example.ecommerceplatform.srevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adsweb/api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<User>> getAllUsersWithAddressesSortedByLastName() {
        List<User> users = userService.getAllUsersWithAddressesSortedByLastName();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable("userId") Long userId) {
        try {
            User user = userService.getUserById(userId);
            if (user != null) {
                return new ResponseEntity<>(user, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // Create operation
    @PostMapping("")
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    // Read operation
    @GetMapping("")
    public List<User> getAllUser() {
        return userService.findAll();
    }

    // Update operation
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User userDetails) {
        Optional<User> optionalUser = userService.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            userService.save(user);
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete operation
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteReview(@PathVariable Long userId) {
        userService.deleteById(userId);
        return ResponseEntity.ok().build();
    }
}
