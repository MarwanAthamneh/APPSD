package com.example.ecommerceplatform.repository;

import com.example.ecommerceplatform.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u JOIN FETCH u.address ORDER BY u.lastName ASC")
    List<User> findAllUsersWithAddressesSortedByLastName();

  Optional<User> findByUsername(String username);

    Optional<User> findUserByEmail(String email);
}
