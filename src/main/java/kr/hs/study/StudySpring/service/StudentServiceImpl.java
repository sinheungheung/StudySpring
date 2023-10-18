package kr.hs.study.StudySpring.service;

import kr.hs.study.StudySpring.domain.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public List<Student> getStudent() {
        List<Student> list = studentDb();
        return list;
    }

    public List<Student> studentDb() {
        List<Student> list = new ArrayList<>();
        Student s1 = new Student(19, "김신흥");
        list.add(s1);
        return list;
    }
}
