package kr.hs.study.demo01.service;

import kr.hs.study.demo01.domain.Member;
import kr.hs.study.demo01.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements  MemberService{
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Member insertMember(String name){
        Member newMember = Member.createMember()
                .name(name)
                .build();
        return memberRepository.save(newMember);
    }
}