package kr.hs.example.backpractice01.service;

import kr.hs.example.backpractice01.domain.Customer;
import kr.hs.example.backpractice01.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    @Transactional
    public Customer insertCustomer(String name) {
        Optional<Customer> foundCustomer = customerRepository.findByName(name);
        if (!foundCustomer.isEmpty()) {
            throw new IllegalStateException("이름이 중복됩니다.");
        }
        Customer newCustomer = Customer.createCustomer()
                .name(name)
                .build();
        return customerRepository.save(newCustomer);
    }

    @Override
    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}
