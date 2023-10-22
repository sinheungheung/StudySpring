package kr.hs.study.StudySpring.member;

public interface MemberRepository {
    void save(Member member);
    Member findByID(Long member);
}
