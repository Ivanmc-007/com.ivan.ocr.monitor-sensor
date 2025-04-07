package com.ivan.ocr.monitor_sensor.persistence.repository;

import com.ivan.ocr.monitor_sensor.persistence.model.SensorType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorTypeRepo extends JpaRepository<SensorType, Long> {
}
