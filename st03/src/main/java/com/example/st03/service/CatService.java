package com.example.st03.service;

import com.example.st03.domain.Cat;

import java.util.List;

public interface CatService {

    // 목록
    public List<Cat> getCats();

    // 상세
    public Cat getCat(Long id);

    // 추가
    void insertCat(String name, int age);

    // 수정
    void updateCat(Long id, String name, int age);

    // 삭제
    void deleteCat(Long id);
}
