package com.ofss.main.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ofss.main.domain.Customer;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Integer> {
    //public boolean register(Customer c);
	List<Customer> findByCustomerLoginId(String customerLoginId);
}