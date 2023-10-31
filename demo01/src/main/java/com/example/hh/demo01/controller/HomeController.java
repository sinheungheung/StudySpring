package com.example.hh.demo01.controller;


import com.example.hh.demo01.model.Member;
import com.example.hh.demo01.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class HomeController {

    private final MemberRepository memberRepository;

    @GetMapping("/members")
    public ResponseEntity<?> getMembers() {
        List<Member> all = memberRepository.findAll();
        return ResponseEntity.ok(all);
    }
}
