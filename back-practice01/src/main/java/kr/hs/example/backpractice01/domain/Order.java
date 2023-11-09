package kr.hs.example.backpractice01.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.EAGER;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ORDERS")
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

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @Builder(builderMethodName = "createOrder")
    public Order(Customer customer, int count, String address){
        this.customer = customer;
        this.count = count;
        this.address = address;
    }

}
