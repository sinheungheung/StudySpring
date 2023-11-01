package com.example.hh.demo01.service;

import com.example.hh.demo01.model.Kitty;
import com.example.hh.demo01.repository.KittyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class KittyServiceImpl implements KittyService{
    private final KittyRepository kittyRepository;

    @Override
    public List<Kitty> getKitties() {
        return kittyRepository.findAll();
    }

    @Override
    public Optional<Kitty> getKittyById(long id) {
        return kittyRepository.findById(id);
    }

    @Override
    public List<Kitty> getKittyByName(String name) {
        return kittyRepository.findByName(name);
    }

    @Override
    public List<Kitty> getKittyByAge(int age) {
        return kittyRepository.findByAge(age);
    }

    @Override
    public Kitty insertKitty(String name, int age) {
        Kitty newKitty = new Kitty();
        newKitty.setName(name);
        newKitty.setAge(age);
        Kitty saveKitty = kittyRepository.save(newKitty);
        return saveKitty;
    }
}
