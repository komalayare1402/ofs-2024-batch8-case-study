package com.ofss.main.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ofss.main.domain.Customer;

public interface CustomerRepo extends CrudRepository<Customer, Integer> {
    //public boolean register(Customer c);
	List<Customer> findByCustomerLoginId(String customerLoginId);
}