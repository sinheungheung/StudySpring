package com.example.hh.demo01.repository;

import com.example.hh.demo01.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findById(Long id);
    List<Member> findByName(String name);
    List<Member> findByAddress(String address);
}
