package kr.hs.example.backpractice01.service;

import kr.hs.example.backpractice01.domain.Item;

import java.util.List;

public interface ItemService {
    Item insertItem(String name, int count, int price);

    List<Item> getItem();

    void deleteItem(Long id);

    void updateItem(Long id, String name, int count, int price);
}
