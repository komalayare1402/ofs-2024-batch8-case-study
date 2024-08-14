package com.ofss.main.ServiceRepository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ofss.main.domain.Account;

@Service
public interface AccountService {
   // public String AccountType(int customerId, String accountType, int overdraft_amount);
	List<Account> getAllAccounts(int customer_id);
}
