package com.hanghae.demo.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	http
        .authorizeRequests(authorizeRequests ->
            authorizeRequests
                .anyRequest().permitAll() // 모든 요청 허용
        )
        .csrf(csrf -> csrf.disable()) // CSRF 보호 비활성화
        .headers(headers -> headers.frameOptions().sameOrigin()); // iframe 허용

    return http.build();
    }
}
