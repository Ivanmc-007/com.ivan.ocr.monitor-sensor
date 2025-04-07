package com.ivan.ocr.monitor_sensor.controller;

import com.ivan.ocr.monitor_sensor.config.security.JwtTokenProvider;
import com.ivan.ocr.monitor_sensor.exception.NotAuthenticatedUserException;
import com.ivan.ocr.monitor_sensor.usecasses.AuthService;
import com.ivan.ocr.monitor_sensor.usecasses.dto.AuthRequestDto;
import com.ivan.ocr.monitor_sensor.usecasses.dto.AuthUserDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Validated
@RestController
@RequestMapping("/auth/token")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping
    public ResponseEntity<Map<String, String>> getToken(@Valid @RequestBody AuthRequestDto requestDto) {
        AuthUserDto user = authService.findByLoginAndPassword(requestDto);
        if (user == null) {
            throw new NotAuthenticatedUserException("Wrong email or password");
        }
        Map<String, String> response = new HashMap<>();
        response.put("token_type", "Bearer");
        response.put("access_token", jwtTokenProvider.createToken(user));
        return ResponseEntity.ok(response);
    }
}
