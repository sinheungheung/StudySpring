package com.example.st03.service;

import com.example.st03.domain.Dog;

import java.util.List;

public interface DogService {

    // 목록
    List<Dog> getDogs();

    // 상세
    Dog getDog(Long id);

    // 추가
    String insertDog(String name);

    // 수정
    String updateDog(Long id, String name);

    // 삭제
    String deleteDog(Long id);
}
