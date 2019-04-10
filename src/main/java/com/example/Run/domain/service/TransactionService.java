package com.example.Run.domain.service;

import java.util.List;
import java.util.Optional;


import com.example.Run.domain.entity.Transaction;

public interface TransactionService {
	public List<Transaction> getAllTransaction();
	public Transaction createTransaction(Transaction transaction);
	public Transaction Update(Transaction transaction);
	public void deleteTransactionById(long id);
	public Optional<Transaction> findById(long id);
}
