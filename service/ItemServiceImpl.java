package com.example.hh.demo01.service;

import com.example.hh.demo01.domain.Item;
import com.example.hh.demo01.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    // 수정, 삭제, 등록
    @Override
    @Transactional
    public Item insertItem(String name, int count) {
        Item newItem = Item.createItem()
                .name(name)
                .count(count)
                .build();

        return itemRepository.save(newItem);
    }
}
