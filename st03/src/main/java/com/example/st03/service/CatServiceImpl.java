package com.example.st03.service;

import com.example.st03.domain.Cat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatServiceImpl implements CatService {
    private final List<Cat> cats = new ArrayList<>();
    private Long indexId = 0L;

    // 목록
    @Override
    public List<Cat> getCats() {
        return cats;
    }

    // 상세
    @Override
    public Cat getCat(Long id) {
        Cat cat = new Cat();
        for (int i = 0; i < cats.size(); i++) {
            if (cats.get(i).getId() == id) {
                cat = cats.get(i);
            }
        }
        if (cat.getId() == null) {
            return null;
        }
        return cat;
    }

    // 추가
    @Override
    public void insertCat(String name, int age) {
        Cat cat = new Cat();
        cat.setId(indexId);
        indexId++;
        cat.setName(name);
        cat.setAge(age);
        cats.add(cat);
    }

    @Override
    public void updateCat(Long id, String name, int age) {
        Cat cat = getCat(id);


    }

    @Override
    public void deleteCat(Long id) {

    }
}
