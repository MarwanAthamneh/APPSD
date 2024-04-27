package com.example.ecommerceplatform.srevice;

import com.example.ecommerceplatform.model.Product;
import com.example.ecommerceplatform.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository ;

@Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void deleteById(Long productId) {
        productRepository.deleteById(productId);
    }

    public Product save(Product product) {
    return productRepository.save(product);
    }

    public List<Product> findAll() {
    return productRepository.findAll();
    }

    public Optional<Product> findById(Long productId) {
    return productRepository.findById(productId);
    }
}
