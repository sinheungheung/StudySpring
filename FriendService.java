package com.example.hh.demo01.service;

import com.example.hh.demo01.model.Friend;

import java.util.List;
import java.util.Optional;

public interface FriendService {
    List<Friend> friends();
    Optional<Friend> getFriendById(long id);
    List<Friend> getFriendByName(String name);
    List<Friend> getFriendByAge(int age);

    Friend insertFriend(String name, int age);



}
