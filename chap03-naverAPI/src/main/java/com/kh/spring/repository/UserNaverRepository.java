package com.kh.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kh.spring.model.UserNaver;


@Repository
public interface UserNaverRepository extends JpaRepository<UserNaver, String> {

	UserNaver findByName(String name);
}
