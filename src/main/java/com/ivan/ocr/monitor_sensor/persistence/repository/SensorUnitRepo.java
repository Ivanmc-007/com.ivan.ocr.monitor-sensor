package com.ivan.ocr.monitor_sensor.persistence.repository;

import com.ivan.ocr.monitor_sensor.persistence.model.SensorUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorUnitRepo extends JpaRepository<SensorUnit, Long> {
}
