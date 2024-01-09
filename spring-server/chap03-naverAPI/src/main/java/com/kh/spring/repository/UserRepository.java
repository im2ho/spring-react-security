package com.kh.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kh.spring.model.UserNaver;

@Repository
public interface UserRepository extends JpaRepository<UserNaver, String> {

	Optional<UserNaver> findByName(String name);
}
