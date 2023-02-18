package com.example.haircuttime.CustomAnnotations;

import com.example.haircuttime.model.dto.availability.CreateAvailabilityDto;
import com.example.haircuttime.model.mapper.BarberMapper;
import com.example.haircuttime.model.mapper.WorkDayMapper;
import com.example.haircuttime.repository.AvailabilityRepository;
import lombok.AllArgsConstructor;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
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
    private final BarberMapper barberMapper;


    private final WorkDayMapper workDayMapper;
    
    private boolean getAll(CreateAvailabilityDto availabilityDto) {
        return availabilityRepository.findAll().stream().anyMatch(e ->
                e.getStartTime().equals(availabilityDto.getStartTime())
                        && e.getEndTime().equals(availabilityDto.getEndTime())
                        && e.getBarber().equals(barberMapper.toEntity(availabilityDto.getBarber()))
                        && e.getWorkDay().equals(workDayMapper.toEntity(availabilityDto.getWorkDay())));
    }

    @Override
    public void initialize(AvailabilityAnnotation date) {
    }

    @Override
    public boolean isValid(CreateAvailabilityDto dto, ConstraintValidatorContext constraintValidatorContext) {
        return !getAll(dto);
    }
}
