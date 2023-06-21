package com.example.rrowllow.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
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

    @Column
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column
    private String nickname;

    @Column
    private String email;

    @Column
    private String Address;

}
