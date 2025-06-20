package com.jantabank.service;

import com.jantabank.entity.TransactionInfo;

public interface TransactionService 
{
	TransactionInfo saveDepositTransaction(int accountno, int amount);
	TransactionInfo saveWithdrawTransaction(int accountno, int amount);
	TransactionInfo saveTransferTransaction(int accountno, int amount, int raccountno);
}
