package com.example.st03.service;

import com.example.st03.domain.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private static Long indexId = 0L;

    private final List<Student> students = new ArrayList<>();

    // 목록
    @Override
    public List<Student> getStudents() {
        return students;
    }

    // 상세
    @Override
    public String getStudent(Long id) {
        Student student = new Student();

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                student = students.get(i);
            }
        }

        if (student.getId() == null) {
            return "찾는 학생이 없습니다";
        }

        return student.toString();
    }

    // 추가
    @Override
    public String insertStudent(String name) {
        Student student = new Student(indexId, name);
        indexId++;

        students.add(student);

        return student.getName() + " 가 잘 등록되었습니다.";
    }

    // 수정
    public String updateStudent(Long id, String name) {
        String beforeStudentName = "";
        String afterStudentName = "";

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                beforeStudentName = students.get(i).getName();
                students.get(i).setName(name);
                afterStudentName = students.get(i).getName();
            }
        }

        if (beforeStudentName.equals("")) {
            return "해당 아이디를 찾을 수 없습니다.";
        }

        return beforeStudentName + "가  " + afterStudentName + " 로 잘 수정되었습니다.";
    }

    // 삭제
    @Override
    public String deleteStudent(Long id) {
        String deleteResult = "";

        // 학생이 아무도 등록되지 않았다면?
        if (students.size() == 0) {
            deleteResult = "학생이 아무도 없습니다.";
            return deleteResult;
        }

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                deleteResult = students.get(i).getName() + "가 삭제 되었습니다";
                students.remove(students.get(i));
            }
        }

        if (deleteResult.equals("")) {
            return "해당하는 아이디를 찾을수 없스빈다.";
        }

        return deleteResult;
    }
}
