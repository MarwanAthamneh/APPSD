package com.example.ecommerceplatform.srevice;

import com.example.ecommerceplatform.model.User;
import com.example.ecommerceplatform.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsersWithAddressesSortedByLastName() {
        return userRepository.findAllUsersWithAddressesSortedByLastName();
    }

    public User getUserById(Long userId) {
        return  userRepository.findById(userId).orElse(null);
    }

    public void registerUser(User user) {
        userRepository.save(user);
    }
}
