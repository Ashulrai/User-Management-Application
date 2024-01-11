package com.sample.usermanagement.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.usermanagement.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	List<User> findByUserName(String user);
}
