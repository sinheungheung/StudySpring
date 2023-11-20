package kr.hs.example.backpractice01.repository;

import kr.hs.example.backpractice01.domain.Item;
import kr.hs.example.backpractice01.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.naming.Name;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByName(String name);
}
