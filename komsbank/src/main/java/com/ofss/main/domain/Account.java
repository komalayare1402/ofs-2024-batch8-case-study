package com.ofss.main.domain;
import java.util.*;

public class Account {

    private int accountId;
    private String accountType;
    private double accountRate;
    private double accountBalance;
    private double accountMinBalance;
    private String accountStatus;
    private int withdrawalLimit;

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

    private int overdraft_amount;
    private Customer customer;
    private List<Transaction> txns;
    private List<Cheque> cheques;


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

    public int getWithdrawalLimit() {
        return withdrawalLimit;
    }

    public void setWithdrawalLimit(int withdrawalLimit) {
        this.withdrawalLimit = withdrawalLimit;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Transaction> getTxns() {
        return txns;
    }

    public void setTxns(List<Transaction> txns) {
        this.txns = txns;
    }
    
    public List<Cheque> getCheques() {
        return cheques;
    }

    public void setCheques(List<Cheque> cheques) {
        this.cheques = cheques;
    }

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
