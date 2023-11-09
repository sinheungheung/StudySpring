package kr.hs.example.backpractice01.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CUSTOMER")
@Entity
@Data
public class Customer {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "customer")
    List<Order> orders = new ArrayList<>();

    @Builder(builderMethodName = "createCustomer")
    public Customer(String name){this.name = name;}

}
