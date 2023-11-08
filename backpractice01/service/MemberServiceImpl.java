package kr.hs.example.backpractice01.service;

import kr.hs.example.backpractice01.domain.Member;
import kr.hs.example.backpractice01.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Member insertMember(String name) {
        Member newMember = Member.createMember()
                .name(name)
                .build();
        return memberRepository.save(newMember);
    }

    public List<Member> getMembersByName(String memberName) {
        List<Member> members = memberRepository.findByName(memberName);
        return members;
    }

    @Override
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }
}
