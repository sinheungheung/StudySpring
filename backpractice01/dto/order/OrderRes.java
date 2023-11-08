package kr.hs.example.backpractice01.dto.order;

import kr.hs.example.backpractice01.domain.Order;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRes {
    private Long id;
    private int count;
    private String address;

    @Builder
    public OrderRes(Order order) {
        this.id = order.getId();
        this.count = order.getCount();
        this.address = order.getAddress();
    }
}
