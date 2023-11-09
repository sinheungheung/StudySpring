package kr.hs.example.backpractice01.service;

import kr.hs.example.backpractice01.domain.Clothes;
import kr.hs.example.backpractice01.repository.ClothesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ClothesServiceImpl implements ClothesService {

    private final ClothesRepository clothesRepository;

    @Override
    @Transactional
    public Clothes insertClothes(String name, int count) {
        boolean exists = clothesRepository.existsByName(name);
        if (exists) {
            throw new IllegalStateException("옷 이름이 중복입니다");
        }
        Clothes newClothes = Clothes.createClothes()
                .name(name)
                .count(count)
                .build();

        return clothesRepository.save(newClothes);
    }

    @Override
    public List<Clothes> getClothes() {
        return clothesRepository.findAll();
    }
}
