package com.example.st03.service;

import com.example.st03.domain.CottonCandy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CottonCandyServiceImpl implements CottonCandyService {
    private static Long indexId = 0L;
    private final List<CottonCandy> cottonCandies = new ArrayList<>();

    @Override
    public CottonCandy getCottonCandyByFlavor(String flavor) {
        CottonCandy cottonCandy = new CottonCandy();
        for (int i = 0; i < cottonCandies.size(); i++) {
            if (cottonCandies.get(i).getFlavor().equals(flavor)) {
                cottonCandy = cottonCandies.get(i);
            }
        }
        if (cottonCandy.getId() == null) {
            return null;
        }
        return cottonCandy;
    }

    @Override
    public void insertCandy(String flavor, int price) {
        // 캔디 맛이 겹치면 캔디 생성 x
        if (getCottonCandyByFlavor(flavor) == null) {
            CottonCandy candy = new CottonCandy(indexId, flavor, price);
            indexId++;
            cottonCandies.add(candy);
        }
    }
}

