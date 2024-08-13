package com.ofss.main.ServiceRepository;

import java.util.List;

import com.ofss.main.domain.Account;

public interface AdminService {
    public String Adminlogin(String AdminloginID , String Adminpwd);

    public String unblock(String customerloginId);

    public List<Account> getAccountId(int customerloginId);
    public String Approve(Account account);
}
