package kr.hs.study.StudySpring.order;

import kr.hs.study.StudySpring.domain.Kitty;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KittyServiceImpl implements KittyService {

    private final List<Kitty> kittyList = new ArrayList<>();

    // 목록
    @Override
    public List<Kitty> getKitty() {
        List<Kitty> kitty = kittyList;

        return kitty;
    }

    // 상세
    @Override
    public Kitty getKitty(Long id) {
        Kitty kitty = new Kitty();
        for (int i = 0; i < kittyList.size(); i++) {
            if (kittyList.get(i).getId() == id) {
                kitty = kittyList.get(i);
            }
        }
        return kitty;
    }

    // 추가

    @Override
    public void insertKitty(Long id, String name, String color) {
        Kitty kitty = new Kitty(id, name, color);

        kittyList.add(kitty);
    }
    // 수정

    @Override
    public void updateKitty(Long id, String name, String color) {
        for (int i = 0; i < kittyList.size(); i++) {
            if (kittyList.get(i).getId() == id) {
                kittyList.get(i).setName(name);
                kittyList.get(i).setColor(color);
            }
        }
    }

    // 삭제
    @Override
    public void deleteKitty(Long id) {
        for (int i = 0; i < kittyList.size(); i++) {
            if (kittyList.get(i).getId() == id) {
                kittyList.remove(kittyList.get(i));
            }
        }

    }

    // main
}