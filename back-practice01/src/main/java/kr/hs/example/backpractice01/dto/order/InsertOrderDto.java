package kr.hs.example.backpractice01.dto.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsertOrderDto {
    private Long itemId;
    private Long memberId;
    private int count;
}
