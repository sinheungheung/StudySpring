package kr.hs.example.backpractice01.dto;

import kr.hs.example.backpractice01.domain.Order;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderReq {
    private Long id;
    private String memberName;
    private String address;

    @Builder
    public OrderReq(Order order) {
        this.id = order.getId();
        this.memberName = order.getMember().getName();
        this.address = order.getAddress();
    }
}
