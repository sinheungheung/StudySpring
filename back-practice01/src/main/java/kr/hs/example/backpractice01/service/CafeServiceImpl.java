package kr.hs.example.backpractice01.service;

import kr.hs.example.backpractice01.domain.Cafe;
import kr.hs.example.backpractice01.repository.CafeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CafeServiceImpl implements CafeService {

    private final CafeRepository cafeRepository;

    @Override
    @Transactional
    public Cafe insertCafe(String name, int count){
        Cafe newCafe = Cafe.createMenu()
                .name(name)
                .count(count)
                .build();

        return cafeRepository.save(newCafe);
    }
    @Override
    public List<Cafe> getCafe(){return cafeRepository.findAll();}
}
