package com.example.rrowllow.dto.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordRequestDto {
    private String userId;
    private String exPassword;
    private String newPassword;
}
