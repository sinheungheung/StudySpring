package kr.hs.example.backpractice01.dto.customer;

import kr.hs.example.backpractice01.domain.Customer;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class CustomerResDto {
    private Long id;
    private String name;

    @Builder
    public CustomerResDto(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
    }
}
