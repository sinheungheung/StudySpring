package kr.hs.study.StudySpring.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Kitty {
    private Long id;
    private String name;
    private String color;
}
