package kr.hs.example.backpractice01.repository;

import kr.hs.example.backpractice01.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByName(String name);

    Optional<Member> findByEmail(String email);

    List<Member> findByPassword(String password);
}
