package com.signup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signup.mapper.MembersMapper;
import com.signup.model.Member;

@Service
public class MemberService {

	@Autowired
	private MembersMapper membersMapper;
	
	//회원 정보 저장하기
	public void signUpMember(Member member) {
		membersMapper.insertMember(member);
	}
}
