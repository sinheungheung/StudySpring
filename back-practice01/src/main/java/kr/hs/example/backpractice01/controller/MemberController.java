package kr.hs.example.backpractice01.controller;


import kr.hs.example.backpractice01.domain.Member;
import kr.hs.example.backpractice01.dto.member.InsertMemberDto;
import kr.hs.example.backpractice01.dto.member.MemberRes;
import kr.hs.example.backpractice01.dto.member.login.LoginDto;
import kr.hs.example.backpractice01.service.ItemService;
import kr.hs.example.backpractice01.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/members")
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;
    private final ItemService itemService;

    @PostMapping("/join")
    public ResponseEntity<?> insertMemberByName(@RequestBody InsertMemberDto params) {
        Member member = memberService.insertMember(params.getName(), params.getEmail(), params.getPassword());
        return ResponseEntity.ok(member);
    }

    @GetMapping("")
    public ResponseEntity<?> getMember() {
        List<MemberRes> members = memberService.getMembers()
                .stream().map(MemberRes::new).collect(Collectors.toList());

        return ResponseEntity.ok(members);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto params) {
        try {
            Member member = memberService.loginMember(params.getEmail(), params.getPassword());
            if (member.getPassword().equals(params.getPassword())) {
                return ResponseEntity.ok("로그인 성공!");
            }
            return ResponseEntity.ok(member);
        } catch (Exception exception) {
            return ResponseEntity.ok("로그인 실패입니다");
        }
    }
}

