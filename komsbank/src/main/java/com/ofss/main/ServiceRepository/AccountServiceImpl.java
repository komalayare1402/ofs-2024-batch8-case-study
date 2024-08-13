package com.ofss.main.ServiceRepository;

import com.ofss.main.Repository.*;

public class AccountServiceImpl implements AccountService {
    private AccountRepo accountRepo = new AccountRepoImpl();

    @Override
    public String AccountType(int customerId, String accountType, int overdraft_amount) {
        return accountRepo.AccountType(customerId, accountType, overdraft_amount);
    }

    
}
