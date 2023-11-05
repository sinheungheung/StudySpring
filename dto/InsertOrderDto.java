package kr.hs.study.demo01.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsertOrderDto {
    private Long memberId;
    private String itemName;
    private int count;
    private String address;
}
