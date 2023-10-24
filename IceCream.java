package kr.hs.study.StudySpring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IceCream {
    private Long id;
    private String name;
    private String flavor;
}
