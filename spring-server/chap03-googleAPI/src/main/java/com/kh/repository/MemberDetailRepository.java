package com.kh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.model.MemberGoogle;

//인증 용도
public interface MemberDetailRepository extends JpaRepository<MemberGoogle, Long> {

	//추가적으로 필요한 메서드 작성
	Optional<MemberGoogle> findByUsername(String username);
}
