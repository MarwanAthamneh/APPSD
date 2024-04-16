package com.example.ecommerceplatform.repository;

import com.example.ecommerceplatform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u JOIN FETCH u.address ORDER BY u.lastName ASC")
    List<User> findAllUsersWithAddressesSortedByLastName();
}
