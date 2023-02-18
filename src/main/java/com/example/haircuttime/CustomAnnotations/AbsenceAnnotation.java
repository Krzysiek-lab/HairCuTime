package com.example.haircuttime.CustomAnnotations;

import com.example.haircuttime.model.dto.absence.CreateAbsenceDto;
import com.example.haircuttime.repository.AbsenceRepository;
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
@Constraint(validatedBy = RangeValidator.class)
public @interface AbsenceAnnotation {

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

@AllArgsConstructor
class RangeValidator implements ConstraintValidator<AbsenceAnnotation, CreateAbsenceDto> {

    private final AbsenceRepository absenceRepository;

    private boolean getAll(CreateAbsenceDto absenceDto) {
        return absenceRepository.findAll().stream().anyMatch(e ->
                e.getAbsenceStart().equals(absenceDto.getAbsenceStart())
                        && e.getAbsenceEnd().equals(absenceDto.getAbsenceEnd())
                        && e.getBarber().getId().equals(absenceDto.getBarberId())
                        && e.getWorkDay().getId().equals(absenceDto.getWorkDayId()));
    }

    @Override
    public void initialize(AbsenceAnnotation date) {
    }

    @Override
    public boolean isValid(CreateAbsenceDto dto, ConstraintValidatorContext constraintValidatorContext) {
        return !getAll(dto);
    }
}
