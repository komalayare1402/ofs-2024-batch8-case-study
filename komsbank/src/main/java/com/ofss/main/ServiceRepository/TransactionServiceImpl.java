package com.ofss.main.ServiceRepository;

import com.ofss.main.Repository.TransactionRepo;
import com.ofss.main.Repository.TransactionRepoImpl;

public class TransactionServiceImpl implements TransactionService {
    private TransactionRepo transactionService = new TransactionRepoImpl();

    @Override
    public String MoneyTransaction(int PayeeAccountId, int PayerAccountId, int TransactionAmount,
            String TransactionType) {
        return transactionService.MoneyTransaction(PayeeAccountId, PayerAccountId, TransactionAmount, TransactionType);
        }
}
