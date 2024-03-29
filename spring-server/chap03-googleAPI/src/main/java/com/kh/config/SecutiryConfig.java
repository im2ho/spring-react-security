package com.kh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecutiryConfig {
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
		.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
				//모든 요청에 대해 권한 검사를 하지 않고
				//모든 사용자에게 엔드포인트로 접근할 수 있도록 허용
				.requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
		//다른 포트나 도메인에서 접근할 수 있도록 허용
		//예를 들어 http://localhost:3000 이외 백엔드에서 지정해준 포트 이외 다른 포트도 마찬가지
		.cors(Customizer.withDefaults())
		.csrf((csrf)->csrf.disable());
		
		return http.build();
	}
}
