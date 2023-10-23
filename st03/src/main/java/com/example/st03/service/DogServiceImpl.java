package com.example.st03.service;

import com.example.st03.domain.Dog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DogServiceImpl implements DogService {
    // 아이디 자동으로
    private static Long Id = 0L;

    private final List<Dog> dogs = new ArrayList<>();

    // 목록
    @Override
    public List<Dog> getDogs() {
        List<Dog> dogList = dogs;
        return dogList;
    }

    // 상세
    @Override
    public Dog getDog(Long id) {
        Dog dog = new Dog();
        for (int i = 0; i < dogs.size(); i++) {
            if (dogs.get(i).getId() == id) {
                dog = dogs.get(i);
            }
        }
        if (dog.getId() == null) {
            return null;
        }
        return dog;
    }

    // 추가
    @Override
    public String insertDog(String name) {
        Dog newDog = new Dog(Id, name);
        Id++;

        dogs.add(newDog);
        return newDog.getName() + "이 등록되었습니다. ";
    }


    // 수정
    @Override
    public String updateDog(Long id, String name) {
        Dog foundDog = getDog(id);

        if (foundDog == null) {
            return "존재하지 않는 아이디입니다.";
        }

        String beforeDogName = foundDog.getName();
        foundDog.setName(name);

        return beforeDogName + "이름이 " + name + "로 수정되었습니다.";
    }

    // 삭제
    @Override
    public String deleteDog(Long id) {
        String deleteList = "";

        if (dogs.size() == 0) {
            deleteList = "목록이 없습니다.";
            return deleteList;
        }

        Dog foundDog = getDog(id);

        if (foundDog == null) {
            return "존재하지 않는 아이디입니다.";
        }

        dogs.remove(foundDog);
        return foundDog.getName() + "이 삭제되었숩니다.";
    }
}
