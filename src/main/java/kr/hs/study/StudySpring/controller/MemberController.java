package kr.hs.study.StudySpring.controller;

import kr.hs.study.StudySpring.domain.Member;
import kr.hs.study.StudySpring.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor // 역할: 초기화되지 않은 final 필드에 대해 생성자를 만들어준다
@RestController // 역할: Json 형태로 객체 데이터 반환/ 그냥 controller은 view를 반환
public class MemberController {

    private final MemberService memberService;
//    @RequiredArgsConstructor 이걸 안 썼을 때 오류가 남 왜?



    @GetMapping("/members") // 어디에 있는 members?
    public ResponseEntity<?> test01(){
        List<Member> members = memberService.getMembers();
        return ResponseEntity.ok(members);
    }
}
