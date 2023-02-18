package com.example.haircuttime.service.product;


import com.example.haircuttime.exception.exceptions.ResourceNotFoundException;


import com.example.haircuttime.model.mapper.ProductMapper;
import com.example.haircuttime.repository.ProductRepository;
import lombok.AllArgsConstructor;

import com.example.haircuttime.model.dto.product.CreateProductDto;
import com.example.haircuttime.model.dto.product.ProductDto;
import com.example.haircuttime.model.entity.Product;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    List<ProductDto> findAll();

    ProductDto save(CreateProductDto createProductDto);

    ResponseEntity<Product> updateProduct(Long id, Product product);

    void deleteProduct(Long id);
}
