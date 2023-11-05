package kr.hs.study.demo01.repository;


import kr.hs.study.demo01.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByName(String name);


}
