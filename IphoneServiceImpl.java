package com.example.hh.demo01.service;

import com.example.hh.demo01.model.Iphone;
import com.example.hh.demo01.repository.IphoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class IphoneServiceImpl implements IphoneService {
    private final IphoneRepository iphoneRepository;

    @Override
    public List<Iphone> getIphones() {
        return iphoneRepository.findAll();
    }

    @Override
    public Optional<Iphone> getIphoneById(Long id) {
        return iphoneRepository.findById(id);
    }


    @Override
    public List<Iphone> getIphoneByName(String name) {
        return iphoneRepository.findByName(name);
    }

    @Override
    public Iphone insertIphone(String name, int size) {
        Iphone newIphone = new Iphone();
        newIphone.setName(name);
        newIphone.setSize(size);
        Iphone insertIphone = iphoneRepository.save(newIphone);
        return insertIphone;

    }
}
