/*
package com.example.ecommerceplatform.data;


import com.example.ecommerceplatform.model.*;
import com.example.ecommerceplatform.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    public DataInitializer(ProductRepository productRepository, CartRepository cartRepository,
                           UserRepository userRepository, ReviewRepository reviewRepository , OrderRepository orderRepository , OrderItemRepository orderItemRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.reviewRepository = reviewRepository;
        this.orderRepository=orderRepository;
        this.orderItemRepository=orderItemRepository;

    }

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User("john_doe", "password123", "john@example.com", "John", "Doe", "123 Main St, Anytown", "+1234567890", LocalDate.now());
        User user2 = new User("jane_smith", "password456", "jane@example.com", "Jane", "Smith", "456 Elm St, Othertown", "+0987654321", LocalDate.now());
        User user3 = new User("alice_johnson", "password789", "alice@example.com", "Alice", "Johnson", "789 Oak St, Anothertown", "+1122334455", LocalDate.now());
        User user4 = new User("bob_brown", "passwordabc", "bob@example.com", "Bob", "Brown", "456 Pine St, Somewhereville", "+9988776655", LocalDate.now());

        Cart cart1 = new Cart(user1, new ArrayList<>(), 0.0);
        Cart cart2 = new Cart(user2, new ArrayList<>(), 0.0);
        Cart cart3 = new Cart(user3, new ArrayList<>(), 0.0);
        Cart cart4 = new Cart(user4, new ArrayList<>(), 0.0);

        Order order1 = new Order(user1, new Date(), "Pending", 100.0);
        Order order2 = new Order(user2, new Date(), "Completed", 150.0);
        Order order3 = new Order(user3, new Date(), "Processing", 200.0);
        Order order4 = new Order(user4, new Date(), "Shipped", 300.0);


        Product product1 = new Product("Gucci Absolute", "Good for winter", 50.0, 100, "image_url_1", "Brand A", "Leather, Oud ", "Male", LocalDate.now());
        Product product2 = new Product("Carolina Herrera", "Nice and soft", 60.0, 150, "image_url_2", "Brand B", "Tuberose, Jasmine, Tonka Bean", "Female", LocalDate.now());
        Product product3 = new Product("AMBERY CHERRY", "Perfect Summer Scent", 70.0, 200, "image_url_3", "Brand C", "Cherry, Almond, Cinnamon", "Unisex", LocalDate.now());
        Product product4 = new Product("Tobacco Red Mancera ", "Very Strong", 80.0, 250, "image_url_4", "Brand D", "Tobacco", "Male", LocalDate.now());

        OrderItem orderItem1 = new OrderItem(order1, product1, cart1, 2, 50.0);
        OrderItem orderItem2 = new OrderItem(order2, product2, cart2, 1, 75.0);
        OrderItem orderItem3 = new OrderItem(order3, product3, cart3, 3, 100.0);
        OrderItem orderItem4 = new OrderItem(order4, product4, cart4, 4, 125.0);

        Review review1 = new Review(product1, user1, 4, "Great product!", new Date());
        Review review2 = new Review(product2, user2, 5, "Amazing fragrance!", new Date());
        Review review3 = new Review(product3, user3, 3, "Average scent.", new Date());
        Review review4 = new Review(product4, user4, 5, "Highly recommended!", new Date());

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);



        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);

        reviewRepository.save(review1);
        reviewRepository.save(review2);
        reviewRepository.save(review3);
        reviewRepository.save(review4);





        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);
        orderRepository.save(order4);



        cartRepository.save(cart1);
        cartRepository.save(cart2);
        cartRepository.save(cart3);
        cartRepository.save(cart4);
        orderItemRepository.save(orderItem1);
        orderItemRepository.save(orderItem2);
        orderItemRepository.save(orderItem3);
        orderItemRepository.save(orderItem4);





    }
}
*/
