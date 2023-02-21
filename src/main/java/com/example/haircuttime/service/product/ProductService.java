package com.example.haircuttime.service.product;


import com.example.haircuttime.model.dto.product.CreateProductDto;
import com.example.haircuttime.model.dto.product.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> findAll();

    ProductDto save(CreateProductDto createProductDto);

    void updateProduct(Long id, ProductDto product);

    void deleteProduct(Long id);
}
