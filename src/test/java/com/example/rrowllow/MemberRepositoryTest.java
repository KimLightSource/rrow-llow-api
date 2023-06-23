package com.example.rrowllow;

import com.example.rrowllow.entity.Member;
import com.example.rrowllow.entity.UserRole;
import com.example.rrowllow.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(false)
    void testMember() {
        //given
        Member member = new Member(
                1, "jungWook", "1234", UserRole.ADMIN, null, "jungwook@exam.com", null);

        //when
        memberRepository.save(member);

        //then
        assertEquals(memberRepository.findByEmail("jungwook@exam.com"), member);

    }

    @Test
    void findByEmail() {
    }

    @Test
    void findByNickname() {
    }
}
