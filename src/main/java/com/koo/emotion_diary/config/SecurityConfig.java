package com.koo.emotion_diary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  SecurityFilterChain security(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests((auth) -> auth
            .requestMatchers("/", "/login", "/regist").permitAll() // permitAll() 모든 사용자 허용
            .requestMatchers("/admin").hasRole("ADMIN") // hasRole() -> 해당 권한 사용자만
            .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER")
            .anyRequest().authenticated()); // anyRequest() -> 위 설정 경로 외 모든 경로, authenticated() -> 로그인한 사용자

    http
        .formLogin((auth) -> auth.loginPage("/login") // 로그인 페이지 경로
            .loginProcessingUrl("/loginProc") // form action 경로
            .permitAll());

    http
        .csrf((auth) -> auth.disable());

    return http.build();
  }

}
