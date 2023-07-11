package com.example.rrowllow;

import com.example.rrowllow.entity.Member;
import com.example.rrowllow.entity.UserRole;
import com.example.rrowllow.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    //관리자 계정 생성
    @Test
    @Transactional
    @Rollback(false)
    void testMember() {
        //given

        String encode = passwordEncoder.encode("1234");
        Member member = new Member(
                1,"jungwook", encode, UserRole.ADMIN, null, "jungwook@exam.com", null);

        //when
        memberRepository.save(member);

        //then
//        Assertions.assertEquals(memberRepository.findByEmail("jungwook@exam.com"), member);

    }

    @Test
    void findByEmail() {
    }

    @Test
    void findByNickname() {
    }
}
