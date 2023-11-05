package kr.hs.study.demo01.service;

import kr.hs.study.demo01.domain.Item;

public interface ItemService {
    Item insertItem(String name, int count);
}
