package com.example.haircuttime.CustomAnnotations;

import com.example.haircuttime.model.dto.availability.CreateAvailabilityDto;
import com.example.haircuttime.repository.AvailabilityRepository;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import lombok.AllArgsConstructor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RangeValidator2.class)
public @interface AvailabilityAnnotation {

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

@AllArgsConstructor
class RangeValidator2 implements ConstraintValidator<AvailabilityAnnotation, CreateAvailabilityDto> {

    private final AvailabilityRepository availabilityRepository;

    private boolean getAll(CreateAvailabilityDto availabilityDto) {
        return availabilityRepository.findAll().stream().anyMatch(e ->
                e.getStartTime().equals(availabilityDto.getStartTime())
                        && e.getEndTime().equals(availabilityDto.getEndTime())
                        && e.getBarber() != null
                        && e.getBarber().getId().equals(availabilityDto.getBarberId())
                        && e.getWorkDay() != null
                        && e.getWorkDay().getId().equals(availabilityDto.getWorkDayId()));
    }

    @Override
    public void initialize(AvailabilityAnnotation date) {
    }

    @Override
    public boolean isValid(CreateAvailabilityDto dto, ConstraintValidatorContext constraintValidatorContext) {
        return !getAll(dto);
    }
}
