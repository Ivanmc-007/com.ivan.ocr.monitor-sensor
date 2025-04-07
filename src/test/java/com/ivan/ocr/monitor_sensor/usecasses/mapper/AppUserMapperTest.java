package com.ivan.ocr.monitor_sensor.usecasses.mapper;

import com.ivan.ocr.monitor_sensor.persistence.model.AppUser;
import com.ivan.ocr.monitor_sensor.usecasses.dto.AuthUserDto;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppUserMapperTest {

    private final AppUserMapper appUserMapper = Mappers.getMapper(AppUserMapper.class);

    @Test
    void shouldMapCorrectlyAllCheckingFieldsWhenInvoke() {
        // Arrange
        AppUser user = new AppUser();
        user.setLogin("John");
        // Act
        AuthUserDto dto = appUserMapper.toAuthUserDto(user);
        // Assert
        assertEquals(dto.getLogin(), user.getLogin());
    }
}
