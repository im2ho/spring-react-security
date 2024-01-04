package com.kh.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain filterChian(HttpSecurity http) throws Exception {
		
		http
		.authorizeHttpRequests(authorizeHttpRequests ->
									authorizeHttpRequests.requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
		.oauth2Login(oauth2Login -> 
				oauth2Login
					.successHandler(new SimpleUrlAuthenticationSuccessHandler("/loginSuccess")));
		
		return http.build();
	}
	
	//추후 네이버에서 등록한 정보를 저장
	//InMemoryClientRegistrationRepository : 등록 위한 공간
	@Bean
	public ClientRegistrationRepository clientRegistraionRepository() {
		
		//naverClientRegistration() 생성 필요
		return new InMemoryClientRegistrationRepository(naverClientRegistration(), googleClientRegistration()); 
	}
	
	//네이버 클라이언트에 등록 정보를 생성하는 메서드
	//클라이언트 아이디와 시크릿, 인증 후 리다이렉트 URI 설정
	public ClientRegistration naverClientRegistration() {
		//https://developers.naver.com/apps/#/myapps에 적힌 정보 가져오기
		
		return ClientRegistration.withRegistrationId("naver")
				.clientId("K4MWh9YEeN4NAcSjXkvV")
				.clientSecret("8EZqht0eqc")
				//네이버에서 인증 후 OAuth2 엔드포인트 설정
				.redirectUri("http://localhost:8080/login/oauth2/code/naver")
				.clientName("Naver")
				.authorizationUri("https://nid.naver.com/oauth2.0/authorize")
				.tokenUri("https://nid.naver.com/oauth2.0/token")
				.userInfoUri("https://openapi.naver.com/v1/nid/me")
				.userNameAttributeName("response")
				.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
				.build();
	}
	
	//구글 클라이언트 등록 정보를 생성하는 메서드
	public ClientRegistration googleClientRegistration() {
		//https://developers.naver.com/apps/#/myapps에 적힌 정보 가져오기
		
		return ClientRegistration.withRegistrationId("google")
				.clientId("612474417344-nafm9v32lqfi7spdjm4gk4cm3rug4or6.apps.googleusercontent.com")
				.clientSecret("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")
				.redirectUri("http://localhost:8080/login/oauth2/code/naver")
				.clientName("Google")
				.authorizationUri("https://accounts.google.com/o/oauth2/auth")
				.tokenUri("https://www.googleapis.com/oauth2/v4/token")
				.userInfoUri("https://www.googleapis.com.oauth2/v3/userinfo")
				.userNameAttributeName("sub")
				.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
				.scope("openid", "profile", "email")
				.jwkSetUri("https://www.googleapis.com/oauth2/v3/certs")
				.build();
	}
	
	
	
	//인증 통합 관리 매니저
	@Bean
	public OAuth2AuthorizedClientManager authorizedClientManager(
				ClientRegistrationRepository clientRegistrationRepository, 
				OAuth2AuthorizedClientRepository authorizedClientRepository) {
		
		//클라이언트 인증 처리
		OAuth2AuthorizedClientProvider authorizedClientProvider =
					OAuth2AuthorizedClientProviderBuilder.builder()
					.authorizationCode()
					.build();
		
		//클라이언트 등록 정보와 인증된 클라이언트 저장소를 설정
		DefaultOAuth2AuthorizedClientManager authorizedClientManager =
				new DefaultOAuth2AuthorizedClientManager(clientRegistrationRepository, authorizedClientRepository);
		
		authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);
		
		return authorizedClientManager;
	}
	
} //class
