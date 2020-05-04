package com.chaibin.shopping.services;

import com.chaibin.shopping.controllers.core.member.MemberRequest;
import com.chaibin.shopping.controllers.core.member.MemberResponse;
import com.chaibin.shopping.model.Member;

public interface MemberService {

    MemberResponse getMember(String id);

    Member registerMember(MemberRequest request);

    boolean checkMember(String id);
}
