package com.ivan.ocr.monitor_sensor.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "sensor")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensor_id")
    private Long sensorId;

    @Column(name = "name")
    private String name;

    @Column(name = "model")
    private String model;

    @Column(name = "range_from")
    private Integer rangeFrom;

    @Column(name = "range_to")
    private Integer rangeTo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sensor_type_id", referencedColumnName = "sensor_type_id")
    private SensorType sensorType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sensor_unit_id", referencedColumnName = "sensor_unit_id")
    private SensorUnit sensorUnit;

    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String description;
}
