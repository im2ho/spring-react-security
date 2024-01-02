package com.kh.springChap01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.springChap01.model.User;
import com.kh.springChap01.repository.UserRepository;

//api로 전달해서 호출
@RestController
@RequestMapping("/api/user")
//cors : 쿠키나 세션 무언가 접속하는 것을 허용해줄 때 사용
/*allowCredentials : 
		브라우저에서 요청에 대한 응답을 할 때, 요청에 인증 정보(쿠키, HTTP 인증) 포함 여부를 나타냄
		> true : 인증정보를 포함한 요청을 서버로 전송할 수 있게 해줌 (인증정보를 서로 주고받을 수 있다) */
@CrossOrigin(origins="http://localhost:3000", allowCredentials="true")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	/*
	
		@PostMapping : 
			클라이언트(사용자)가 html에 작성한 정보를 DB에 저장할 수 있도록 도와주는 어노테이션
		
		ResponseEntity :
			응답을 나타내는 클래스
			404, 400, 500 이외에 200이라는 응답은 성공적으로 데이터를 전송했다는 의미
			ResponseEntity.ok 라는 것은 데이터를 잘 전송했다는 뜻이기 때문에 ok가 200이라는 내용을 담고있음
	
	*/
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User newUser){
		User createdUser = userRepository.save(newUser);
		return ResponseEntity.ok(createdUser);
	}
}
