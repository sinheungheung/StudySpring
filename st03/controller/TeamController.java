package com.example.st03.controller;

import com.example.st03.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/teams")
@RestController
public class TeamController {
    private final TeamService teamService;

    @PostMapping("/{id}/students/{studentName}")
    public ResponseEntity<?> myStudent(@PathVariable(name = "id") Long id, @PathVariable(name = "studentName") String studentName) {
        String result = teamService.insertMyStudent(id, studentName);
        return ResponseEntity.ok(result);
    }
}
