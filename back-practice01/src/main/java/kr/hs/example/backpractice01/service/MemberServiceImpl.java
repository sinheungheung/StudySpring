package kr.hs.example.backpractice01.service;

import kr.hs.example.backpractice01.domain.Member;
import kr.hs.example.backpractice01.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    public List<Member> getMembersByName(String memberName) {
        List<Member> memberByName = memberRepository.findByName(memberName);
        return memberByName;
    }

    public String getMembersByEmail(String memberEmail) {
        Optional<Member> memberByEmail = memberRepository.findByEmail(memberEmail);
        if (!memberByEmail.isEmpty()) {
            throw new IllegalStateException("이메일이 중복입니다.");
        }
        return memberByEmail.toString();
    }

    public List<Member> getMembersByPassword(String memberPassword) {
        List<Member> memberByPassword = memberRepository.findByPassword(memberPassword);
        return memberByPassword;
    }

    @Override
    public Member loginMember(String email, String password) {
        Optional<Member> findMember = memberRepository.findByEmail(email);

        if (findMember.isEmpty()) {
            throw new IllegalStateException("등록된 계정이 없습니다.");
        }

        String encodedPassword = findMember.get().getPassword();
        if (!passwordEncoder.matches(password, encodedPassword)) {
            throw new IllegalStateException("비밀번호가 틀렸습니다");
        }

        return findMember.get();
    }

    @Override
    @Transactional
    public Member insertMember(String name, String email, String password) {
        getMembersByEmail(email);

        String encodedPassword = passwordEncoder.encode(password);

        Member newMemberByName = Member
                .createMember()
                .name(name)
                .email(email)
                .password(encodedPassword)
                .build();

        return memberRepository.save(newMemberByName);
    }

    @Override
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }
}
