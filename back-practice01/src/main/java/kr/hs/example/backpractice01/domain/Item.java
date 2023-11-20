package kr.hs.example.backpractice01.domain;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.GenerationType.SEQUENCE;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "ITEM")
public class Item {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "COUNT")
    private int count;

    @Column(name = "PRICE")
    private int price;

    @Builder(builderMethodName = "createItem")
    public Item(String name, int count, int price) {
        this.name = name;
        this.count = count;
        this.price = price;
    }

    public void minusCount(int count) {
        this.count -= count;
    }

    public void updateItem(String name, int count, int price){
        this.name = name;
        this.count = count;
        this.price = price;
    }
}
