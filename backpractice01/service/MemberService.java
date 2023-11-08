package kr.hs.example.backpractice01.service;

import kr.hs.example.backpractice01.domain.Member;

import java.util.List;

public interface MemberService {
    Member insertMember(String name);

    List<Member> getMembers();
}
