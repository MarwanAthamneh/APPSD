package com.example.ecommerceplatform.srevice;

import com.example.ecommerceplatform.model.user.User;
import com.example.ecommerceplatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
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

    public User save(User user) {
       return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long userId) {
       return userRepository.findById(userId);
    }

    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }
   /* public void addInitData(){
        List<User> users = Arrays.asList(  new User("john_doe", "password123", "john@example.com", "John", "Doe", "123 Main St, Anytown", "+1234567890", LocalDate.now(),"Admin"),
        new User("jane_smith", "password456", "jane@example.com", "Jane", "Smith", "456 Elm St, Othertown", "+0987654321", LocalDate.now(),),
        new User("alice_johnson", "password789", "alice@example.com", "Alice", "Johnson", "789 Oak St, Anothertown", "+1122334455", LocalDate.now(),"Customer"),
        new User("bob_brown", "passwordabc", "bob@example.com", "Bob", "Brown", "456 Pine St, Somewhereville", "+9988776655", LocalDate.now(),"Customer"));

        userRepository.saveAll(users);


    }*/
}
