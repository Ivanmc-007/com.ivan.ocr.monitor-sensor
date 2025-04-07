package com.ivan.ocr.monitor_sensor.config.security;

import com.ivan.ocr.monitor_sensor.persistence.model.AppUser;
import com.ivan.ocr.monitor_sensor.persistence.model.Authority;
import com.ivan.ocr.monitor_sensor.usecasses.AppUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final AppUserService appUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = appUserService.findByLogin(username).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }
        return new JwtUserDetails(username, user.getPassword(), getGrantedAuthorities(user.getAuthorities()));
    }

    private Collection<? extends GrantedAuthority> getGrantedAuthorities(List<Authority> authorities) {
        return Optional.ofNullable(authorities).orElse(new ArrayList<>())
                .stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName().name())).collect(Collectors.toList());
    }
}
