package com.chaibin.shopping.services;

import com.chaibin.shopping.core.member.MemberRequestDto;
import com.chaibin.shopping.core.member.MemberResponseDto;
import com.chaibin.shopping.models.Member;

public interface MemberService {

    MemberResponseDto getMember(String id);

    Member registerMember(MemberRequestDto request);

    boolean checkMember(String id);
}
