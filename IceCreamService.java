package kr.hs.study.StudySpring.service;

import kr.hs.study.StudySpring.domain.IceCream;

import java.util.List;

public interface IceCreamService {
    List<IceCream> getIceCreams();

    String getIceCream(Long id);

    String insertIceCream(String name, String flavor);

    String updateIceCream(Long id, String name, String flavor);

    String deleteIceCream(Long id);
}
