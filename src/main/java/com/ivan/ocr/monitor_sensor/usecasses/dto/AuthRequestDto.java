package com.ivan.ocr.monitor_sensor.usecasses.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequestDto {
    @NotBlank(message = "field is required!")
    private String login;
    @NotBlank(message = "field is required!")
    private String password;
}
