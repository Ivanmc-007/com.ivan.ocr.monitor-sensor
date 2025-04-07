package com.ivan.ocr.monitor_sensor.usecasses.mapper;

import com.ivan.ocr.monitor_sensor.persistence.model.Sensor;
import com.ivan.ocr.monitor_sensor.usecasses.dto.SensorRangeDto;
import com.ivan.ocr.monitor_sensor.usecasses.dto.SensorSaveDto;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SensorMapperTest {

    private final SensorMapper sensorMapper = Mappers.getMapper(SensorMapper.class);

    @Test
    void shouldMapCorrectlyAllCheckingFieldsWhenInvoke() {
        // Arrange
        SensorSaveDto dto = new SensorSaveDto();
        dto.setName("animal");
        dto.setModel("lion");
        SensorRangeDto rangeDto = new SensorRangeDto();
        rangeDto.setFrom(10);
        rangeDto.setTo(100);
        dto.setRange(rangeDto);
        // Act
        Sensor entity = sensorMapper.toSensor(dto);
        // Assert
        assertEquals(dto.getName(), entity.getName());
        assertEquals(dto.getModel(), entity.getModel());
        assertEquals(dto.getRange().getFrom(), entity.getRangeFrom());
        assertEquals(dto.getRange().getTo(), entity.getRangeTo());
    }
}
