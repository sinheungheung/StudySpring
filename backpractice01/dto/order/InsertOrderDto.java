package kr.hs.example.backpractice01.dto.order;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InsertOrderDto {
    private Long memberId;
    private String clothesName;
    private int count;
    private String address;
}
