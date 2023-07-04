package com.example.rrowllow.dto.member;

import com.example.rrowllow.entity.Member;
import com.example.rrowllow.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberRequestDto {
    private String userid;
    private String email;
    private String password;
    private String nickname;
    private String address;


    public Member toMember(PasswordEncoder passwordEncoder) {
        return Member.builder()
                     .userid(userid)
                     .password(passwordEncoder.encode(password))
                     .userRole(UserRole.USER)
                     .nickname(nickname)
                     .email(email)
                     .Address(address)
                     .build();
    }

    //아이디와 비밀번호 일치 검증
    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(userid, password);
    }
}
