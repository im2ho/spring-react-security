package com.kh.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	//회원가입이나 로그인을 할 때 들어갈 수 있는 코드가 존재한다면 입장 허용 (코드가 없을 경우 입장 불가)
	public void socialLogin(String code, String registrationId) {
		System.out.println("code : " + code);
		System.out.println("regist ID : " + registrationId);
	}
}
