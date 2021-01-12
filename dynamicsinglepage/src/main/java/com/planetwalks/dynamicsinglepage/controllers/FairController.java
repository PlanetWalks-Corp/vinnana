package com.planetwalks.dynamicsinglepage.controllers;

import com.planetwalks.dynamicsinglepage.models.Cities;
import com.planetwalks.dynamicsinglepage.models.Fair;
import com.planetwalks.dynamicsinglepage.services.CitiesRepositoriesImpl;
import com.planetwalks.dynamicsinglepage.services.FairRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/fair")
@CrossOrigin("*")
public class FairController {

	@Autowired
	private FairRepositoryImpl fairRepository;
	@Autowired
	private CitiesRepositoriesImpl citiesRepositories;

	@PostMapping("/save")
	public Fair create(@RequestParam("fairName") String fairName,
	                   @RequestParam("description") String description,
	                   @RequestParam("fairType") String fairType,
	                   @RequestParam("imageName") String imageName,
	                   @RequestParam("cityId") Long cityId){
		Optional<Cities> city = citiesRepositories.findByCityId(cityId);
		Cities city1 = new Cities();
		city1.setCityId(city.get().getCityId());
		city1.setCityName(city.get().getCityName());
		city1.setPopulation(city.get().getPopulation());
		city1.setHistory(city.get().getHistory());
		city1.setWeatherConditions(city.get().getWeatherConditions());
		city1.setGeoLocation((city.get().getGeoLocation()));


		Fair fair = new Fair();
		fair.setFairName(fairName);
		fair.setDescription(description);
		fair.setFairType(fairType);
		fair.setImageName(imageName);
		fair.setCities(city1);
		return fairRepository.create(fair);

	}
}
