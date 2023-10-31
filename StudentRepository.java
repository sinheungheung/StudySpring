package com.example.hh.demo01.repository;

import com.example.hh.demo01.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

  List<Student> findByName(String name);
  List<Student> findByAge(int age);

}
