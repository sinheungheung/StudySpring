package kr.hs.study.StudySpring.member;

public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);

}
