package kr.hs.study.StudySpring.discount;

import kr.hs.study.StudySpring.member.Grade;
import kr.hs.study.StudySpring.member.Member;

public class FixDiscountPolicy extends DiscountPolicy {

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price){
        if (member.getGrade() == Grade.VIP) {

            return discountFixAmount;
        }else{
            return 0;
        }
    }
}
