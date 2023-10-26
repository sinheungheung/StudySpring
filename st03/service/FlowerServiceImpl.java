package com.example.st03.service;

import com.example.st03.domain.Flower;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlowerServiceImpl implements FlowerService {

    private static Long indexId = 0L;
    private final List<Flower> flowers = new ArrayList<>();

    // 목록
    @Override
    public List<Flower> getFlowers() {
        return flowers;
    }

    // 상세
    @Override
    public Flower getFlower(Long id) {
        Flower flower = new Flower();
        for (int i = 0; i < flowers.size(); i++) {
            if (flowers.get(i).getId() == id) {
                flower = flowers.get(i);
            }
        }
        if (flower.getId() == null) {
            return null;
        }
        return flower;
    }

    // 추가
    @Override
    public String insertFlower(String name, int price) {
        Flower flower = new Flower(indexId, name, price);
        indexId++;

        flowers.add(flower);
        return flower.getName() + "을 가진 꽃이 잘 등록되었습니다.";
    }

    // 수정
    @Override
    public String updateFlower(Long id, String name) {
        String beforeFlowerName = "";
        // 3. 꽃을 수정한다
        Flower flower = getFlower(id);
        if (flower == null) {
            return "없어";
        }
        beforeFlowerName = flower.getName();
        flower.setName(name);
        return beforeFlowerName + "가 " + name + "로 수정되었습니다.";
    }

    // 삭제
    @Override
    public String deleteFlower(Long id) {
        String deleteResult = "";
        if (flowers.size() == 0) {
            return "꽃이 없습니다.";
        }
        Flower flower = getFlower(id);
        if (flower == null) {
            return "없음";
        }
        flowers.remove(flower);
        return flower.getName();
    }

    @Override
    public Flower getFlowerByName(String name) {
        Flower flower = new Flower();
        for (int i = 0; i < flowers.size(); i++) {
            if (flowers.get(i).getName().equals(name)) {
                flower = flowers.get(i);
            }
        }
        if (flower.getId() == null) {
            return null;
        }
        return flower;
    }
}
