package com.ivan.ocr.monitor_sensor.controller;

import com.ivan.ocr.monitor_sensor.persistence.model.Sensor;
import com.ivan.ocr.monitor_sensor.usecasses.SensorService;
import com.ivan.ocr.monitor_sensor.usecasses.dto.SensorFilterDto;
import com.ivan.ocr.monitor_sensor.usecasses.dto.SensorSaveDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("/sensor")
@RequiredArgsConstructor
public class SensorController {

    private final SensorService sensorService;

    @PostMapping
    public ResponseEntity<Sensor> save(@Valid @RequestBody SensorSaveDto dto) {
        log.debug("Input data save sensor, dto: {}", dto);
        Sensor response = sensorService.saveOrUpdate(dto, null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{sensorId}")
    public ResponseEntity<Sensor> update(@Valid @RequestBody SensorSaveDto dto, @PathVariable Long sensorId) {
        log.debug("Input data update sensor, dto: {}, sensorId: {}", dto, sensorId);
        Sensor response = sensorService.saveOrUpdate(dto, sensorId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Sensor>> findByFilter(@ParameterObject SensorFilterDto dto) {
        log.debug("Input data get sensors by filter, dto: {}", dto);
        List<Sensor> sensors = sensorService.findByFilter(dto);
        return new ResponseEntity<>(sensors, HttpStatus.OK);
    }

    @DeleteMapping("/{sensorId}")
    public ResponseEntity<?> deleteById(@PathVariable Long sensorId) {
        log.debug("Input data delete sensor by sensorId: {}", sensorId);
        sensorService.deleteById(sensorId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
