package com.example.ecommerceplatform.controller;

import com.example.ecommerceplatform.model.OrderItem;
import com.example.ecommerceplatform.model.Product;
import com.example.ecommerceplatform.srevice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adsweb/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("")
    public Product createProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    // Read operation
    @GetMapping("")
    public List<Product> getAllProduct() {
        return productService.findAll();
    }

    // Update operation
    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateOrderItem(@PathVariable Long productId, @RequestBody Product productDetails) {
        Optional<Product> optionalProduct = productService.findById(productId);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();

            productService.save(product);
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete operation
    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId) {
        productService.deleteById(productId);
        return ResponseEntity.ok().build();
    }
}
