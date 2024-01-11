package com.sample.usermanagement.service;

import java.util.List;
import java.util.Optional;

import com.sample.usermanagement.model.User;

public interface IUserService {

	List<User> getUsersByUser(String user);

	Optional<User> getUserById(long id);

	void updateuser(User todo);

	void adduser(String fullName, String desc, String targetDate, String Mobile, String Email);

	void deleteuser(long id);
	
	void saveuser(User todo);

}