package com.ivan.ocr.monitor_sensor.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "sensor_unit")
public class SensorUnit {

    @Id
    @Column(name = "sensor_unit_id")
    private Long sensorUnitId;

    @Column(name = "name")
    private String name;
}
