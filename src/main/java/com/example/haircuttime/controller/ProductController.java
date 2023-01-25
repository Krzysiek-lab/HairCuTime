package com.example.haircuttime.controller;

import com.example.haircuttime.model.Product;
import com.example.haircuttime.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor

public class ProductController {
    private final ProductService productService;


    @GetMapping("/products")
    public List<Product> getAllServices() {
        return productService.findAll();
    }

    @PostMapping("/products")
    public void createService(@RequestBody Product product) {
        productService.save(product);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<String>("Service was deleted.", HttpStatus.OK);
    }
}
