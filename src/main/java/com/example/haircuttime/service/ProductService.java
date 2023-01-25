package com.example.haircuttime.service;

import com.example.haircuttime.exceptions.ResourceNotFoundException;
import com.example.haircuttime.model.Product;
import com.example.haircuttime.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public ResponseEntity<Product> updateProduct(long id, Product product) {
        Product updateProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id :" + id + " doesn't exist!"));
        updateProduct.setProductName(updateProduct.getProductName());
        updateProduct.setDescription(updateProduct.getDescription());
        updateProduct.setPrice(updateProduct.getPrice());
        updateProduct.setServiceDuration(product.getServiceDuration());

        productRepository.save(updateProduct);
        return ResponseEntity.ok(updateProduct);

    }

    public void deleteProduct(long id) {
        Product deleteProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id :" + id + " doesn't exist!"));
        productRepository.delete(deleteProduct);
    }
}
