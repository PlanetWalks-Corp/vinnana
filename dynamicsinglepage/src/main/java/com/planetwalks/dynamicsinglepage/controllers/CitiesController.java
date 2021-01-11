package com.planetwalks.dynamicsinglepage.controllers;

import com.planetwalks.dynamicsinglepage.models.Cities;
import com.planetwalks.dynamicsinglepage.services.CitiesRepositoriesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

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

	@GetMapping("/id")
	public Optional<Cities> getCityById(@RequestParam("cityId") Long cityId){
		return citiesRepositories.findByCityId(cityId);
	}

	@PostMapping("/save")
	public Cities saveCity(@RequestParam("cityName")String cityName,
	                       @RequestParam("geoLocation") String geoLocation,
	                       @RequestParam("history") String history,
	                       @RequestParam("weatherConditions") String weatherCondition,
	                       @RequestParam("population") Long population){
		Cities city = new Cities();
		city.setCityName(cityName);
		city.setGeoLocation(geoLocation);
		city.setHistory(history);
		city.setWeatherConditions(weatherCondition);
		city.setPopulation(population);
		return citiesRepositories.create(city);

	}
}
