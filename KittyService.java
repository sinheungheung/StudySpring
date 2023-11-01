package com.example.hh.demo01.service;

import com.example.hh.demo01.model.Kitty;

import java.util.List;
import java.util.Optional;

public interface KittyService {

    List<Kitty> getKitties();

    Optional<Kitty> getKittyById(long id);

    List<Kitty> getKittyByName(String name);

    List<Kitty> getKittyByAge(int age);

    Kitty insertKitty(String name, int age);
}
