package kr.hs.example.backpractice01.service;


import kr.hs.example.backpractice01.domain.Cafe;

import java.util.List;

public interface CafeService {

    Cafe insertCafe(String name, int count);
    List<Cafe> getCafe();
}
