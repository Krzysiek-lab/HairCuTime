package com.example.haircuttime.model.dto.comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    private Long id;
    @NotBlank(message = "Content is mandatory")
    private String content;
    @Size(min = 1, max = 5, message = "Please input value from 1 to 5")
    @NotBlank(message = "Grade is mandatory")
    private Long grade;
    // private List<ServiceDto> serviceDtos;
}
