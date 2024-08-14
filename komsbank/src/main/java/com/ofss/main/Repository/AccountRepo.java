package com.ofss.main.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ofss.main.domain.Account;
import com.ofss.main.domain.Customer;

@Repository
public interface AccountRepo extends CrudRepository<Account, Integer> {
    //public String AccountType(int customerId, String accountType, int overdraft_amount); 
	public List<Account> findByCustomer(Customer customer);
}
