package com.ofss.main.ServiceRepository;

import org.springframework.stereotype.Service;

import com.ofss.main.domain.Customer;

@Service
public interface CustomerService {
    public String register(Customer c);
    public String login(String customerLoginId , String customerPassword);
}
