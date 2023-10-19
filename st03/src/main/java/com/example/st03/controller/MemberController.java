package com.example.st03.controller;

import com.example.st03.domain.Member;
import com.example.st03.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/members")
@RestController
public class MemberController {

    private final MemberService memberService;

    // GET http:localhost:8080/members => 목록
    // GET http:localhost:8080/members/{id} => 상세
    // POST http:localhost:8080/members 리퀘스트바디 => 추가
    // PUT http:localhost:8080/members/{id} 리퀘스트바디 => 추가
    // DELETE http:localhost:8080/members/{id} => 삭제

    @GetMapping("")
    public ResponseEntity<?> getMembers() {
        List<Member> members = memberService.getMembers();
        Member m1 = new Member();

        Member m2 = new Member(1L,"ddd");

        return ResponseEntity.ok(members);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMember(@PathVariable(name = "id") Long id) {
        Member member = memberService.getMember(id);
        return ResponseEntity.ok(member);
    }

    @PostMapping("")
    public ResponseEntity<?> insertMember(@RequestBody Member params) {
        memberService.insertMember(params.getId(), params.getName());
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMember(@PathVariable(name = "id") Long id,
                                          @RequestBody Member member) {
        memberService.updateMember(id, member.getName());
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable(name = "id") Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.ok(null);
    }
}
