package com.jantabank.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.jantabank.entity.Account;
import com.jantabank.repository.AccountRepository;


@Repository
public class AccountRepositoryImpl implements AccountRepository 
{
	private Session session;
	private Transaction transaction;
	
	//Constructor injection for SessionFactroy interface
	public AccountRepositoryImpl(SessionFactory sessionFactory)
	{
		session=sessionFactory.openSession();
		transaction=session.getTransaction();
	}
	public void saveAccount(Account account) 
	{
		transaction.begin();
		session.persist(account);
		transaction.commit();
	}
	public int findAccountNoByUserId(String userid) 
	{
		Query<Integer> query=session.createQuery("select accountno from Account where userid=:arg",Integer.class);
		query.setParameter("arg",userid);
		int accountno=query.uniqueResult();
		return accountno;
	}
	public int getAmount(int accountno) 
	{
		Query<Integer> query=session.createQuery("select amount from Account where accountno=:arg",Integer.class);
		query.setParameter("arg",accountno);
		int amount=query.uniqueResult();
		return amount;
	}
	public Account getAccount(Integer accountno) 
	{
		return session.get(Account.class,accountno);
	}
	public void updateAmount(Account account, int amount) 
	{
		transaction.begin();
		account.setAmount(account.getAmount()+amount);
		transaction.commit();
	}
	public String getNameByAccountno(int accountno) 
	{
		Query<String> query=session.createQuery("select concat(firstname,' ',lastname) from Account a join User u on a.userid=u.userid where a.accountno=:arg",String .class);
		query.setParameter("arg",accountno);
		String name=query.uniqueResult();
		return name;
	}
}
