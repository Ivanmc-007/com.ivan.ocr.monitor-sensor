package com.ivan.ocr.monitor_sensor.usecasses.impl;

import com.ivan.ocr.monitor_sensor.exception.SensorNotFoundException;
import com.ivan.ocr.monitor_sensor.exception.SensorTypeNotFoundException;
import com.ivan.ocr.monitor_sensor.exception.SensorUnitNotFoundException;
import com.ivan.ocr.monitor_sensor.persistence.model.Sensor;
import com.ivan.ocr.monitor_sensor.persistence.model.SensorType;
import com.ivan.ocr.monitor_sensor.persistence.model.SensorUnit;
import com.ivan.ocr.monitor_sensor.persistence.repository.SensorRepo;
import com.ivan.ocr.monitor_sensor.persistence.repository.SensorTypeRepo;
import com.ivan.ocr.monitor_sensor.persistence.repository.SensorUnitRepo;
import com.ivan.ocr.monitor_sensor.usecasses.SensorService;
import com.ivan.ocr.monitor_sensor.usecasses.dto.SensorFilterDto;
import com.ivan.ocr.monitor_sensor.usecasses.dto.SensorSaveDto;
import com.ivan.ocr.monitor_sensor.usecasses.mapper.SensorMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SensorServiceImpl implements SensorService {

    private final SensorMapper sensorMapper;
    private final SensorTypeRepo sensorTypeRepo;
    private final SensorUnitRepo sensorUnitRepo;
    private final SensorRepo sensorRepo;

    @Transactional(rollbackFor = Exception.class)
    public Sensor saveOrUpdate(SensorSaveDto dto, Long sensorId) {
        if (sensorId != null) {
            Optional<Sensor> o = sensorRepo.findById(sensorId);
            if (o.isEmpty()) {
                log.error("Не удалось найти Sensor с sensorId: " + sensorId);
                throw new SensorNotFoundException("Не удалось найти Sensor с sensorId: " + sensorId);
            }
        }
        Sensor sensor = sensorMapper.toSensor(dto);
        if (dto.getSensorTypeId() != null) {
            SensorType sensorType = sensorTypeRepo.findById(dto.getSensorTypeId()).orElseThrow(() -> {
                log.error("Не удалось сопоставить sensorTypeId: " + dto.getSensorTypeId());
                return new SensorTypeNotFoundException("Не удалось сопоставить sensorTypeId: " + dto.getSensorTypeId());
            });
            sensor.setSensorType(sensorType);
        }
        if (dto.getSensorUnitId() != null) {
            SensorUnit sensorUnit = sensorUnitRepo.findById(dto.getSensorUnitId()).orElseThrow(() -> {
                log.error("Не удалось сопоставить sensorUnitId: " + dto.getSensorUnitId());
                return new SensorUnitNotFoundException("Не удалось сопоставить sensorUnitId: " + dto.getSensorUnitId());
            });
            sensor.setSensorUnit(sensorUnit);
        }
        sensor.setSensorId(sensorId);
        return sensorRepo.save(sensor);
    }

    @Transactional(readOnly = true)
    public List<Sensor> findByFilter(SensorFilterDto dto) {
        return sensorRepo.searchByNameIsLikeIgnoreCaseAndModelIsLikeIgnoreCase(dto.getName(), dto.getModel());
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long sensorId) {
        sensorRepo.deleteById(sensorId);
    }
}
