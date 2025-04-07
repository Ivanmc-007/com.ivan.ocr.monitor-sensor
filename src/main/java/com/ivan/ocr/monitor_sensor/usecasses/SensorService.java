package com.ivan.ocr.monitor_sensor.usecasses;

import com.ivan.ocr.monitor_sensor.persistence.model.Sensor;
import com.ivan.ocr.monitor_sensor.usecasses.dto.SensorFilterDto;
import com.ivan.ocr.monitor_sensor.usecasses.dto.SensorSaveDto;

import java.util.List;

public interface SensorService {
    Sensor saveOrUpdate(SensorSaveDto dto, Long sensorId);

    List<Sensor> findByFilter(SensorFilterDto dto);

    void deleteById(Long sensorId);
}
