package kr.hs.example.backpractice01.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.print.DocFlavor;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CAFE")
@Entity
@Data
public class Cafe {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "COUNT")
    private int count;

    @Builder(builderMethodName = "createMenu")
    public Cafe(String name, int count){
        this.name = name;
        this.count = count;
    }
    public void minusCount(int minusCount){this.count -= minusCount;}
}
