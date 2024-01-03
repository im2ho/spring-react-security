package springChap3googleAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import springChap3googleAPI.model.UserGoogle;

public interface MemberRepository extends JpaRepository<UserGoogle, Long> {
    public Optional<UserGoogle> findByUsername(String username);
}