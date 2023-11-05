package kr.hs.study.demo01.dto;

import kr.hs.study.demo01.domain.Order;
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
    public OrderReq(Order order){
        this.id = id;
        this.memberName = order.getMember().getName();
        this.address = order.getAddress();
    }
}
