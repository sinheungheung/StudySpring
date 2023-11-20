package kr.hs.example.backpractice01.dto.member;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InsertItemDto {
    private String name;
    private int count;
    private int price;
}
