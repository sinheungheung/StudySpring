package com.example.st03.service;

import com.example.st03.domain.Children;
import com.example.st03.domain.CottonCandy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ChildrenServiceImpl implements ChildrenService {

    private static Long indexId = 0L;
    private final List<Children> childrens = new ArrayList<>();
    private final CottonCandyService cottonCandyService;

    private Children getChildren(Long id) {
        Children children = new Children();

        for (int i = 0; i < childrens.size(); i++) {
            if (childrens.get(i).getId() == id) {
                children = childrens.get(i);
            }
        }
        if (children.getId() == null) {
            return null;
        }
        return children;
    }

    @Override
    public String buyCottonCandy(Long id, String cottonCandyName) {
        Children foundChildren = getChildren(id);
        if (foundChildren == null) {
            return "어린아이가 없습니다.";
        }
        CottonCandy foundCandy = cottonCandyService.getCottonCandyByFlavor(cottonCandyName);
        if (foundCandy == null) {
            return "찾는 솜사탕이 없습니다.";
        }

        int cottonCandyPrice = foundCandy.getPrice();
        int childrenMoney = foundChildren.getMoney();
        if (cottonCandyPrice > childrenMoney) {
            return "돈이 부족합니다.";
        }
        int balance = childrenMoney - cottonCandyPrice;
        foundChildren.setMoney(balance);
        foundChildren.getCandyList().add(foundCandy);

        return "솜사탕을 구매하였습니다.";
    }


    @Override
    public void insertChildren(String name, int age) {
        Children children = new Children(indexId, name, age, 5000, new ArrayList<CottonCandy>());
        childrens.add(children);

        indexId++;

    }
}
