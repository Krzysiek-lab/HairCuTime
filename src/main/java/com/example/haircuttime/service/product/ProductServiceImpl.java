package com.example.haircuttime.service.product;

import com.example.haircuttime.exception.exceptions.ResourceNotFoundException;
import com.example.haircuttime.model.dto.product.CreateProductDto;
import com.example.haircuttime.model.dto.product.ProductDto;
import com.example.haircuttime.model.entity.Product;
import com.example.haircuttime.model.mapper.ProductMapper;
import com.example.haircuttime.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public List<ProductDto> findAll() {
        return productRepository.findAll().stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    public ProductDto save(CreateProductDto createProductDto) {
        return productMapper.toDto(productRepository.save(productMapper.toNewEntity(createProductDto)));
    }

    public void deleteProduct(Long id) {
        Product deleteProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id :" + id + " doesn't exist!"));
        productRepository.delete(deleteProduct);
    }
    public void updateProduct(Long id, ProductDto product) {
        Product updateProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id :" + id + " doesn't exist!"));
        updateProduct.setProductName(updateProduct.getProductName());
        updateProduct.setDescription(updateProduct.getDescription());
        updateProduct.setPrice(updateProduct.getPrice());
        updateProduct.setProductDuration(product.getProductDuration());
    }
}
