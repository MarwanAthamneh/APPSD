package com.example.ecommerceplatform.srevice;

import com.example.ecommerceplatform.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private ProductRepository productRepository ;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
