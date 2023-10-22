package com.example.st03.service;


import com.example.st03.domain.Member;

import java.util.List;

public interface MemberService {
    List<Member> getMembers();

    Member getMember(Long id);

    void insertMember(Long id, String name);

    void updateMember(Long id, String name);

    void deleteMember(Long id);
}
