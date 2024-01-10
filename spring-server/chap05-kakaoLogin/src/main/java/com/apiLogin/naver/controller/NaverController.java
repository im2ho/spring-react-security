package com.apiLogin.naver.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apiLogin.common.MsgEntity;
import com.apiLogin.naver.dto.NaverDTO;
import com.apiLogin.naver.service.NaverService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("naver")
public class NaverController {

	//service
	private final NaverService naverService;
	
	@GetMapping("/callback")
	public ResponseEntity<MsgEntity> callback(HttpServletRequest request)throws Exception {
		NaverDTO naverInfo = naverService.getNaverInfo(request.getParameter("code"));
		return ResponseEntity.ok()
				.body(new MsgEntity("Success", naverInfo));
		
	}

}
