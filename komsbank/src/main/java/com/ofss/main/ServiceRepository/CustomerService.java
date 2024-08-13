package com.ofss.main.ServiceRepository;

import com.ofss.main.domain.Customer;

public interface CustomerService {
    public boolean register(Customer c);
    public String login(String loginID , String pwd);
}
