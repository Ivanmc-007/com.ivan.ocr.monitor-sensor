package com.ivan.ocr.monitor_sensor.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "sensor_type")
public class SensorType {

    @Id
    @Column(name = "sensor_type_id")
    private Long sensorTypeId;

    @Column(name = "name")
    private String name;
}
