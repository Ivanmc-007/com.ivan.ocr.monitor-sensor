package com.ivan.ocr.monitor_sensor.persistence.repository;

import com.ivan.ocr.monitor_sensor.persistence.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByLogin(String login);
}
