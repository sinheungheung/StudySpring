package kr.hs.example.backpractice01.service;


import kr.hs.example.backpractice01.domain.Customer;

import java.util.List;

public interface CustomerService {
    Customer insertCustomer(String name);

    List<Customer> getCustomer();

    List<Customer> getCustomers();
}
