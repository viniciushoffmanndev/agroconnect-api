package com.viniciushoffmanndev.agroconnect_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/usuarios").permitAll()           // ✅ LIBERA POST /usuarios
                        .requestMatchers("/h2-console/**").permitAll()      // ✅ LIBERA o console H2
                        .anyRequest().authenticated()                       // 🔒 Protege o resto
                )
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**", "/usuarios")  // ✅ Evita erro CSRF no POST
                )
                .headers(headers -> headers.frameOptions().disable()); // ✅ Libera visualização H2

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

