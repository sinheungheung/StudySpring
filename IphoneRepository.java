package com.example.hh.demo01.repository;

import com.example.hh.demo01.model.Iphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IphoneRepository extends JpaRepository<Iphone, Long> {
    List<Iphone> findByName(String name);
    List<Iphone> findBySize(int size);
}
