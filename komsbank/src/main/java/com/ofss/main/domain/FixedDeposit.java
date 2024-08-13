package com.ofss.main.domain;

public class FixedDeposit {
    private int DepositId;
    private int acc_id;
    private double amount;
    private double rate;
    private String created_at;
    private String expires_at;
    private String DepositType;
    public int getDepositId() {
        return DepositId;
    }
    public void setDepositId(int depositId) {
        DepositId = depositId;
    }
    public int getAcc_id() {
        return acc_id;
    }
    public void setAcc_id(int acc_id) {
        this.acc_id = acc_id;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public double getRate() {
        return rate;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }
    public String getCreated_at() {
        return created_at;
    }
    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
    public String getExpires_at() {
        return expires_at;
    }
    public void setExpires_at(String expires_at) {
        this.expires_at = expires_at;
    }
    public String getDepositType() {
        return DepositType;
    }
    public void setDepositType(String depositType) {
        DepositType = depositType;
    }
    
}
