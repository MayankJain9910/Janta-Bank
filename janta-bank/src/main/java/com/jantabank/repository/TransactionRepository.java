package com.jantabank.repository;

import java.util.List;

import com.jantabank.entity.TransactionInfo;

public interface TransactionRepository 
{
	void saveTransaction(TransactionInfo transactionInfo);
	List<TransactionInfo> getStatements(int accountno);
}
