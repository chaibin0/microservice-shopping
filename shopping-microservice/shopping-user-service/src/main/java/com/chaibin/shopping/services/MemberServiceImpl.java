package com.chaibin.shopping.services;

import com.chaibin.shopping.core.member.MemberRequestDto;
import com.chaibin.shopping.core.member.MemberResponseDto;
import com.chaibin.shopping.exceptions.MemberNotFoundException;
import com.chaibin.shopping.models.Member;
import com.chaibin.shopping.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public MemberResponseDto getMember(String id) {

        Member member = memberRepository.findByUserId(id).orElseThrow(() -> new MemberNotFoundException(id));
        return toMemberResponse(member);
    }

    @Override
    public Member registerMember(MemberRequestDto request) {

        Member newMember = Member.builder()
                .userId(request.getUserId())
                .address(request.getAddress())
                .password(request.getPassword())
                .name(request.getName())
                .phone(request.getPhone())
                .build();

        return memberRepository.save(newMember);
    }

    @Override
    public boolean checkMember(String id) {

        return memberRepository.existsByUserId(id);
    }

    public MemberResponseDto toMemberResponse(Member member) {

        MemberResponseDto response = MemberResponseDto.builder()
                .userId(member.getUserId())
                .name(member.getName())
                .phone(member.getPhone())
                .address(member.getAddress())
                .build();
        return response;
    }
}
