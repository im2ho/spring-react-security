package com.example.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.vo.Users;

public interface UserRepository extends JpaRepository <Users, Long>{
//추가적으로 필요한 메서드만 작성
}