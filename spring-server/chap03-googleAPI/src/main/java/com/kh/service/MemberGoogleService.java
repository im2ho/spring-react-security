package com.kh.service;

import java.util.Optional;

import com.kh.model.MemberGoogle;

public interface MemberGoogleService {

	MemberGoogle findByUsername(String username);
	void saveMember(MemberGoogle user);
}
