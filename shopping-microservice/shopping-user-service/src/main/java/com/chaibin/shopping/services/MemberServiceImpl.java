package com.chaibin.shopping.services;

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

        Member member = memberRepository.findById(id).orElseThrow(() -> new MemberNotFoundException(id));
        return member.toMemberResponse();
    }
}
