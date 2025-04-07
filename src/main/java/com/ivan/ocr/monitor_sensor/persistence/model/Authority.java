package com.ivan.ocr.monitor_sensor.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "authority")
public class Authority {
    @Id
    @Column(name = "authority_id")
    private Long authorityId;

    @Column(name = "name", unique = true)
    @Enumerated(EnumType.STRING)
    private AuthorityNameEnum name;
}
