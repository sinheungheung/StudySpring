package kr.hs.study.StudySpring.service;

import kr.hs.study.StudySpring.domain.Me;

import java.util.List;

public interface MeService {
    List<Me> getMeList();

    String getMe(Long id);

    String insertMe(String name, int age);

    String updateMe(Long id, String name, int age);

    String deleteMe(Long id);
}
