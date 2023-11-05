package kr.hs.study.demo01.repository;

import kr.hs.study.demo01.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository extends JpaRepository<Member, Long> {
}
