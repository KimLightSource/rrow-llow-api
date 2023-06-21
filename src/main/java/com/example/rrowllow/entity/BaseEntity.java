package com.example.rrowllow.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
public class BaseEntity {

    @CreatedDate
    private LocalDateTime createDate; //생성일

    @LastModifiedDate
    private LocalDateTime lastModifiedDate; //최근 수정일
    
}
