package com.ofss.main.Repository;

import com.ofss.main.domain.Customer;

public interface CustomerRepo {
    public boolean register(Customer c);
    public String login(String loginID , String pwd);
}
