package kr.hs.example.backpractice01.controller;

import kr.hs.example.backpractice01.domain.Member;
import kr.hs.example.backpractice01.dto.member.InsertMemberDto;
import kr.hs.example.backpractice01.dto.member.MemberRes;
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

    @PostMapping("")
    public ResponseEntity<?> insertMember(@RequestBody InsertMemberDto params){
        Member member = memberService.insertMember(params.getName());
        return ResponseEntity.ok(member);
    }
    @GetMapping("")
    public ResponseEntity<?> getMember(){
        List<MemberRes> members  = memberService.getMembers()
                .stream().map(MemberRes::new).collect(Collectors.toList());
        return ResponseEntity.ok(members);
    }
}
