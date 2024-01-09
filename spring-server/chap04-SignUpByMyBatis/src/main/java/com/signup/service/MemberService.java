package com.signup.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signup.mapper.MembersMapper;
import com.signup.model.Member;

@Service
public class MemberService {
	@Autowired
	private MembersMapper membersMapper;
	
	//회원가입
	public void signUpMember(Member member) {
		membersMapper.insertMember(member);
	}

	//정보수정
	public Optional<Member> getMemberById(Long memberId) {
		return membersMapper.findMemberById(memberId);
	}
	
	//로그인
	public Member loginMember(String username, String password) {
		return membersMapper.loginMember(username, password);
	}
}