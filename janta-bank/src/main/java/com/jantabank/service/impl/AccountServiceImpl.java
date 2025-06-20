package com.jantabank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jantabank.entity.Account;
import com.jantabank.entity.TransactionInfo;
import com.jantabank.repository.AccountRepository;
import com.jantabank.service.AccountService;
import com.jantabank.service.TransactionService;

@Service
public class AccountServiceImpl implements AccountService 
{
	@Autowired private AccountRepository accountRepository;
	@Autowired private TransactionService transactionService;

	public TransactionInfo depositAmount(int amount, Integer accountno) 
	{
		//Update amount unto Account object
		Account account=accountRepository.getAccount(accountno);
		accountRepository.updateAmount(account,amount);
		//Create object of TransactionInfo class and persist it into table
		return transactionService.saveDepositTransaction(accountno,amount);
	}

	public int getAccountBalance(int accountno) 
	{
		return accountRepository.getAmount(accountno);
	}

	public TransactionInfo withdrawAmount(int amount, int accountno) 
	{
		//Update amount unto Account object
		Account account=accountRepository.getAccount(accountno);
		accountRepository.updateAmount(account,-amount);
		//Create object of TransactionInfo class and persist it into table
		return transactionService.saveWithdrawTransaction(accountno,amount);
	}

	public String getAccountHolder(int accountno) 
	{
		String name=accountRepository.getNameByAccountno(accountno);
		return name;
	}

	public TransactionInfo transferMoney(int amount, int accountno, int raccountno) 
	{
		//Updating sender amount
		Account account=accountRepository.getAccount(accountno);
		accountRepository.updateAmount(account,-amount);
		//Updating receiver amount
		account=accountRepository.getAccount(raccountno);
		accountRepository.updateAmount(account,amount);
		return transactionService.saveTransferTransaction(accountno,amount,raccountno);
	}
}
