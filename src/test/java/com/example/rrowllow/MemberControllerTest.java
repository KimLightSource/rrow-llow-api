package com.example.rrowllow;

import com.example.rrowllow.dto.member.MemberRequestDto;
import com.example.rrowllow.entity.UserRole;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
@Import(RestDocsConfiguration.class)
public class MemberControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @WithMockUser
    @Transactional
    public void member_get() throws Exception {

        //given
        String userid = "TestUserId";
        String password = "TestMemberPassword";
        UserRole userRole = UserRole.USER;
        String nickname = "TestMemberNickname";
        String email = "TestMemberEmail@test,com";
        String Address = "TestMemberAddress";

        MemberRequestDto testMember = MemberRequestDto.builder().userid(userid)
                                                      .password(password)
                                                      .nickname(nickname)
                                                      .email(email)
                                                      .address(Address)
                                                      .build();

        // 조회 API -> 대상의 데이터가 있어야 합니다.
        mockMvc.perform(
                       post("/auth/signup")
                               .with(SecurityMockMvcRequestPostProcessors.csrf())
                               .content(objectMapper.writeValueAsString(testMember))
                               .contentType(MediaType.APPLICATION_JSON)
               )
               .andExpect(status().isOk())
               .andDo( // rest docs 문서 작성 시작
                       document("auth/signup", // 문서 조각 디렉토리 명
                               requestFields(
                                       fieldWithPath("userid").description("The user's userid"),
                                       fieldWithPath("password").description("The user's password"),
                                       fieldWithPath("email").description("The user's email address"),
                                       fieldWithPath("nickname").description("The user's nickname"),
                                       fieldWithPath("address").description("The user's address")
                               ),
                               responseFields(
//                                       fieldWithPath("userid").description("The user's userid"),
//                                       fieldWithPath("password").description("The user's password"),
                                       fieldWithPath("email").description("The user's email address"),
                                       fieldWithPath("nickname").description("The user's nickname")
//                                       fieldWithPath("address").description("The user's address")
                                       )
//                               )
                       )
               )
        ;
    }
}
