package com.ofss.main.Repository;

import org.springframework.data.repository.CrudRepository;

import com.ofss.main.domain.Transaction;

public interface TransactionRepo extends CrudRepository<Transaction, Integer> {
    //public String MoneyTransaction(int PayeeAccountId, int PayerAccountId, int TransactionAmount, String TrasactionType );
}
