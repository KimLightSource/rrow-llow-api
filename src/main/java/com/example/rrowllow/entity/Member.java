package com.example.rrowllow.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 25, nullable = false)
    @NotEmpty
    private String userid;

    @Column(length = 25, nullable = false)
    @NotEmpty
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Column
    private String nickname;

    @Column
    private String email;

    @Column
    private String Address;

}
