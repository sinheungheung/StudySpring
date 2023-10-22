package kr.hs.study.StudySpring.order;

import kr.hs.study.StudySpring.discount.DiscountPolicy;
import kr.hs.study.StudySpring.discount.FixDiscountPolicy;
import kr.hs.study.StudySpring.member.Member;
import kr.hs.study.StudySpring.member.MemberRepository;
import kr.hs.study.StudySpring.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findByID(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return  new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
