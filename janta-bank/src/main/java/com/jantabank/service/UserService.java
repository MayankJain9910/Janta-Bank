package com.jantabank.service;

import com.jantabank.entity.User;

public interface UserService 
{
	int createUser(User user);
	User getUser(String userid);
}
