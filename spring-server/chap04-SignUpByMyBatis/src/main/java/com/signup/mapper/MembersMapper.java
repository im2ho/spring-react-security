package com.signup.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.signup.model.Member;

@Mapper
public interface MembersMapper {
	
	//회원가입
	void insertMember(Member member);

	//회원정보 수정
	Optional<Member> findMemberById(Long memberId);
	
	//로그인
	Member loginMember(String username, String password);
}