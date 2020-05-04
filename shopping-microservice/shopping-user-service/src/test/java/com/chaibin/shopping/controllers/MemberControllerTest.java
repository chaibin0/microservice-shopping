package com.chaibin.shopping.controllers;

import com.chaibin.shopping.common.StaticMember;
import com.chaibin.shopping.controllers.core.member.MemberRequest;
import com.chaibin.shopping.controllers.core.member.MemberResponse;
import com.chaibin.shopping.model.Member;
import com.chaibin.shopping.services.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.operation.preprocess.Preprocessors;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = MemberController.class)
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
class MemberControllerTest {

    @Autowired
    MockMvc mvc;

    String version;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    MemberService memberService;

    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext,
                      RestDocumentationContextProvider restDocumentation) {

        this.mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentation))
                .build();
    }

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

        mvc.perform(get(url).param("id", member1.getUserId()))
                .andExpect(jsonPath("$.userId").value(member1.getUserId()))
                .andExpect(jsonPath("$.name").value(member1.getName()))
                .andExpect(jsonPath("$.address").value(member1.getAddress()))
                .andExpect(jsonPath("$.phone").value(member1.getPhone()))
                .andDo(print())
                .andDo(document("get-member",
                        preprocessRequest(prettyPrint()),
                        responseFields(
                                fieldWithPath("userId").description("사용자 아이디"),
                                fieldWithPath("name").description("사용자 이름"),
                                fieldWithPath("address").description("사용자 주소"),
                                fieldWithPath("phone").description("사용자 전화번호")
                        )));
    }

    @Test
    @DisplayName("회원가입 테스트")
    void registerMemberTest() throws Exception {
        MemberRequest memberRequest = StaticMember.MEMBER_REQUEST1;
        Member member = StaticMember.MEMBER1;
        String jsonMember = mapper.writeValueAsString(memberRequest);
        String url = version + "/members";
        given(memberService.registerMember(memberRequest)).willReturn(member);

        mvc.perform(post(url).content(jsonMember).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(print())
                .andDo(document("register-member",
                        preprocessResponse(prettyPrint()),
                        requestFields(
                                fieldWithPath("userId").type("String").description("사용자 아이디"),
                                fieldWithPath("password").type("String").description("사용자 비밀번호"),
                                fieldWithPath("name").type("String").description("사용자 이름"),
                                fieldWithPath("address").type("String").description("사용자 주소"),
                                fieldWithPath("phone").type("String").description("사용자 전화번호")
                        )));
    }

    @Test
    @DisplayName("아이디 중복 검사 테스트")
    void checkMemberTest() throws Exception {
        Member member = StaticMember.MEMBER1;
        String id = member.getUserId();
        String url = version + "/members/check";
        given(memberService.checkMember(id)).willReturn(true);

        mvc.perform(get(url).param("id", id))
                .andExpect(status().isOk())
                .andExpect(content().string("true"))
                .andDo(print())
                .andDo(document("check-member"));
    }
}