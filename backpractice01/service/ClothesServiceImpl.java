package kr.hs.example.backpractice01.service;

import kr.hs.example.backpractice01.domain.Clothes;
import kr.hs.example.backpractice01.repository.ClothesRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ClothesServiceImpl implements ClothesService{

    private final ClothesRepository clothesRepository;

    @Override
    @Transactional
    public Clothes insertClothes(String name, int count){
        Clothes newClothes = Clothes.createClothes()
                .name(name)
                .count(count)
                .build();

                return clothesRepository.save(newClothes);
    }
    @Override
    public List<Clothes> getClothes(){
        return  clothesRepository.findAll();
    }
}
