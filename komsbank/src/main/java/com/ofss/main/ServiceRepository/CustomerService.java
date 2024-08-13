package com.ofss.main.ServiceRepository;

import com.ofss.main.domain.Customer;

public interface CustomerService {
    public String register(Customer c);
    public String login(String customerLoginId , String customerPassword);
}
