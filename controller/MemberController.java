package kr.hs.study.demo01.controller;

import kr.hs.study.demo01.domain.Member;
import kr.hs.study.demo01.dto.InsertMemberDto;
import kr.hs.study.demo01.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/member")
@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;

    @PostMapping("")
    public ResponseEntity<?> insertMember(@RequestBody InsertMemberDto params) {
        Member member = memberService.insertMember(params.getName());
        return ResponseEntity.ok(member);
    }
}