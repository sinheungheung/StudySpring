package kr.hs.study.StudySpring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Me {
    private Long id;
    private String name;
    private int age;
}
