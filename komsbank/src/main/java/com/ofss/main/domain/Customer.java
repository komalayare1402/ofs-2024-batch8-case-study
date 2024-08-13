package com.ofss.main.domain;

import java.util.List;

public class Customer {
    public Customer(String customerName, String customer_email, String customerPhone, String customerAddress,
            String customerState, String customerCountry, String customerLoginId, String customerPassword) {
        this.customerName = customerName;
        this.customer_email = customer_email;
        this.customerPhone = customerPhone;
        this.customerAddress = customerAddress;
        this.customerState = customerState;
        this.customerCountry = customerCountry;
        this.customerLoginId = customerLoginId;
        this.customerPassword = customerPassword;
    }

    private int customerId;
    private String customerName;
    private String customer_email;
    private String customerPhone;
    private String customerAddress;
    private String customerState;
    private String customerCountry;
    private String customerLoginId;
    private String customerPassword;
    private String customerStatus;
    private int loginAttempts;
    List<Savings> savingAcc;
    List<Current> currentAcc;

    public int getLoginAttempts() {
        return loginAttempts;
    }

    public void setLoginAttempts(int loginAttempts) {
        this.loginAttempts = loginAttempts;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomerLoginId() {
        return customerLoginId;
    }

    public void setCustomerLoginId(String customerLoginId) {
        this.customerLoginId = customerLoginId;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerState() {
        return customerState;
    }

    public void setCustomerState(String customerState) {
        this.customerState = customerState;
    }

    public String getCustomerCountry() {
        return customerCountry;
    }

    public void setCustomerCountry(String customerCountry) {
        this.customerCountry = customerCountry;
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }

    public List<Savings> getSavingAcc() {
        return savingAcc;
    }

    public void setSavingAcc(List<Savings> savingAcc) {
        this.savingAcc = savingAcc;
    }

    public List<Current> getCurrentAcc() {
        return currentAcc;
    }

    public void setCurrentAcc(List<Current> currentAcc) {
        this.currentAcc = currentAcc;
    }

}
