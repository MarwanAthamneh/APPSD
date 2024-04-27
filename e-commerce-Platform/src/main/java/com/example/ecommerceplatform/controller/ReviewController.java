package com.example.ecommerceplatform.controller;

import com.example.ecommerceplatform.model.Product;
import com.example.ecommerceplatform.model.Review;
import com.example.ecommerceplatform.srevice.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adsweb/api/v1/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("")
    public Review createReview(@RequestBody Review review) {
        return reviewService.save(review);
    }

    // Read operation
    @GetMapping("")
    public List<Review> getAllReview() {
        return reviewService.findAll();
    }

    // Update operation
    @PutMapping("/{reviewId}")
    public ResponseEntity<Review> updateReview(@PathVariable Long reviewId, @RequestBody Review reviewDetails) {
        Optional<Review> optionalReview = reviewService.findById(reviewId);
        if (optionalReview.isPresent()) {
            Review review = optionalReview.get();

            reviewService.save(review);
            return ResponseEntity.ok(review);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete operation
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<?> deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteById(reviewId);
        return ResponseEntity.ok().build();
    }
}
