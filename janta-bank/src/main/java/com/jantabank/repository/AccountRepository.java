package com.jantabank.repository;

import com.jantabank.entity.Account;

public interface AccountRepository 
{
	void saveAccount(Account account);
	int findAccountNoByUserId(String userid);
	int getAmount(int accountno);
	Account getAccount(Integer accountno);
	void updateAmount(Account account, int amount);
	String getNameByAccountno(int accountno);
}
