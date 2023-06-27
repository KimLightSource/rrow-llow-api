package com.example.rrowllow.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 25, nullable = false)
    private String userid;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Column
    private String nickname;

    @Column
    private String email;

    @Column
    private String Address;

    public void changeNickname(String nickname) {
        this.nickname = nickname;
    }

    public void changeMemberPassword(String password) {
        this.password = password;
    }
}
