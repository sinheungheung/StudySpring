package kr.hs.study.StudySpring.service;

import kr.hs.study.StudySpring.domain.IceCream;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IceCreamServiceImpl implements IceCreamService {
    private static Long indexId = 0L;
    private final List<IceCream> iceCreams = new ArrayList<>();

    @Override
    public List<IceCream> getIceCreams() {
        return iceCreams;
    }

    @Override
    public String getIceCream(Long id) {
        IceCream iceCream = new IceCream();
        for (int i = 0; i < iceCreams.size(); i++) {
            if (iceCreams.get(i).getId() == id) {
                iceCream = iceCreams.get(i);
            }
        }
        if (iceCream.getId() == null) {
            return "아이디가 없습니다.";
        }
        return iceCream.toString();
    }

    @Override
    public String insertIceCream(String name, String flavor) {
        IceCream iceCream = new IceCream(indexId, name, flavor);
        indexId++;

        iceCreams.add(iceCream);
        return iceCream.getName() + "이 등록되었습니다.";
    }

    @Override
    public String updateIceCream(Long id, String name, String flavor) {
        String beforeName = "";
        String afterName = "";
        for (int i = 0; i < iceCreams.size(); i++) {
            if (iceCreams.get(i).getId() == id) {
                beforeName = iceCreams.get(i).getName();
                iceCreams.get(i).setName(name);
                afterName = iceCreams.get(i).getName();
            }

        }
        if (beforeName.equals("")) {
            return "해당 아이디를 찾을 수 없습니다.";
        }
        return "아이스크림의 전 이름은 " + beforeName + "이었지만 지금은 " + afterName + "으로 바뀌었습니다.";
    }

    @Override
    public String deleteIceCream(Long id) {
        String delete = "";
        if (iceCreams.size() == 0) {
            return "해당 아이스크림을 찾을 수 없습니다.";
        }
        for (int i = 0; i < iceCreams.size(); i++) {
            if (iceCreams.get(i).getId() == id) {
                iceCreams.remove(iceCreams.get(i));
            }
        }
        if (delete.equals("")) {
            return "해당 아이디를 찾을 수 없습니다.";
        }
        return delete;
    }
}

