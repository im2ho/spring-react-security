package com.apiLogin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

import com.apiLogin.kakao.service.KakaoService;
import com.apiLogin.naver.service.NaverService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {

	private final KakaoService kakaoService;
	private final NaverService naverService;
	
	//@RequestMapping(value="/", method=RequestMethod.GET)
	@GetMapping("/")
	public String login(Model model) {
		model.addAttribute("kakaoUrl", kakaoService.getKakaoLogin());
		model.addAttribute("naverUrl", naverService.getNaverLogin());
		return "index";
	}
	
}
