package kr.hs.study.StudySpring.domain;

import lombok.Data;

@Data // getter setter 포함
public class Member {
    private Long id;
    private String name;

    // 생성자
    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}

// 일단 domain, service, controller 순으로 각각 패키지를 만든다.

// domain 패키지 안에는 자바 클래스로 된 Member 클래스가 존재한다
// Member 클래스 안에는 필요한 데이터?들이 선언되어 있다.
// @Data 어노테이션을 사용하면 getter와 setter을 안 써도 되며 생성자를 만든다.

// service 패키지 안에는 MemberService 인터페이스와 MemberService를 상속받는 MemberServiceImpl 자바 클래스가 있다.
// 인터페이스 MemberService는 domain패키지 Member 클래스에서 선언했던 데이터들이 대략 어떤 걸 할건지 대충 틀을 잡는다.
// MemberService를 상속받는 MemberServiceImpl 자바 클래스는 그 틀에 대한 기능을 만드는 곳이다.

// controller 패키지에 MemberController 자바 클래스를 만든다.
// 만든 것을 사용자들이 확인할 수 있게 하는 코드를 적는 곳이다.
