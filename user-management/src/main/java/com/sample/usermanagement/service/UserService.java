package com.sample.usermanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.usermanagement.model.User;
import com.sample.usermanagement.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository usersRepository;

	@Override
	public List<User> getUsersByUser(String user) {
		System.out.println("Getting User List :: "+user);
		List<User> users= usersRepository.findByUserName(user);
		users.stream().forEach(System.out::println);
		return users;
	}

	@Override
	public Optional<User> getUserById(long id) {
		return usersRepository.findById(id);
	}

	@Override
	public void updateuser(User user) {
		usersRepository.save(user);
	}

	@Override
	public void adduser(String fullName, String desc, String targetDate, String Mobile, String Email) {
		usersRepository.save(new User(fullName,  Mobile, Email, targetDate));
	}

	@Override
	public void deleteuser(long id) {
		Optional<User> todo = usersRepository.findById(id);
		if (todo.isPresent()) {
			usersRepository.delete(todo.get());
		}
	}

	@Override
	public void saveuser(User user) {
		System.out.println("Inside Service to save data");
		usersRepository.save(user);
	}
}