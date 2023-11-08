package kr.hs.example.backpractice01.dto.department;

import kr.hs.example.backpractice01.domain.Department;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentRes {
    private Long id;
    private String name;

    @Builder
    public DepartmentRes(Department department){
        this.id = department.getId();
        this.name = department.getName();
    }
}
