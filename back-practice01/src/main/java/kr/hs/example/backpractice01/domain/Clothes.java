package kr.hs.example.backpractice01.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CLOTHES")
@Entity
@Data
public class Clothes {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "COUNT")
    private int count;

    @Builder(builderMethodName = "createClothes")
    public Clothes(String name, int count){
        this.name = name;
        this.count = count;
    }
    public void minusCount(int minusCount){
        this.count -= minusCount;
    }
}
