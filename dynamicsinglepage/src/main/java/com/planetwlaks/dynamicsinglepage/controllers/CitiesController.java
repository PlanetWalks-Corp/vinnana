package com.planetwlaks.dynamicsinglepage.controllers;

import com.planetwlaks.dynamicsinglepage.models.Cities;
import com.planetwlaks.dynamicsinglepage.services.CitiesRepositoriesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CitiesController {

	@Autowired
	private  CitiesRepositoriesImpl citiesRepositories;

	@GetMapping("/")
	public List<Cities> getCities(){
		return citiesRepositories.getAll();
	}

	@PostMapping("/save")
	public void saveCity(@RequestParam("name") String name){
		Cities city = new Cities();
		city.setCityName(name);
		citiesRepositories.create(city);
	}

	@PutMapping("/update")
	public void updateCity(@RequestParam("id") Long id,
	                       @RequestParam("name") String name){
		Cities city = new Cities(id, name);
		citiesRepositories.create(city);
	}
}
