package com.jantabank.service;

import com.jantabank.entity.TransactionInfo;

public interface AccountService 
{
	TransactionInfo depositAmount(int amount, Integer attribute);
	int getAccountBalance(int accountno);
	TransactionInfo withdrawAmount(int amount, int accountno);
	String getAccountHolder(int accountno);
	TransactionInfo transferMoney(int amount, int accountno, int raccountno);
}
