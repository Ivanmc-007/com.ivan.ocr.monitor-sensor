package com.ivan.ocr.monitor_sensor.usecasses;

import com.ivan.ocr.monitor_sensor.persistence.model.AppUser;

import java.util.Optional;

public interface AppUserService {

    Optional<AppUser> findByLogin(String login);
}
