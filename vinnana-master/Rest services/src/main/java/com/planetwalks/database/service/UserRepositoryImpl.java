package com.planetwalks.database.service;

import com.planetwalks.database.model.User;
import com.planetwalks.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRepositoryImpl {

	@Autowired
	public UserRepository userRepository;

	public User create(User user){
		return userRepository.save(user);
	}

	public List<User> getAll(){
		return userRepository.findAll();
	}
}
