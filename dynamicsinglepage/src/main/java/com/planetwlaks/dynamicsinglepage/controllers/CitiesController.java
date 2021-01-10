package com.planetwlaks.dynamicsinglepage.controllers;

import com.planetwlaks.dynamicsinglepage.models.Cities;
import com.planetwlaks.dynamicsinglepage.services.CitiesRepositoriesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
@CrossOrigin("*")
public class CitiesController {

	@Autowired
	private  CitiesRepositoriesImpl citiesRepositories;

	@GetMapping("")
	public List<Cities> getCities(){
		return citiesRepositories.getAll();
	}

	@PostMapping(value = "/save", consumes={MediaType.MULTIPART_FORM_DATA_VALUE})
	public Cities saveCity(@RequestParam("name") String name,
	                     @RequestParam("image") String image){
		Cities city = new Cities();
		city.setCityName(name);
		city.setImage(image);
		citiesRepositories.create(city);
		return city;
	}

	@PutMapping("/update")
	public Cities updateCity(@RequestParam("id") Long id,
	                       @RequestParam("name") String name,
	                       @RequestParam("image") String image){
		Cities city = new Cities(id, name, image);
		citiesRepositories.create(city);
		return city;
	}
}
