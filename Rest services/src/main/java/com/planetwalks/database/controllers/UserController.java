package com.planetwalks.database.controllers;

import com.planetwalks.database.model.User;
import com.planetwalks.database.service.UserRepositoryImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/rest")
public class UserController {

	private final UserRepositoryImpl userRepository;


	public UserController(UserRepositoryImpl userRepository) {
		this.userRepository = userRepository;
	}

	@PostMapping("/save")
	public String saveUser(@RequestParam("name") String name,
	                            @RequestParam("address") String address,
	                            @RequestParam("phoneNo") Long phNo){
		if(name.length()<1 || address.length()<1 || Long.toString(phNo).length()<10){
			return "plzz fill the details properly";
		}
		User user = new User();
		user.setName(name);
		user.setAddress(address);
		user.setPhNo(phNo);

		userRepository.create(user);
		return user.toString()+" saved";
	}

	@GetMapping("/getUsers")
	public List<User> getUsers(){
		return userRepository.getAll();
	}
}
