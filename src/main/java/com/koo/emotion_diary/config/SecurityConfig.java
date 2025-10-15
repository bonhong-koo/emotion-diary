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
        .csrf(csrf -> csrf.disable()) // 임시: 폼/POST 테스트 편하게
        .authorizeHttpRequests(auth -> auth
            .anyRequest().permitAll() // 모든 요청 허용
        )
        .formLogin(form -> form.disable()) // 로그인 필터 비활성화
        .httpBasic(basic -> basic.disable()) // 기본 인증 비활성화
        .logout(logout -> logout.disable()); // 로그아웃 비활성화(선택)
    // .authorizeHttpRequests((auth) -> auth
    // // .requestMatchers("/", "/login", "/regist").permitAll() // permitAll() 모든
    // 사용자
    // // 허용
    // // .requestMatchers("/admin").hasRole("ADMIN") // hasRole() -> 해당 권한 사용자만
    // // .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER")
    // // .anyRequest().authenticated()); // anyRequest() -> 위 설정 경로 외 모든 경로,
    // // authenticated() -> 로그인한 사용자
    // .anyRequest().permitAll());

    // // http
    // // .formLogin((auth) -> auth.loginPage("/login") // 로그인 페이지 경로
    // // .loginProcessingUrl("/loginProc") // form action 경로
    // // .permitAll());

    return http.build();
  }

}
