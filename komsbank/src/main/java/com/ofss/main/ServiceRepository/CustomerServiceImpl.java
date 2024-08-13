package com.ofss.main.ServiceRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.ofss.main.Repository.CustomerRepo;
import com.ofss.main.domain.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepo customerRepo;

//    @Override
//    public boolean register(Customer c) {
//        return customerRepo.register(c);
//    }

    @Override
    public String login(String customerLoginId, String customerPassword) {
    	List<Customer> customer = customerRepo.findByCustomerLoginId(customerLoginId);
    	System.out.println(customer.get(0));
    	if(customer.isEmpty()) {
    		return "Login failed";
    	}
    	else {
    		if(customer.get(0).getCustomerPassword().equals(customerPassword)) {
    			return "Login Successfull";
    		}
    		else {
    			Customer customer1 = customer.get(0);
    			customer1.setLoginAttempts(customer1.getLoginAttempts()+1);
    			
    			if(customer1.getLoginAttempts()==3) {
    				customer1.setCustomerStatus("Inactive");
    			}
    			customerRepo.save(customer1);
    			return "Password incorrect";
    		}
    		
    	}
    }

	@Override
	public String register(Customer customer) {
		try {
			customerRepo.save(customer);
            System.out.println("register true");
            return "true";  // Registration successful
        } catch (DataAccessException e) {
            // Log the exception
            Logger logger = LoggerFactory.getLogger(getClass());
            logger.error("Error occurred while saving customer: ", e);
            return "false";  // Registration failed
        } catch (Exception e) {
            // Log unexpected exceptions
            Logger logger = LoggerFactory.getLogger(getClass());
            logger.error("Unexpected error occurred while saving customer: ", e);
            System.out.println(customer);
            return "false";  // Registration failed
        }
	}
}
