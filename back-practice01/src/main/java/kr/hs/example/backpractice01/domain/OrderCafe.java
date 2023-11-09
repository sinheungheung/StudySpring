package kr.hs.example.backpractice01.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ORDER_CAFE")
@Entity
@Data
public class OrderCafe {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "CAFE_ID")
    private Cafe cafe;

    @Builder(builderMethodName = "createOrderMenu")
    public OrderCafe(Order order, Cafe cafe) {
        this.order = order;
        this.cafe = cafe;
    }

}
