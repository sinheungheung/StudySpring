package com.example.hh.demo01.service;

import com.example.hh.demo01.model.Member;

import java.util.List;

public interface MemberService {
    List<Member> getMembers();

    List<Member> getMembersByName(String name);

    Member getMemberById(Long id);

    Member insertMember(String name, String address, String hobby);
}
