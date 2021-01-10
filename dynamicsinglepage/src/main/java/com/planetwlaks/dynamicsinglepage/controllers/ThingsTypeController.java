package com.planetwlaks.dynamicsinglepage.controllers;

import com.planetwlaks.dynamicsinglepage.models.ThingsTypes;
import com.planetwlaks.dynamicsinglepage.services.ThingsTypesRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/things/types")
public class ThingsTypeController {

	@Autowired
	private ThingsTypesRepositoryImpl thingsTypesRepository;

	@GetMapping("")
	public List<ThingsTypes> getTypes(){
		return thingsTypesRepository.getAll();
	}

	@PostMapping("/save")
	public ThingsTypes saveType(@RequestParam("name") String name){
		ThingsTypes thingsTypes = new ThingsTypes();
		thingsTypes.setName(name);
		thingsTypesRepository.create(thingsTypes);
		return thingsTypes;
	}
}
