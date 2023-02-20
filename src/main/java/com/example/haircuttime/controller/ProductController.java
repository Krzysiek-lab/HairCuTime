package com.example.haircuttime.controller;


import com.example.haircuttime.model.dto.product.CreateProductDto;
import com.example.haircuttime.model.dto.product.ProductDto;
import com.example.haircuttime.service.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    private final ProductService productService;
    


    @PostMapping("/create/products")
    public ProductDto createProduct(@RequestBody @Valid CreateProductDto productDto) {
        return productService.save(productDto);
    }

    @PutMapping("/products/{id}")
    public void updateProduct(@PathVariable("id") Long id, @RequestBody @Valid ProductDto product){
     productService.updateProduct(id, product);
    } 
   


    @GetMapping("/products")
    public List<ProductDto> getAllProducts() {
        return productService.findAll();
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Service was deleted.", HttpStatus.OK);
    }
}
