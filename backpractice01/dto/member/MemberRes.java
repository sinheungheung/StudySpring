package kr.hs.example.backpractice01.dto.member;

import kr.hs.example.backpractice01.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberRes {
    private Long id;
    private String name;

    @Builder
    public MemberRes(Member member){
        this.id = member.getId();
        this.name = member.getName();
    }
}
