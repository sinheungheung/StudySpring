package com.example.hh.demo01.service;

import com.example.hh.demo01.model.Iphone;

import java.util.List;
import java.util.Optional;

public interface IphoneService {
    List<Iphone> getIphones();

    Optional<Iphone> getIphoneById(Long id);

    List<Iphone> getIphoneByName(String name);

    Iphone insertIphone(String name, int size);

}
