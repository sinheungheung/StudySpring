package kr.hs.example.backpractice01.dto.member;

import kr.hs.example.backpractice01.domain.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemRes {
    private Long id;
    private String name;
    private int count;
    private int price;

    @Builder
    public ItemRes(Item item){
        this.id = item.getId();
        this.name = item.getName();
        this.count = item.getCount();
        this.price = item.getPrice();
    }
}
