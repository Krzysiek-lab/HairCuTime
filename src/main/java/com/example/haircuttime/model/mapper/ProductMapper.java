package com.example.haircuttime.model.mapper;

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
                .serviceDuration(product.getServiceDuration())
                .targetCustomer(product.getTargetCustomer())
                .barbers(product.getBarbers())
                .comments(product.getComments())
                .appointments(product.getAppointments())
                .build();
    }


    public Product mapper(ProductDto productDto) {
        return Product.builder()
                .productName(productDto.getProductName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .serviceDuration(productDto.getServiceDuration())
                .targetCustomer(productDto.getTargetCustomer())
                .barbers(productDto.getBarbers())
                .comments(productDto.getComments())
                .appointments(productDto.getAppointments())
                .build();
    }
}
