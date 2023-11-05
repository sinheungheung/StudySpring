package kr.hs.study.demo01.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.EAGER;

@Table(name = "ORDER")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Order {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COUNT")
    private int count;

    @Column(name = "ADDRESS")
    private String address;

    @ManyToMany(fetch = EAGER)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Builder(builderMethodName = "createOrder")
    public Order(Member member, int count, String address){
        this.member = member;
        this.count = count;
        this.address = address;
    }

}
