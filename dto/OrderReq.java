package com.example.hh.demo01.dto;

import com.example.hh.demo01.domain.Order;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

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
