package com.example.hh.demo01.service;

import com.example.hh.demo01.model.Food;
import com.example.hh.demo01.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class FoodServiceImpl implements FoodService{
    private final FoodRepository foodRepository;

    @Override
    public List<Food> foodList() {
        return foodRepository.findAll();
    }

    @Override
    public Optional<Food> getFoodById(Long id) {
        return foodRepository.findById(id);
    }

    @Override
    public List<Food> getFoodByName(String name) {
        return foodRepository.findByName(name);
    }

    @Override
    public Food insertFood(String name) {
        Food newFood = new Food();
        newFood.setName(name);
        Food saveFood = foodRepository.save(newFood);
        return saveFood;
    }
}
