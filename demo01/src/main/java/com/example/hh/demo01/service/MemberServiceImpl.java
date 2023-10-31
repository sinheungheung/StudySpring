package com.example.hh.demo01.service;

import com.example.hh.demo01.model.Member;
import com.example.hh.demo01.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public List<Member> getMembers() {
        List<Member> all = memberRepository.findAll();
        return all;
    }

    @Override
    public Member getMemberById(Long id) {
        Optional<Member> foundMember = memberRepository.findById(id);
        return foundMember.get();
    }

    @Override
    public List<Member> getMembersByName(String name) {
        List<Member> list = memberRepository.findByName(name);
        return list;
    }

    @Override
    @Transactional
    public Member insertMember(String name, String address, String hobby) {
        Member newMem = new Member();
        newMem.setName(name);
        newMem.setAddress(address);
        newMem.setHobby(hobby);

        Member member = memberRepository.save(newMem);
        return member;
    }
}
