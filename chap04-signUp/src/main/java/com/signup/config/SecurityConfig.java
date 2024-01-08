package com.signup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean //객체의 생성, 관리, 주입을 담당
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
			.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
					// "/**" : 모든 리소스에 대해 권한 설정 & .permitAll() : 인증없이 허용
					.requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
			
			//로그인 처리를 따로 하지 않을시 403 오류 가능
			
			//.formLogin() : 로그인 페이지와 기타 로그인 처리 및 성공 실패 처리
			//로그인 후 로그인 세션을 유지하기 위한 설정
			.formLogin((formLogin) -> formLogin
					.loginPage("/members/register") //스프링에서 자체 제공하는 login페이지가 아닌 사용자 커스터 페이지로 사용하겠음
					.defaultSuccessUrl("/")) //인증 성공시 이동할 페이지
			
			//로그아웃 후 로그인 세션을 종료하기 위한 설정
			.logout((logout) -> logout
					.logoutRequestMatcher(new AntPathRequestMatcher("/members/logout"))
					.logoutSuccessUrl("/")
					.invalidateHttpSession(true));	
		
		return http.build();
	}
	
}