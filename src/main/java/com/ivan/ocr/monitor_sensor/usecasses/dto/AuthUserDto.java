package com.ivan.ocr.monitor_sensor.usecasses.dto;

import com.ivan.ocr.monitor_sensor.persistence.model.AuthorityNameEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuthUserDto {
    private String login;
    private List<AuthorityNameEnum> authorities;
}
