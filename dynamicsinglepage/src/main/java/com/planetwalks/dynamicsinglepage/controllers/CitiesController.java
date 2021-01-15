package com.planetwalks.dynamicsinglepage.controllers;

import com.planetwalks.dynamicsinglepage.models.City;
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
	private final CitiesRepositoriesImpl citiesRepositories;

	public CitiesController(CitiesRepositoriesImpl citiesRepositories) {
		this.citiesRepositories = citiesRepositories;
	}

	@GetMapping("")
	public List<City> getCities(){
		return citiesRepositories.getAll();
	}

	@GetMapping("/{cityId}")
	public Optional<City> getCityById(@PathVariable Long cityId){
		return citiesRepositories.findByCityId(cityId);
	}

	@PostMapping("/save")
	public City saveCity(@RequestParam("cityName")String cityName,
	                     @RequestParam("geoLocation") String geoLocation,
	                     @RequestParam("history") String history,
	                     @RequestParam("weatherConditions") String weatherCondition,
	                     @RequestParam("population") Long population){
		City city = new City();
		city.setCityName(cityName);
		city.setGeoLocation(geoLocation);
		city.setHistory(history);
		city.setWeatherConditions(weatherCondition);
		city.setPopulation(population);
		return citiesRepositories.create(city);

	}
}
