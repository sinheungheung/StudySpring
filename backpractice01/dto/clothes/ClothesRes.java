package kr.hs.example.backpractice01.dto.clothes;


import kr.hs.example.backpractice01.domain.Clothes;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Setter
@Getter
public class ClothesRes {
    private Long id;
    private String name;
    private int count;

    @Builder
    public ClothesRes(Clothes clothes){
        this.id = clothes.getId();
        this.name = clothes.getName();
        this.count = clothes.getCount();
    }
}
