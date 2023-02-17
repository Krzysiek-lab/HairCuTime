package com.example.haircuttime.model.dto.barber;

import com.example.haircuttime.model.dto.workyear.WorkYearDto;
import com.example.haircuttime.model.entity.Product;
import com.example.haircuttime.model.enums.Gender;
import lombok.Builder;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Builder
@Data
public class BarberDto {
    private Long id;
    //    @NotNull
//    @NotEmpty
    private String name;
    //    @NotNull
//    @NotEmpty
    private String surname;
    //    @NotNull
//    @NotEmpty
    @Enumerated(EnumType.STRING)
    private Gender gender;
    //    @NotNull
//    @NotEmpty
    private List<Product> products;
    //    @NotNull
//    @NotEmpty
    private List<WorkYearDto> workYears;

}
