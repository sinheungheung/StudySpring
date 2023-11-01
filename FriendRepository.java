package com.example.hh.demo01.repository;

import com.example.hh.demo01.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friend, Long> {

    List<Friend> findFriendByName(String name);
    List<Friend> findFriendByAge(int age);
}
