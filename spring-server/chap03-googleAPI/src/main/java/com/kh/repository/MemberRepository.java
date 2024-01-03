package com.kh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

	//추가적으로 필요한 메서드 작성
}
