package com.ivan.ocr.monitor_sensor.usecasses.dto;

import com.ivan.ocr.monitor_sensor.usecasses.annotation.SensorRangeValidation;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SensorSaveDto {
    @NotNull
    @Size(min = 3, max = 30)
    private String name;

    @NotNull
    @Size(max = 15)
    private String model;

    @SensorRangeValidation
    private SensorRangeDto range;
    private String type;

    @NotNull
    private Long sensorTypeId;
    private Long sensorUnitId;
    private String location;
    private String description;
}
