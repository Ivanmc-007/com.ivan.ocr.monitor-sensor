package com.ivan.ocr.monitor_sensor.usecasses.impl;


import com.ivan.ocr.monitor_sensor.config.BeanName;
import com.ivan.ocr.monitor_sensor.persistence.model.AppUser;
import com.ivan.ocr.monitor_sensor.usecasses.AppUserService;
import com.ivan.ocr.monitor_sensor.usecasses.AuthService;
import com.ivan.ocr.monitor_sensor.usecasses.dto.AuthRequestDto;
import com.ivan.ocr.monitor_sensor.usecasses.dto.AuthUserDto;
import com.ivan.ocr.monitor_sensor.usecasses.mapper.AppUserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AppUserService appUserService;

    private final AppUserMapper appUserMapper;

    @Qualifier(BeanName.B_CRYPT_PASSWORD_ENCODER)
    private final PasswordEncoder passwordEncoder;
    @Override
    public AuthUserDto findByLoginAndPassword(AuthRequestDto requestDto) {
        Optional<AppUser> o = appUserService.findByLogin(requestDto.getLogin());
        if (o.isPresent() && passwordEncoder.matches(requestDto.getPassword(), o.get().getPassword())) {
            AuthUserDto authUserDto = appUserMapper.toAuthUserDto(o.get());
            log.info("User with login: {} successfully authenticated", requestDto.getLogin());
            return authUserDto;
        }
        log.info("IN findByLoginAndPassword - Invalid login or password");
        return null;
    }
}
