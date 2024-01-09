package com.kh.spring.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kh.spring.model.UserNaver;
import com.kh.spring.repository.UserRepository;



@Service
public class UserDetailServiceImpl {

	@Autowired
	private UserRepository userRepository;
	
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        UserNaver user = userRepository.findByName(name)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + name));

        return new org.springframework.security.core.userdetails.User(
                user.getName(),
                "",
                Collections.emptyList());
    }
}
