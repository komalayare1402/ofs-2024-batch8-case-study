package com.ofss.main.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
    private int customerId;
	
	@Column(name="customer_name")
    private String customerName;
	
	@Column(name="customer_email")
    private String customer_email;
	
	@Column(name="customer_phone")
    private String customerPhone;
	
	@Column(name="customer_address")
    private String customerAddress;
	
	@Column(name="customer_state")
    private String customerState;
	
	@Column(name="customer_country")
    private String customerCountry;
	
	@Column(name="customer_login_id")
    private String customerLoginId;
	
	@Column(name="customer_password")
    private String customerPassword;
	
	@Column(name="customer_status")
    private String customerStatus;
	
	@Column(name="login_attempts")
    private int loginAttempts;
	
//    List<Savings> savingAcc;
//    List<Current> currentAcc;
    
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
    
    public Customer() {
    	
    }

    @Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customer_email="
				+ customer_email + ", customerPhone=" + customerPhone + ", customerAddress=" + customerAddress
				+ ", customerState=" + customerState + ", customerCountry=" + customerCountry + ", customerLoginId="
				+ customerLoginId + ", customerPassword=" + customerPassword + ", customerStatus=" + customerStatus
				+ ", loginAttempts=" + loginAttempts + "]";
	}

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

//    public List<Savings> getSavingAcc() {
//        return savingAcc;
//    }
//
//    public void setSavingAcc(List<Savings> savingAcc) {
//        this.savingAcc = savingAcc;
//    }
//
//    public List<Current> getCurrentAcc() {
//        return currentAcc;
//    }
//
//    public void setCurrentAcc(List<Current> currentAcc) {
//        this.currentAcc = currentAcc;
//    }

}
