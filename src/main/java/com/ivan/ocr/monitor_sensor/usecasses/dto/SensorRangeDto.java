package com.ivan.ocr.monitor_sensor.usecasses.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SensorRangeDto {
    private Integer from;

    @NotNull
    private Integer to;
}
