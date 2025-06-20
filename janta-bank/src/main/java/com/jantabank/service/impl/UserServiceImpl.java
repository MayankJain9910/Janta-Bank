package com.jantabank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jantabank.entity.Account;
import com.jantabank.entity.User;
import com.jantabank.repository.AccountRepository;
import com.jantabank.repository.UserRepository;
import com.jantabank.service.UserService;

@Service
public class UserServiceImpl implements UserService 
{
	//Field injection
	@Autowired private UserRepository userRepository;
	@Autowired private AccountRepository accountRepository;


	public int createUser(User user) 
	{
		//Save user object into database
		userRepository.saveUser(user);
		Account account=new Account();
		account.setUserid(user.getUserid());
		//Save account object into database
		accountRepository.saveAccount(account);
		return account.getAccountno();
	}

	public User getUser(String userid) 
	{
		return userRepository.getUser(userid);
	}
}
