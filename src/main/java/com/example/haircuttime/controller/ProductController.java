package com.example.haircuttime.controller;

import com.example.haircuttime.model.dto.product.ProductDto;
import com.example.haircuttime.model.entity.Product;
import com.example.haircuttime.model.mapper.ProductMapper;
import com.example.haircuttime.service.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;


    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @PostMapping("/create/products")
    public void createProduct(@RequestBody @Valid ProductDto product) {
        productService.save(productMapper.mapper(product));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody @Valid ProductDto product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Service was deleted.", HttpStatus.OK);
    }
}
