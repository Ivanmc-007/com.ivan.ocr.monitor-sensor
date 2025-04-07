package com.ivan.ocr.monitor_sensor.persistence.repository;

import com.ivan.ocr.monitor_sensor.persistence.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepo extends JpaRepository<Sensor, Long> {

    @Query("""
            SELECT s
            FROM Sensor s
            WHERE (UPPER(s.name) LIKE UPPER(CONCAT('%', :name, '%')) OR :name IS NULL)
            AND (UPPER(s.model) LIKE UPPER(CONCAT('%', :model, '%')) OR :model IS NULL)
            """)
    List<Sensor> searchByNameIsLikeIgnoreCaseAndModelIsLikeIgnoreCase(@Param("name") String name, @Param("model") String model);
}
