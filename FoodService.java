package com.example.hh.demo01.service;

import com.example.hh.demo01.model.Food;

import java.util.List;
import java.util.Optional;

public interface FoodService {
    List<Food> foodList();

    Optional<Food> getFoodById(Long id);

    List<Food> getFoodByName(String name);

    Food insertFood(String name);
}
