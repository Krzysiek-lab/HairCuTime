package com.example.haircuttime.model.mapper;

import com.example.haircuttime.model.dto.product.CreateProductDto;
import com.example.haircuttime.model.dto.product.ProductDto;
import com.example.haircuttime.model.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    public ProductDto toDto(Product product) {
        return ProductDto.builder()
                .productName(product.getProductName())
                .description(product.getDescription())
                .price(product.getPrice())
                .serviceDuration(product.getProductDuration())
                .targetCustomer(product.getTargetCustomer())
                .build();
    }


    public Product toEntity(ProductDto productDto) {
        return Product.builder()
                .productName(productDto.getProductName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .productDuration(productDto.getServiceDuration())
                .targetCustomer(productDto.getTargetCustomer())
                .build();
    }
    public Product toNewEntity(CreateProductDto createProductDto){
        return Product.builder()
                .productName(createProductDto.getProductName())
                .description(createProductDto.getDescription())
                .price(createProductDto.getPrice())
                .productDuration(createProductDto.getProductDuration())
                .targetCustomer(createProductDto.getTargetCustomer())
                .build();
    }
}
