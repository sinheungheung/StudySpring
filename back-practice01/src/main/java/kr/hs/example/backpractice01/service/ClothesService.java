package kr.hs.example.backpractice01.service;

import kr.hs.example.backpractice01.domain.Clothes;

import java.util.List;

public interface ClothesService {
    Clothes insertClothes(String name, int count);

    List<Clothes> getClothes();
}
