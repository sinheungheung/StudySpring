package kr.hs.example.backpractice01.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.util.Lazy;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ORDER_ITEM")
@Entity
@Data
public class OrderClothes {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "CLOTHES_ID")
    private Clothes clothes;

    @Builder(builderMethodName = "createOrderClothes")
    public OrderClothes(Order order, Clothes clothes){
        this.order = order;
        this.clothes = clothes;
    }
}
