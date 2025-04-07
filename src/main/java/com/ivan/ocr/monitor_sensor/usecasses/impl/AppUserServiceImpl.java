package com.ivan.ocr.monitor_sensor.usecasses.impl;

import com.ivan.ocr.monitor_sensor.persistence.model.AppUser;
import com.ivan.ocr.monitor_sensor.persistence.repository.AppUserRepo;
import com.ivan.ocr.monitor_sensor.usecasses.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepo appUserRepo;

    @Transactional(readOnly = true)
    @Override
    public Optional<AppUser> findByLogin(String login) {
        return appUserRepo.findByLogin(login);
    }
}
