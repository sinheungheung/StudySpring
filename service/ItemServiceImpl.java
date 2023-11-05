package kr.hs.study.demo01.service;

import kr.hs.study.demo01.domain.Item;
import kr.hs.study.demo01.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    @Transactional
    public Item insertItem(String name, int count) {
        Item newItem = Item.createItem()
                .name(name)
                .count(count)
                .build();

        return itemRepository.save(newItem);
    }