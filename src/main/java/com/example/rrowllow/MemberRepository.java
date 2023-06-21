package com.example.rrowllow;

import com.example.rrowllow.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByUserid(String id);
    Member findByEmail(String email);
    Member findByNickname(String nickname);
}
