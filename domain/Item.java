package kr.hs.study.demo01.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ITEM")
@Entity
@Data
public class Item {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "COUNT")
    private int count;

    @Builder(builderMethodName = "createItem")
    public Item(String name, int count){
        this.name = name;
        this.count = count;
    }
    public void minusCount(int minusCount){
        this.count -= minusCount;
    }
}
