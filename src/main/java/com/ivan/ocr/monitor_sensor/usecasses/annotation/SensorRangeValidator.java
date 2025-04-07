package com.ivan.ocr.monitor_sensor.usecasses.annotation;

import com.ivan.ocr.monitor_sensor.usecasses.dto.SensorRangeDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SensorRangeValidator implements ConstraintValidator<SensorRangeValidation, SensorRangeDto> {

    @Override
    public void initialize(SensorRangeValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(SensorRangeDto value, ConstraintValidatorContext context) {
        if (value != null && value.getFrom() != null && value.getTo() != null) {
            return value.getFrom() < value.getTo();
        }
        return true;
    }
}
