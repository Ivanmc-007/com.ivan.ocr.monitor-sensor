package com.ivan.ocr.monitor_sensor.usecasses.mapper;

import com.ivan.ocr.monitor_sensor.persistence.model.AppUser;
import com.ivan.ocr.monitor_sensor.persistence.model.Authority;
import com.ivan.ocr.monitor_sensor.persistence.model.AuthorityNameEnum;
import com.ivan.ocr.monitor_sensor.usecasses.dto.AuthUserDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        builder = @Builder(disableBuilder = true))
public abstract class AppUserMapper {

    @Mapping(target = "authorities", expression = "java(authoritiesToAuthorityNames(user.getAuthorities()))")
    public abstract AuthUserDto toAuthUserDto(AppUser user);

    public List<AuthorityNameEnum> authoritiesToAuthorityNames(List<Authority> authorities) {
        return Optional.ofNullable(authorities).orElse(new ArrayList<>())
                .stream()
                .map(Authority::getName).collect(Collectors.toList());
    }
}
