package kr.hs.study.StudySpring;

import kr.hs.study.StudySpring.member.Grade;
import kr.hs.study.StudySpring.member.Member;
import kr.hs.study.StudySpring.member.MemberService;
import kr.hs.study.StudySpring.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();

        Member member = new Member(1L, "member", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
        }
    }
