package com.example.st03.service;

import com.example.st03.domain.Computer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComputerServiceImpl implements ComputerService {
    private static Long indexId = 0L;
    private final List<Computer> computers = new ArrayList<>();

    // 목록
    @Override
    public List<Computer> getComputers() {
        return computers;
    }

    // 상세
    @Override
    public String getComputer(Long id) {
        Computer computer = new Computer();
        for (int i = 0; i < computers.size(); i++) {
            if (computers.get(i).getId() == id) {
                computer = computers.get(i);
            }
        }
        if(computer.getId() == null){
            return "찾는 컴퓨터가 없습니다.";
        }
        return computer.toString();
    }

    // 추가
    @Override
    public String insertComputer(String name, String brand, int screenSize) {
        Computer computer = new Computer(indexId, name, brand, screenSize);
        indexId++;

        computers.add(computer);
        return computer.getBrand() + "가 새롭게 선보인 컴퓨터의 이름은 " + computer.getName() + "입니다.";

    }

    // 수정
    @Override
    public String updateComputer(Long id, String name, String brand, int screenSize) {
        String beforeScreenSize = "";
        String afterScreenSize = "";
        for (int i = 0; i < computers.size(); i++) {
            if (computers.get(i).getId() == id) {
                beforeScreenSize = computers.get(i).getName();
                computers.get(i).setName(name);
                afterScreenSize = computers.get(i).getName();
            }
        }
        return beforeScreenSize + "크기의 화면이 " + afterScreenSize + "로 바뀌었습니다.";
    }

    // 삭제
    @Override
    public String deleteComputer(Long id) {
        String delete = "";
        if(computers.size() == 0 ){
            delete = "컴퓨터가 없습니다.";
            return delete;
        }
        for (int i = 0; i < computers.size(); i++) {
            if (computers.get(i).getId() == id) {
                delete = computers.get(i).getName() + "이 삭제 되었습니다.";
                computers.remove(computers.get(i));
            }
        }
        if(delete.equals("")){
            return "해당 아이디를 찾을 수 없습니다.";
        }
        return delete;
    }
}
