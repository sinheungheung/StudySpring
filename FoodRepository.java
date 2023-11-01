package com.example.hh.demo01.repository;

import com.example.hh.demo01.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.naming.Name;
import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {

    List<Food> findFoodByName(String name);

    List<Food> findByName(String name);
}
