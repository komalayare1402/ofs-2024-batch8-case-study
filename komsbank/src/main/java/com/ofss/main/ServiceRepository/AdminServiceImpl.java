package com.ofss.main.ServiceRepository;

import java.util.List;

import com.ofss.main.Repository.AdminRepo;
import com.ofss.main.Repository.AdminRepoImpl;
//import com.ofss.main.domain.Admin;
import com.ofss.main.domain.Account;

public class AdminServiceImpl implements AdminService {
    AdminRepo adminRepo = new AdminRepoImpl();

    @Override
    public String Adminlogin(String AdminloginID, String Adminpwd) {
        return adminRepo.Adminlogin(AdminloginID, Adminpwd);
    }

    @Override
    public String unblock(String customerloginId) {
        return adminRepo.unblock(customerloginId);
    }

    @Override
    public String Approve(Account account) {
        return adminRepo.Approve(account);
    }

    @Override
    public List<Account> getAccountId(int customerloginId) {
        return adminRepo.getAccountId(customerloginId);
    }

    
}
