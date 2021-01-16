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
	private CitiesRepositoriesImpl citiesRepositories;

	public CitiesController() {

	}

	@GetMapping("")
	public List<City> getCities(){
		return citiesRepositories.getAll();
	}

	@GetMapping("/{cityId}")
	public City getCityById(@PathVariable String cityId){
		City city;
		try{

			Long long_identifier = Long.parseLong(cityId);
			city = this.citiesRepositories.findByCityId(long_identifier).get();
		}
			catch(Exception e){
			System.out.println("exception caught");
			city = this.citiesRepositories.findBySlug(cityId).get();

			}
	return city;
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
