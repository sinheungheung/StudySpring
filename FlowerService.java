package com.example.st03.service;

import com.example.st03.domain.Flower;

import java.util.List;

public interface FlowerService {
    // 목록
    List<Flower> getFlowers();

    // 상세
    Flower getFlower(Long id);

    Flower getFlowerByName(String name);

    // 추가
    String insertFlower(String name, int price);

    // 수정
    String updateFlower(Long id, String name);

    // 삭제
    String deleteFlower(Long id);

}
