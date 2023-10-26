package com.example.st03.service;

import com.example.st03.domain.Flower;
import com.example.st03.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final Long indexId = 0L;
    private final List<Member> members = new ArrayList<>();
    private final FlowerService flowerService;

    @Override
    public List<Member> getMembers() {
        List<Member> list = members;
        return list;
    }

    @Override
    public Member getMember(Long id) {
        Member m1 = new Member();

        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId() == id) {
                m1 = members.get(i);
            }
        }

        if (m1.getId() == null) {
            return null;
        }

        return m1;
    }

    @Override
    public void insertMember(String name) {
        Member newMember = new Member(indexId, name);
        members.add(newMember);
    }

    @Override
    public void updateMember(Long id, String name) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId() == id) {
                members.get(i).setName(name);
            }
        }
    }

    @Override
    public void deleteMember(Long id) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId() == id) {
                members.remove(members.get(i));
            }
        }
    }

    @Override
    public String buyFlower(Long id, String flowerName) {
        Member foundMember = getMember(id);
        if (foundMember == null) {
            return "찾는 멤버가 없습니다";
        }

        Flower foundFlower = flowerService.getFlowerByName(flowerName);
        if (foundFlower == null) {
            return "찾는 꽃이 없습니다.";
        }

        int flowerPrice = foundFlower.getPrice();
        int myMoney = foundMember.getMoney();
        if (flowerPrice > myMoney) {
            return "돈이 부족합니다.";
        }

        int balance = myMoney - flowerPrice;
        foundMember.setMoney(balance);
        foundMember.getFlowerList().add(foundFlower);

        return "꽃을 구매하였습니다";
    }

}
