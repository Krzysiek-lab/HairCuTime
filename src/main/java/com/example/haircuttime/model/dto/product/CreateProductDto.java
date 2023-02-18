package com.example.haircuttime.model.dto.product;

import com.example.haircuttime.model.enums.Target;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
public class CreateProductDto {

    private String productName;

    private String description;

    private BigDecimal price;

    private Long productDuration;

    private Target targetCustomer;
}
