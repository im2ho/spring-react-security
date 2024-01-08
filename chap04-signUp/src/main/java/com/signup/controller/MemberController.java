package com.signup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.signup.model.Member;
import com.signup.service.MemberService;

@Controller
@RequestMapping("/members")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	//회원가입
	@GetMapping("register")
	public String showRegisterForm(Model model) {
		model.addAttribute("member", new Member());
		return "register";
	}
	
	@PostMapping("register/new")
	public String registerMember(Member member) {
		memberService.signUpMember(member);
		return "redirect:../../"; //main으로 이동
	}
	
	
	
	//회원정보 수정
	
	//로그인

}