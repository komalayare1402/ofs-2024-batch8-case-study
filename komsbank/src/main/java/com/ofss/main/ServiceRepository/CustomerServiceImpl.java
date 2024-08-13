package com.ofss.main.ServiceRepository;

import com.ofss.main.Repository.CustomerRepo;
import com.ofss.main.Repository.CustomerRepoImpl;
import com.ofss.main.domain.Customer;

public class CustomerServiceImpl implements CustomerService{

    CustomerRepo customerRepo = new CustomerRepoImpl();

    @Override
    public boolean register(Customer c) {
        return customerRepo.register(c);
    }

    @Override
    public String login(String loginID, String pwd) {
       return customerRepo.login(loginID, pwd);
    }
    
}
