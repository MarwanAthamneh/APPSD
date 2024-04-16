package com.example.ecommerceplatform.controller;

import com.example.ecommerceplatform.srevice.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {
    @Autowired
    private  ReviewService reviewService;


}
