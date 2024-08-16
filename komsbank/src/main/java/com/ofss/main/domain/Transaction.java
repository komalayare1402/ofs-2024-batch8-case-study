package com.ofss.main.domain;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
    private int id;
	
    private Account from_account;
    private Account to_account;
    
    @Column(name = "transaction_amount")
    private double amount;
    
    @Column(name = "transaction_status")
    private String status;
    
    @Column(name = "transaction_remarks")
    private String remarks;
    
    @Column(name = "transaction_created_at")
    private LocalDate created_at;
    
    @Column(name = "transaction_completed_at")
    private LocalDate completed_at;
    
    @Column(name = "transfer_type")
    private String transfer_type;
    
    @Column(name = "transaction_type")
    private String transaction_type;
    
    public Transaction() {
    	
    }
    
    public Transaction(int id, Account from_account, Account to_account, double amount, String status, String remarks,
			LocalDate created_at, LocalDate completed_at, String transfer_type, String transaction_type) {
		super();
		this.id = id;
		this.from_account = from_account;
		this.to_account = to_account;
		this.amount = amount;
		this.status = status;
		this.remarks = remarks;
		this.created_at = created_at;
		this.completed_at = completed_at;
		this.transfer_type = transfer_type;
		this.transaction_type = transaction_type;
	}



	public Account getFrom_account() {
        return from_account;
    }
    public void setFrom_account(Account from_account) {
        this.from_account = from_account;
    }
    public Account getTo_account() {
        return to_account;
    }
    public void setTo_account(Account to_account) {
        this.to_account = to_account;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getCreated_at() {
        return created_at.toString();
    }
    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }
    public String getCompleted_at() {
        return completed_at.toString();
    }
    public void setCompleted_at(LocalDate completed_at) {
        this.completed_at = completed_at;
    }
    public String getTransfer_type() {
        return transfer_type;
    }
    public void setTransfer_type(String transfer_type) {
        this.transfer_type = transfer_type;
    }
    public String getTransaction_type() {
        return transaction_type;
    }
    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }
    
}
