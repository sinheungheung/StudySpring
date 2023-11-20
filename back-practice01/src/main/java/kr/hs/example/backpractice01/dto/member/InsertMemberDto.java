package kr.hs.example.backpractice01.dto.member;

import kr.hs.example.backpractice01.domain.Member;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InsertMemberDto {
    private String name;
    private String email;
    private String password;

}
