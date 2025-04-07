package com.ivan.ocr.monitor_sensor.usecasses;

import com.ivan.ocr.monitor_sensor.usecasses.dto.AuthRequestDto;
import com.ivan.ocr.monitor_sensor.usecasses.dto.AuthUserDto;

public interface AuthService {
    AuthUserDto findByLoginAndPassword(AuthRequestDto requestDto);
}
