package kr.hs.example.backpractice01.dto.member;

import kr.hs.example.backpractice01.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.GeneratedValue;

@Setter
@Getter
public class MemberRes {
    private Long id;
    private String name;
    private String email;
    private String password;

    @Builder
    public MemberRes(Member member){
        this.id = member.getId();
        this.name = member.getName();
        this.email = member.getEmail();
        this.password = member.getPassword();
    }
}
