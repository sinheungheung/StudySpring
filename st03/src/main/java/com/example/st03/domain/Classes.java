package com.example.st03.domain;

import lombok.Data;

@Data
public class Classes {
    private String subject; // 과목
    private int difficulty; // 난이도(1~10)
    private int singnUpStudents; // 수강하는 학생 수

    public Classes(String subject, int difficulty, int singnUpStudents){
        this.subject = subject;
        this.difficulty = difficulty;
        this.singnUpStudents = singnUpStudents;
    }
}
