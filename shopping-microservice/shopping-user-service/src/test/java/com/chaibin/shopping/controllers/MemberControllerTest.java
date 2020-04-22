package com.chaibin.shopping.controllers;

import com.chaibin.shopping.common.StaticMember;
import com.chaibin.shopping.controllers.core.member.MemberResponse;
import com.chaibin.shopping.model.Member;
import com.chaibin.shopping.services.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest
class MemberControllerTest {

    @Autowired
    MockMvc mvc;

    String version;

    @MockBean
    MemberService memberService;

    @BeforeEach
    public void init() {
        version = "/v1";
    }


    @Test
    @DisplayName("유저 정보 가져오기 테스트")
    void getMemberTest() throws Exception {
        Member member1 = StaticMember.MEMBER1;
        MemberResponse respondedMember = member1.toMemberResponse();
        String url = version + "/members";

        given(memberService.getMember(member1.getUserId())).willReturn(respondedMember);

        mvc.perform(get(url).param("id",member1.getUserId()))
                .andExpect(jsonPath("$.id").value(member1.getUserId()))
                .andExpect(jsonPath("$.name").value(member1.getName()))
                .andExpect(jsonPath("$.address").value(member1.getAddress()))
                .andExpect(jsonPath("$.phone").value(member1.getPhone()));
    }
}