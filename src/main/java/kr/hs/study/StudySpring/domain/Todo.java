package kr.hs.study.StudySpring.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data // getter, setter
public class Todo {
    private Long id;
    private String name;
    private String title;
    private String contents;
}
