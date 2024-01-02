package com.kh.springChap01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springChap01.model.User;

public interface UserRepository extends JpaRepository <User, Long> {

}
