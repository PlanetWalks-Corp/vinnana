package com.planetwalks.dynamicsinglepage.controllers;

import com.planetwalks.dynamicsinglepage.models.Cities;
import com.planetwalks.dynamicsinglepage.models.Place;
import com.planetwalks.dynamicsinglepage.services.CitiesRepositoriesImpl;
import com.planetwalks.dynamicsinglepage.services.PlaceRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/place")
@CrossOrigin("*")
public class PlaceController {

	@Autowired
	private PlaceRepositoryImpl placeRepository;
	@Autowired
	private CitiesRepositoriesImpl citiesRepositories;

	@PostMapping("/save")
	public Place create(@RequestParam("placeName") String placeName,
	                    @RequestParam("address") String address,
	                    @RequestParam("imageName") String imageName,
	                    @RequestParam("description") String descrition,
	                    @RequestParam("placeType") String placeType,
	                    @RequestParam("cityId") Long cityId){
		Optional<Cities> city = citiesRepositories.findByCityId(cityId);
		Cities city1 = new Cities();
		city1.setCityId(city.get().getCityId());
		city1.setCityName(city.get().getCityName());
		city1.setPopulation(city.get().getPopulation());
		city1.setHistory(city.get().getHistory());
		city1.setWeatherConditions(city.get().getWeatherConditions());
		city1.setGeoLocation((city.get().getGeoLocation()));

		Place place = new Place();
		place.setPlaceName(placeName);
		place.setAddress(address);
		place.setImageName(imageName);
		place.setDescription(descrition);
		place.setPlaceType(placeType);
		place.setCities(city1);
		return placeRepository.create(place);

	}
}
