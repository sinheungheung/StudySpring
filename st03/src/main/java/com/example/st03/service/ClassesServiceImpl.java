package com.example.st03.service;

import com.example.st03.domain.Classes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesServiceImpl implements ClassesService {

    @Override
    public List<Classes> getClasses() {
        List<Classes> list = classesDb();
        return list;
    }

    public List<Classes> classesDb() {
        List<Classes> list = classesDb();
        Classes class1 = new Classes("스프링", 9, 1);
        list.add(class1);
        return list;

    }
}
