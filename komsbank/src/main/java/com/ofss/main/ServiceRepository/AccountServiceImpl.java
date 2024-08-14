package com.ofss.main.ServiceRepository;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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

	@Override
	public String AccRegister(Account account) {
		try {
			Optional<Customer> optionalCust = customerRepo.findById(account.getCustomer().getCustomerId());
			Customer customer = optionalCust.get();
			account.setCustomer(customer);
			accountRepo.save(account);
            System.out.println("register true");
            return "true";  // Registration successful
        } catch (DataAccessException e) {
            // Log the exception
            Logger logger = LoggerFactory.getLogger(getClass());
            logger.error("Error occurred while Creating Account: ", e);
            return "false";  // Registration failed
        } catch (Exception e) {
            // Log unexpected exceptions
            Logger logger = LoggerFactory.getLogger(getClass());
            logger.error("Unexpected error occurred while Creating Account: ", e);
            System.out.println(account);
            return "false";  // Registration failed
        }
	}
}
