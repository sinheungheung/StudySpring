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
    public String getFlower(Long id) {
        Flower flower = new Flower();
        for (int i = 0; i < flowers.size(); i++) {
            if (flowers.get(i).getId() == id) {
                flower = flowers.get(i);
            }
        }
        if (flower.getId() == null) {
            return "찾는 꽃이 없습니다.";
        }
        return flower.toString();
    }

    // 추가
    @Override
    public String insertFlower(String name, String color) {
        Flower flower = new Flower(indexId, name, color);
        indexId++;

        flowers.add(flower);
        return flower.getColor() + "색 의 " + flower.getName() + "을 가진 꽃이 잘 등록되었습니다.";
    }

    // 수정
    @Override
    public String updateFlower(Long id, String name, String color) {
        String beforeFlowerName = "";
        String afterFlowerName = "";
        for (int i = 0; i < flowers.size(); i++) {
            if (flowers.get(i).getId() == id) {
                beforeFlowerName = flowers.get(i).getName();
                flowers.get(i).setName(name);
                afterFlowerName = flowers.get(i).getName();
            }
        }
        if (beforeFlowerName.equals("")) {
            return "해당 아이디를 찾을 수 없습니다.";
        }
        return beforeFlowerName + "가 " + afterFlowerName + "로 수정되었습니다.";
    }

    // 삭제
    @Override
    public String deleteFlower(Long id) {
        String deleteResult = "";
        if (flowers.size() == 0) {
            deleteResult = "꽃이 없습니다.";
            return deleteResult;
        }
        for (int i = 0; i < flowers.size(); i++) {
            if (flowers.get(i).getId() == id) {
                deleteResult = flowers.get(i).getName() + "이 삭제되었습니다.";
                flowers.remove(flowers.get(i));
            }
        }
        if (deleteResult.equals("")) {
            return "해당 아이디를 찾을 수 없습니다.";
        }
        return deleteResult;
    }
}
