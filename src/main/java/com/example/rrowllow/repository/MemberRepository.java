package com.example.rrowllow.repository;

import com.example.rrowllow.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);
    boolean existsByEmail(String email);
    Optional<Member> findByUserid(String userid);
    boolean existsByUserid(String userid);

}
