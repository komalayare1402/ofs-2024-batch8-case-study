package com.ofss.main.Repository;

public interface TransactionRepo {
    public String MoneyTransaction(int PayeeAccountId, int PayerAccountId, int TransactionAmount, String TrasactionType );
}
