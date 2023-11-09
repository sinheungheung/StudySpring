package kr.hs.example.backpractice01.dto.clothes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsertClothesDto {
    private Long id;
    private String name;
    private int count;
}
