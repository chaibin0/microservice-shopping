package com.chaibin.shopping.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @Test
    @DisplayName("맴버 생성 테스트")
    public void generateMemberTest() {
        Member member = Member.builder()
                .id("id")
                .password("password")
                .phone("01000000000")
                .build();

        assertAll(
                ()->assertThat(member.getId()).isEqualTo("id"),
                ()->assertThat(member.getPassword()).isEqualTo("password"),
                ()->assertThat(member.getPhone()).isEqualTo("01000000000")
        );
    }
}