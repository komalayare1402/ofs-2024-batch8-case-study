package com.ofss.main.ServiceRepository;

public interface TransactionService {
    public String MoneyTransaction(int PayeeAccountId, int PayerAccountId, int TransactionAmount, String TransactionType);

}
