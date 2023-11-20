package kr.hs.example.backpractice01.dto.member;

import kr.hs.example.backpractice01.domain.Member;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
    private String name;
    private String email;
    private String password;
}
