package com.example.st03.service;

import com.example.st03.domain.Doctor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    private static Long indexId = 0L;
    private final List<Doctor> doctors = new ArrayList<>();

    // 목록
    @Override
    public List<Doctor> getDoctors() {
        return doctors;
    }

    // 상세
    @Override
    public String getDoctor(Long id) {
        Doctor doctor = new Doctor();
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getId() == id) {
                doctor = doctors.get(i);
            }
        }
        if (doctor.getId() == null) {
            return "찾는 아이디가 없습니다.";
        }
        return doctor.toString();
    }

    // 추가
    @Override
    public String insertDoctor(String name, int age) {
        Doctor doctor = new Doctor(indexId, name, age);
        indexId++;

        doctors.add(doctor);

        return "의사의 이름은 " + doctor.getName() + "이고 나이는 " + doctor.getAge() + "입니다.";
    }

    // 수정
    @Override
    public String updateDoctor(Long id, String name, int age) {
        int beforeAge = 0;
        int afterAge = 0;
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getId() == id) {
                beforeAge = doctors.get(i).getAge();
                doctors.get(i).setAge(age);
                afterAge = doctors.get(i).getAge();
            }
        }
        return "작년 의사의 나이는 " + beforeAge + "이었지만 올해 의사의 나이는 " + afterAge + "입니다.";
    }


    // 삭제
    @Override
    public String deleteDoctor(Long id) {
        String delete = "";
        if(doctors.size() == 0){
            delete = "해당 의사가 불참입니다.";
            return delete;
        }
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getId() == id) {
                delete = doctors.get(i).getName() +"이 명단에서 삭제되었습니다.";
                doctors.remove(doctors.get(i));
            }
        }
        if(doctors.equals("")){
            return "해당 아이디를 찾을 수 없습니다.";
        }
        return delete;
    }
}
