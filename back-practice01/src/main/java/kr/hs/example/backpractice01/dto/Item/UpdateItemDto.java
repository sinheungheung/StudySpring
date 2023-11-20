package kr.hs.example.backpractice01.dto.Item;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateItemDto {
    private String name;
    private int count;
    private int price;
}
