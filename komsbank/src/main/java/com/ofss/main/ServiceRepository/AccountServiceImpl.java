package com.ofss.main.ServiceRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.Repository.*;
import com.ofss.main.domain.Account;
import com.ofss.main.domain.Customer;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepo accountRepo;
	
	@Autowired
	CustomerRepo customerRepo;

//    @Override
//    public String AccountType(int customerId, String accountType, int overdraft_amount) {
//        return accountRepo.AccountType(customerId, accountType, overdraft_amount);
//    }

	@Override
	public List<Account> getAllAccounts(int customer_id) {
	Optional<Customer> OptionalCustomer = customerRepo.findById(customer_id);
	if(OptionalCustomer.isPresent()) {
		Customer customer = OptionalCustomer.get();
		List<Account> accounts = accountRepo.findByCustomer(customer);
		return accounts;
	}
		return null;
	}
}
