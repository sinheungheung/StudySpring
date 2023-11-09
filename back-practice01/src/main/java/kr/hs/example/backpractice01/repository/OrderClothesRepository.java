package kr.hs.example.backpractice01.repository;

import kr.hs.example.backpractice01.domain.OrderClothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderClothesRepository extends JpaRepository<OrderClothes, Long> {
}
