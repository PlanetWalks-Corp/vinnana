package com.planetwalks.dynamicsinglepage.controllers;

import com.planetwalks.dynamicsinglepage.CloudinaryUploader;
import com.planetwalks.dynamicsinglepage.models.City;
import com.planetwalks.dynamicsinglepage.models.Fair;
import com.planetwalks.dynamicsinglepage.services.CitiesRepositoriesImpl;
import com.planetwalks.dynamicsinglepage.services.FairRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/fair")
@CrossOrigin("*")
public class FairController {

	@Autowired
	private FairRepositoryImpl fairRepository;
	@Autowired
	private CitiesRepositoriesImpl citiesRepositories;

	private CloudinaryUploader cloudinaryUploader = new CloudinaryUploader();

	@PostMapping("/save")
	public Fair create(@RequestParam("fairName") String fairName,
	                   @RequestParam("description") String description,
	                   @RequestParam("fairType") String fairType,
	                   @RequestParam("imageName") MultipartFile imageName,
	                   @RequestParam("cityId") Long cityId) throws IOException {
		Optional<City> city = citiesRepositories.findByCityId(cityId);
		City city1 = new City();
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
		fair.setImageName(cloudinaryUploader.upload(imageName));
		fair.setCity(city1);
		return fairRepository.create(fair);

	}

	@PutMapping("/update")
	public Fair update(@RequestParam("fairId") Long fairId,
			           @RequestParam("fairName") String fairName,
	                   @RequestParam("description") String description,
	                   @RequestParam("fairType") String fairType,
	                   @RequestParam("imageName") MultipartFile imageName,
	                   @RequestParam("cityId") Long cityId) throws IOException {
		Optional<City> city = citiesRepositories.findByCityId(cityId);
		City city1 = new City();
		city1.setCityId(city.get().getCityId());
		city1.setCityName(city.get().getCityName());
		city1.setPopulation(city.get().getPopulation());
		city1.setHistory(city.get().getHistory());
		city1.setWeatherConditions(city.get().getWeatherConditions());
		city1.setGeoLocation((city.get().getGeoLocation()));


		Fair fair = new Fair();
		fair.setFairId(fairId);
		fair.setFairName(fairName);
		fair.setDescription(description);
		fair.setFairType(fairType);
		fair.setImageName(cloudinaryUploader.upload(imageName));
		fair.setCity(city1);
		return fairRepository.update(fair);

	}
}
