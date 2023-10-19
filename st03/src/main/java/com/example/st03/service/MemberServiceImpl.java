package com.example.st03.service;

import com.example.st03.domain.Member;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final List<Member> members = new ArrayList<>();

    @Override
    public List<Member> getMembers() {
        List<Member> list = members;
        return list;
    }

    @Override
    public Member getMember(Long id) {
        Member m1 = new Member();

        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId() == id) {
                m1 = members.get(i);
            }
        }

        return m1;
    }

    @Override
    public void insertMember(Long id, String name) {
        Member newMember = new Member(id, name);

        members.add(newMember);
    }

    @Override
    public void updateMember(Long id, String name) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId() == id) {
                members.get(i).setName(name);
            }
        }
    }

    @Override
    public void deleteMember(Long id) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId() == id) {
                members.remove(members.get(i));
            }
        }
    }

    public List<Member> memberDb() {
        List<Member> list = new ArrayList<>();

        Member m1 = new Member(1L, "이종호");
        list.add(m1);
        return list;
    }
}
