package com.ofss.main.domain;
import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="Account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="account_id")
    private int accountId;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
	@Column(name="account_type")
    private String accountType;
	
	@Column(name="account_rate")
    private double accountRate;
	
	@Column(name="account_balance")
    private double accountBalance;
	
	@Column(name="account_minimum_balance")
    private double accountMinBalance;
	
	@Column(name="account_status")
    private String accountStatus;
	
	@Column(name="overdraft_amount")
    private int overdraft_amount;

    public Account(int accountId, String accountType, double accountRate, double accountBalance,
            double accountMinBalance, String accountStatus, int overdraft_amount) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.accountRate = accountRate;
        this.accountBalance = accountBalance;
        this.accountMinBalance = accountMinBalance;
        this.accountStatus = accountStatus;
        this.overdraft_amount = overdraft_amount;
    }

    public int getOverdraft_amount() {
        return overdraft_amount;
    }

    public void setOverdraft_amount(int overdraft_amount) {
        this.overdraft_amount = overdraft_amount;
    }


    

    
//    private List<Transaction> txns;
//    private List<Cheque> cheques;


    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getAccountRate() {
        return accountRate;
    }

    public void setAccountRate(double accountRate) {
        this.accountRate = accountRate;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public double getAccountMinBalance() {
        return accountMinBalance;
    }

    public void setAccountMinBalance(double accountMinBalance) {
        this.accountMinBalance = accountMinBalance;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }
    
    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

//    public List<Transaction> getTxns() {
//        return txns;
//    }
//
//    public void setTxns(List<Transaction> txns) {
//        this.txns = txns;
//    }
//    
//    public List<Cheque> getCheques() {
//        return cheques;
//    }
//
//    public void setCheques(List<Cheque> cheques) {
//        this.cheques = cheques;
//    }

    public Account(){

    }
    
    public String toString(){
        return "Account Id : " + accountId; 
    }

    public Account(int no , String n , double bal){
        this.accountId = no;
        this.accountType=n;
        this.accountBalance = bal;
    }

    public boolean withdraw(double amount){
        if(amount > accountBalance || amount<=0){
            return false;
        }
        this.accountBalance-=amount;
        return true;
    }

    public boolean deposit(double amount){
        if(amount<0){
            return false;
        }
        this.accountBalance+=amount;
        return true;
    }
}
