package com.example.haircuttime.model.dto.product;

import com.example.haircuttime.model.enums.Target;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
public class CreateProductDto {

    @NotNull
    @NotEmpty
    private String productName;

    @NotNull
    @NotEmpty
    private String description;
    @DecimalMax("1000.00")// jaka najwyzsza cena
    @DecimalMin("10.00")// jaka najwyzsza cena
    private BigDecimal price;

    @NotNull
    private Long productDuration;

    @NotNull
    private Target targetCustomer;
}
