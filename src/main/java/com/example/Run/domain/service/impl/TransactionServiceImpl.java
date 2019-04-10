package com.example.Run.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Run.domain.entity.Transaction;
import com.example.Run.domain.repository.TransactionRepository;
import com.example.Run.domain.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService{
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public List<Transaction> getAllTransaction() {
		
		return transactionRepository.findAll();
	}

	@Override
	public Transaction createTransaction(Transaction transaction) {
		
		return transactionRepository.save(transaction);
	}

	@Override
	public Transaction Update(Transaction transaction) {
		
		return transactionRepository.save(transaction);
	}

	@Override
	public void deleteTransactionById(long id) {
		
		transactionRepository.deleteById(id);
	}

	@Override
	public Optional<Transaction> findById(long id) {
		
		return transactionRepository.findById(id);
	}
}
