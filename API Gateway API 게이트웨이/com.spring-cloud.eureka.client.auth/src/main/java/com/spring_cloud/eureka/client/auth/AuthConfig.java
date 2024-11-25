package com.spring_cloud.eureka.client.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AuthConfig {

    /*
    SecurityFilterChain : Spring Security 의 보안 필터 체인 설정
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                /*
                CSRF 보호를 비활성화
                 */
                .csrf(AbstractHttpConfigurer::disable)
                /*
                요청에 대한 접근 권한 설정
                /auth/signIn 에 대한 접근은 인증 없이 접근, 그 외의 모든 요청은 인증이 필요하도록 설정
                 */
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/auth/signIn").permitAll()
                        .anyRequest().authenticated()
                )
                /*
                세션 관리 정책 정의 : 세션을 사용하지 않도록 설정
                 */
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        return http.build();
    }
}
