package com.jantabank.repository;

import com.jantabank.entity.User;

public interface UserRepository 
{
	void saveUser(User user);
	User getUser(String userid);
}
