package kr.hs.study.StudySpring.discount;

import kr.hs.study.StudySpring.domain.Member;

public abstract class DiscountPolicy {
    int discount(Member member, int price) {
        return 0;
    }

    public abstract int discount(kr.hs.study.StudySpring.member.Member member, int price);
}
