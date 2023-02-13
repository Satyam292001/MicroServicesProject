package com.user.service;

import java.util.List;

import com.user.entities.User;

public interface UserService {

	User create(User user);
	
	List<User> getAllUser();
	
	User getSingleUser(String id);
}
