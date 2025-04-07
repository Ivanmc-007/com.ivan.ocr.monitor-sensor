package com.ivan.ocr.monitor_sensor.config.security;

import ch.qos.logback.core.util.StringUtil;
import com.ivan.ocr.monitor_sensor.persistence.model.AuthorityNameEnum;
import com.ivan.ocr.monitor_sensor.usecasses.dto.AuthUserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    @Value("${spring.security.jwt.secret}")
    private String secret;

    @Value("${spring.security.jwt.expired}")
    private long validityInMilliseconds;

    private final JwtUserDetailsService userDetailsService;

    public String createToken(AuthUserDto user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("authorities", getAuthorities(user.getAuthorities()));

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(user.getLogin())
                .issuedAt(now)
                .expiration(validity)
                .and()
                .signWith(getKey(), Jwts.SIG.HS256)
                .compact();
    }

    public String extractToken(HttpServletRequest request) {
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtil.notNullNorEmpty(authHeader) && authHeader.startsWith("Bearer "))
            return authHeader.substring(7);
        return null;
    }

    public Authentication getAuthentication(String token) {
        final String subject = this.extractClaims(token).getSubject();
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(subject);
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private Claims extractClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKey getKey() {
        byte[] secretBytes = this.secret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(secretBytes);
    }

    private List<String> getAuthorities(List<AuthorityNameEnum> userAuthorities) {
        List<String> result = new ArrayList<>();
        userAuthorities.forEach(authority -> result.add(authority.name()));
        return result;
    }
}
