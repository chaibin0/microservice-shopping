package com.chaibin.shopping.model;

import com.chaibin.shopping.common.StaticMember;
import com.chaibin.shopping.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("맴버 생성 테스트")
    public void generateMemberTest() {
        Member member = Member.builder()
                .userId("id")
                .password("password")
                .phone("01000000000")
                .address("서울광역시 강남구 강남대로")
                .name("홍길동")
                .build();

        Member newMember = memberRepository.save(member);
        assertAll(
                () -> assertThat(newMember.getUserId()).isEqualTo(member.getUserId()),
                () -> assertThat(newMember.getPassword()).isEqualTo(member.getPassword()),
                () -> assertThat(newMember.getPhone()).isEqualTo(member.getPhone()),
                () -> assertThat(newMember.getAddress()).isEqualTo(member.getAddress()),
                () -> assertThat(newMember.getName()).isEqualTo(member.getName())
        );
    }

    @Test
    @DisplayName("멤버 가져오기 테스트")
    public void getMemberTest() {
        Member member1 = StaticMember.MEMBER1;
        memberRepository.save(member1);

        Member savedMember = memberRepository.findByUserId(member1.getUserId()).orElseGet(null);

        if (savedMember == null) {
            Assertions.fail();
        }

        assertAll(
                () -> assertThat(savedMember.getUserId()).isEqualTo(member1.getUserId()),
                () -> assertThat(savedMember.getPassword()).isEqualTo(member1.getPassword()),
                () -> assertThat(savedMember.getPhone()).isEqualTo(member1.getPhone()),
                () -> assertThat(savedMember.getAddress()).isEqualTo(member1.getAddress()),
                () -> assertThat(savedMember.getName()).isEqualTo(member1.getName())
        );
    }
}