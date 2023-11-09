package kr.hs.example.backpractice01.repository;

import kr.hs.example.backpractice01.domain.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CafeRepository extends JpaRepository<Cafe, Long> {
    Optional<Cafe> findByName(String name);
}
