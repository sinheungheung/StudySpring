package kr.hs.study.StudySpring.member;

import lombok.Data;

@Data // getter, setter 안 쓰기 위해
public class Member {
    private Long id;
    private String name;
    private Grade grade;

    public Member(Long id, String name, Grade grade){
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

}
