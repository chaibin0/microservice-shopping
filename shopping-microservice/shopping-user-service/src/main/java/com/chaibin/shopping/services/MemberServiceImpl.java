package com.chaibin.shopping.services;

import com.chaibin.shopping.controllers.core.member.MemberRequest;
import com.chaibin.shopping.controllers.core.member.MemberResponse;
import com.chaibin.shopping.exceptions.MemberNotFoundException;
import com.chaibin.shopping.model.Member;
import com.chaibin.shopping.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public MemberResponse getMember(String id) {

        Member member = memberRepository.findByUserId(id).orElseThrow(() -> new MemberNotFoundException(id));
        return member.toMemberResponse();
    }

    @Override
    public Member registerMember(MemberRequest request) {

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
}
