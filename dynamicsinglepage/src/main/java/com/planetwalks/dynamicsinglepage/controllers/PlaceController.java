package com.planetwalks.dynamicsinglepage.controllers;

import com.planetwalks.dynamicsinglepage.CloudinaryUploader;
import com.planetwalks.dynamicsinglepage.models.City;
import com.planetwalks.dynamicsinglepage.models.Place;
import com.planetwalks.dynamicsinglepage.services.CitiesRepositoriesImpl;
import com.planetwalks.dynamicsinglepage.services.PlaceRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/place")
@CrossOrigin("*")
public class PlaceController {

	@Autowired
	private PlaceRepositoryImpl placeRepository;
	@Autowired
	private CitiesRepositoriesImpl citiesRepositories;

	private CloudinaryUploader cloudinaryUploader = new CloudinaryUploader();

	@PostMapping("/save")
	public Place create(@RequestParam("placeName") String placeName,
	                    @RequestParam("address") String address,
	                    @RequestParam("imageName") String imageName,
	                    @RequestParam("description") String descrition,
	                    @RequestParam("placeType") String placeType,
	                    @RequestParam("cityId") Long cityId) throws IOException {
		String imagePath = "Uploads/"+imageName+".jpg";
		Optional<City> city = citiesRepositories.findByCityId(cityId);
		City city1 = new City();
		city1.setCityId(city.get().getCityId());
		city1.setCityName(city.get().getCityName());
		city1.setPopulation(city.get().getPopulation());
		city1.setHistory(city.get().getHistory());
		city1.setWeatherConditions(city.get().getWeatherConditions());
		city1.setGeoLocation((city.get().getGeoLocation()));

		Place place = new Place();
		place.setPlaceName(placeName);
		place.setAddress(address);
		place.setImageName(cloudinaryUploader.uploadImage(imagePath));
		place.setDescription(descrition);
		place.setPlaceType(placeType);
		place.setCity(city1);
		return placeRepository.create(place);

	}

	@PutMapping("/update")
	public Place update(@RequestParam("placeId") Long placeId,
					    @RequestParam("placeName") String placeName,
	                    @RequestParam("address") String address,
	                    @RequestParam("imageName") String imageName,
	                    @RequestParam("description") String descrition,
	                    @RequestParam("placeType") String placeType,
	                    @RequestParam("cityId") Long cityId) throws IOException {
		String imagePath = "Uploads/"+imageName+".jpg";
		Optional<City> city = citiesRepositories.findByCityId(cityId);
		City city1 = new City();
		city1.setCityId(city.get().getCityId());
		city1.setCityName(city.get().getCityName());
		city1.setPopulation(city.get().getPopulation());
		city1.setHistory(city.get().getHistory());
		city1.setWeatherConditions(city.get().getWeatherConditions());
		city1.setGeoLocation((city.get().getGeoLocation()));

		Place place = new Place();
		place.setPlaceId(placeId);
		place.setPlaceName(placeName);
		place.setAddress(address);
		place.setImageName(cloudinaryUploader.uploadImage(imagePath));
		place.setDescription(descrition);
		place.setPlaceType(placeType);
		place.setCity(city1);
		return placeRepository.update(place);

	}
}
