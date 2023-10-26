package kr.hs.study.StudySpring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    private Long id;
    private String name;
    private List<Department> departmentList = new ArrayList<>();
}
