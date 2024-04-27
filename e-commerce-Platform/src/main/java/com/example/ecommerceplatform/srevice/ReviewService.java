package com.example.ecommerceplatform.srevice;

import com.example.ecommerceplatform.model.Product;
import com.example.ecommerceplatform.model.Review;
import com.example.ecommerceplatform.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    public Optional<Review> findById(Long reviewId) {
        return reviewRepository.findById(reviewId);
    }

    public void deleteById(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
