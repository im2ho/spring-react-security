package com.kh.spring.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.spring.model.UserNaver;
import com.kh.spring.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String loginPage() {
		return "index";
	}
	
	//구글 로그인을 위한 url
	@GetMapping("/oauth2/authorization/google")
	public String googleLogin() {
		return "redirect:/oauth2/authorization/google";
	}
	
	@GetMapping("/loginSuccess")
	public String loginSuccess(@AuthenticationPrincipal OAuth2User principal, Model model) {
		System.out.println("OAuth2User Attributes : " + principal.getAttributes());
		
		UserNaver user = userService.findByName(principal.getAttribute("email"));
		
		user.setName(principal.getAttribute("name"));
		user.setEmail(principal.getAttribute("email"));
		userService.saveUser(user);
		
		model.addAttribute("name", principal.getAttribute("name"));
		model.addAttribute("email", principal.getAttribute("email"));
		
		
		return "loginSuccess";
	}
}
