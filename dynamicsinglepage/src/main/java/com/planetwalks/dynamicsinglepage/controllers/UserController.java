package com.planetwalks.dynamicsinglepage.controllers;

import com.planetwalks.dynamicsinglepage.models.User;
import com.planetwalks.dynamicsinglepage.services.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepositoryImpl userRepository;

	@GetMapping("")
	public List<User> getAll(){
		return userRepository.getAllUsers();
	}

	@GetMapping("/{id}")
	public Optional<User> findById(@PathVariable Long id){
		return userRepository.findById(id);
	}

	@PostMapping("save")
	public User create(@RequestParam("firstName") String firstName,
	                   @RequestParam("lastName") String lastName,
	                   @RequestParam("username") String username,
	                   @RequestParam("password") String password){
		User user  = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUsername(username);
		user.setPassword(password);
		return userRepository.create(user);
	}
}
