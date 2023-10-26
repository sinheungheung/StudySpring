package com.example.st03.service;

import com.example.st03.domain.Student;
import com.example.st03.domain.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TeamServiceImpl implements TeamService {
    private final List<Team> teams = new ArrayList<>();
    private final StudentService studentService;


    private Team getTeam(Long id) {

        Team myTeam = new Team();
        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).getId() == id) {
                myTeam = teams.get(i);
            }
        }
        if (myTeam.getId() == null) {
            return null;
        }
        return myTeam;
    }

    @Override
    public String insertMyStudent(Long id, String studentName) {
        Team foundTeam = getTeam(id);
        if (foundTeam == null) {
            return "찾는 팀이 없습니다.";
        }

        Student foundStudent = studentService.getStudentByName(studentName);
        if (studentName == null) {
            return "찾는 학생이 없습니다.";
        }

        foundTeam.getStudentList().add(foundStudent);
        return studentName;
    }

}