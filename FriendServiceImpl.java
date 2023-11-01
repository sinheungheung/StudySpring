package com.example.hh.demo01.service;

import com.example.hh.demo01.model.Friend;
import com.example.hh.demo01.repository.FriendRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class FriendServiceImpl implements FriendService{
    private final FriendRepository friendRepository;

    @Override
    public List<Friend> friends() {
        return friendRepository.findAll();
    }

    @Override
    public Optional<Friend> getFriendById(long id) {
        return friendRepository.findById(id);
    }

    @Override
    public List<Friend> getFriendByName(String name) {
        return friendRepository.findFriendByName(name);
    }

    @Override
    public List<Friend> getFriendByAge(int age) {
        return friendRepository.findFriendByAge(age);
    }

    @Override
    public Friend insertFriend(String name, int age) {
        Friend newFriend = new Friend();
        newFriend.setName(name);
        newFriend.setAge(age);
        Friend insertFriend = friendRepository.save(newFriend);
        return insertFriend;
    }
}
