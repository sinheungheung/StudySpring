package com.example.hh.demo01.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "ORDER_ITEM")
public class OrderItem {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @Builder(builderMethodName = "createOrderItem")
    public OrderItem(Order order, Item item) {
        this.order = order;
        this.item = item;
    }
}
