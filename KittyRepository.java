package com.example.hh.demo01.repository;

import com.example.hh.demo01.model.Kitty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KittyRepository extends JpaRepository<Kitty, Long> {

    List<Kitty> findByName(String name);

    List<Kitty> findByAge(int age);
}
