package kr.hs.example.backpractice01.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.SEQUENCE;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "ORDERS")
public class Orders {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    @Column(name = "COUNT")
    private int count;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Builder(builderMethodName = "createOrder")
    public Orders(int count, Member member) {
        this.count = count;
        this.member = member;
    }
}
