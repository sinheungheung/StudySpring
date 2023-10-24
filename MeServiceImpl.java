package kr.hs.study.StudySpring.service;

import kr.hs.study.StudySpring.domain.Me;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MeServiceImpl implements MeService {
    private static Long indexId = 0L;
    private final List<Me> meList = new ArrayList<>();

    @Override
    public List<Me> getMeList() {
        return meList;
    }

    @Override
    public String getMe(Long id) {
        Me me = new Me();
        for (int i = 0; i < meList.size(); i++) {
            if (meList.get(i).getId() == id) {
                me = meList.get(i);
            }
        }
        if (me.getId() == null) {
            return "찾는 아이디가 존재하지 않습니다.";
        }
        return me.toString();
    }

    @Override
    public String insertMe(String name, int age) {
        Me me = new Me(indexId, name, age);
        indexId++;

        meList.add(me);
        return me.getName() + "이 등록되었습니다.";
    }

    @Override
    public String updateMe(Long id, String name, int age) {
        String beforeAge = "";
        String afterAge = "";
        for (int i = 0; i < meList.size(); i++) {
            if (meList.get(i).getId() == id) {
                beforeAge = meList.get(i).getName();
                meList.get(i).setName(name);
                afterAge = meList.get(i).getName();
            }
        }
        if (beforeAge.equals("")) {
            return "해당하는 아이디를 찾을 수 없습니다.";
        }
        return "1년 전 나이는 " + beforeAge + "였지만 현재 나이는 " + afterAge + "입니다.";
    }

    @Override
    public String deleteMe(Long id) {
        String delete = "";
        if (meList.size() == 0) {
            return "없습니다.";
        }
        for (int i = 0; i < meList.size(); i++) {
            if (meList.get(i).getId() == id) {
                delete = meList.get(i).getName() + "이 삭제되었습니다.";
                meList.remove(meList.get(i));
            }
        }
        if (delete.equals("")) {
            return "해당 아이디를 찾을 수 없습니다.";
        }
        return delete;
    }
}
