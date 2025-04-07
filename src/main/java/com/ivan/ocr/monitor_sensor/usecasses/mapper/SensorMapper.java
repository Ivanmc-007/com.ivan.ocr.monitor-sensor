package com.ivan.ocr.monitor_sensor.usecasses.mapper;

import com.ivan.ocr.monitor_sensor.persistence.model.Sensor;
import com.ivan.ocr.monitor_sensor.usecasses.dto.SensorSaveDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        builder = @Builder(disableBuilder = true))
public abstract class SensorMapper {

    @Mapping(source = "range.from", target = "rangeFrom")
    @Mapping(source = "range.to", target = "rangeTo")
    public abstract Sensor toSensor(SensorSaveDto dto);

}
