package com.signup.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.signup.model.Member;

@Mapper
public interface MembersMapper {

	//mapper.xml의 insert태그 id와 연결
	void insertMember(Member member);
}
