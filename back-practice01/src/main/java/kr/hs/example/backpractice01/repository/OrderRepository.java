package kr.hs.example.backpractice01.repository;

import kr.hs.example.backpractice01.domain.Order;
import org.aspectj.weaver.ast.Literal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomerId(Long customerId);
}
