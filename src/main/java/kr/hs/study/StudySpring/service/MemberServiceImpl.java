package kr.hs.study.StudySpring.service;

import kr.hs.study.StudySpring.domain.Member;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    // 디비 코드를 return 해주는
    @Override
    public List<Member> getMembers() {
        List<Member> list = memberDb();
        return list;
    }

    // 가져온 디비
    public List<Member> memberDb() {
        List<Member> list = new ArrayList<>();

        // Member에서 생성자를 만들었으니 여기서 객체 만들기 가능
        Member m1 = new Member(1L, "1학년");
        Member m2 = new Member(2L, "2학년");
        Member m3 = new Member(3L, "3학년");

        list.add(m1);
        list.add(m2);
        list.add(m3);

        return list;

    }

}
