package kr.hs.study.StudySpring.order;

import kr.hs.study.StudySpring.domain.Kitty;

import java.util.ArrayList;
import java.util.List;

public interface KittyService {

    // 목록
    List<Kitty> getKitty();

    // 상세
    Kitty getKitty(Long id);

    // 추가
    void insertKitty(Long id, String name, String color);

    // 수정
    void updateKitty(Long id, String name, String color);

    // 삭제
    void deleteKitty(Long id);
}
