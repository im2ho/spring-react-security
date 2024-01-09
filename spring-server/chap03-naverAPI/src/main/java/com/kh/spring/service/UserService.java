package com.kh.spring.service;

import com.kh.spring.model.UserNaver;

public interface UserService {

	UserNaver findByName(String name);
	void saveUser(UserNaver user);
}
