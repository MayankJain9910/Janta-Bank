package com.jantabank.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.jantabank.entity.User;
import com.jantabank.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository 
{
	private Session session;
	private Transaction transaction;
	
	//Constructor injection for SessionFactroy interface
	public UserRepositoryImpl(SessionFactory sessionFactory)
	{
		session=sessionFactory.openSession();
		transaction=session.getTransaction();
	}

	public void saveUser(User user) 
	{
		transaction.begin();
		session.persist(user);
		transaction.commit();
		
	}

	public User getUser(String userid) 
	{
		User user=session.get(User.class,userid);
		return user;
	}
}
