package com.example.haircuttime.CustomAnnotations;

import com.example.haircuttime.model.dto.absence.AbsenceDto;
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
class RangeValidator implements ConstraintValidator<AbsenceAnnotation, AbsenceDto> {

    private final AbsenceRepository absenceRepository;

    private boolean getAll(AbsenceDto absenceDto) {
        return absenceRepository.findAll().stream().anyMatch(e ->
                e.getAbsenceStart().equals(absenceDto.getAbsenceStart())
                        && e.getAbsenceEnd().equals(absenceDto.getAbsenceEnd())
                        && e.getBarber().equals(absenceDto.getBarber())
                        && e.getWorkDay().equals(absenceDto.getWorkDay()));
    }


    @Override
    public void initialize(AbsenceAnnotation date) {
    }

    @Override
    public boolean isValid(AbsenceDto dto, ConstraintValidatorContext constraintValidatorContext) {
        return !getAll(dto);
    }
}
