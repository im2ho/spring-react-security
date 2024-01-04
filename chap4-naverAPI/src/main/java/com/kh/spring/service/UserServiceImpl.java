package com.kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.model.UserNaver;
import com.kh.spring.repository.UserNaverRepository;

@Service
public class UserServiceImpl {

	private final UserNaverRepository userNaverRepository;
	
	@Autowired
	public UserServiceImpl(UserNaverRepository userNaverRepository) {
		this.userNaverRepository = userNaverRepository;
	}
	
	
	public UserNaver findByName(String name) {
		return userNaverRepository.findByName(name);
	}
	
	
	public void saveUser(UserNaver user) {
		userNaverRepository.save(user);
	}
}
