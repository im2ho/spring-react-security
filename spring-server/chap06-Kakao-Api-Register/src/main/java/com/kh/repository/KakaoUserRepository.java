package com.kh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.model.KakaoUser;

public interface KakaoUserRepository extends JpaRepository<KakaoUser, Long> {

}
