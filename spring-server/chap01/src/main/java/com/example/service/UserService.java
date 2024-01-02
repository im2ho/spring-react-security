package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.respository.UserRepository;
import com.example.vo.Users;

@Service
public class UserService {

	private UserRepository userRepository;
	
	private UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	//메서드
	
	//전체 사용자 조회
	public List<Users> getAllUsers(){
		return userRepository.findAll();
	}
	
	//사용자 조회 by id
	public Users getUserById(Long user_id) {
		return userRepository.findById(user_id).orElse(null);
	}
	
	//새로운 사용자 등록
	public Users saveUser(Users user) {
		return userRepository.save(user);
	}
	
	//사용자 삭제 by id
	public void deleteUserById(Long user_id) {
		userRepository.deleteById(user_id);
	}
}
