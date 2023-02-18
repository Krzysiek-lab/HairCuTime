package com.example.haircuttime.controller;

import com.example.haircuttime.model.dto.product.CreateProductDto;
import com.example.haircuttime.model.dto.product.ProductDto;
import com.example.haircuttime.model.entity.Product;
import com.example.haircuttime.service.product.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
    private final ProductServiceImpl productService;


    @GetMapping("/products")
    public List<ProductDto> getAllProducts() {
        return productService.findAll();
    }

    @PostMapping("/products")
    public ProductDto createService(@RequestBody CreateProductDto createProductDto) {
       return productService.save(createProductDto);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Service was deleted.", HttpStatus.OK);
    }
}
