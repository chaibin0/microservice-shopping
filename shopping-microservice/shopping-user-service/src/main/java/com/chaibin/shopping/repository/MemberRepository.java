package com.chaibin.shopping.repository;

import com.chaibin.shopping.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
}
