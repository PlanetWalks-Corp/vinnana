package com.planetwalks.dynamicsinglepage.controllers;

import com.planetwalks.dynamicsinglepage.models.Album;
import com.planetwalks.dynamicsinglepage.models.City;
import com.planetwalks.dynamicsinglepage.services.AlbumRepositoryImpl;
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
<<<<<<< HEAD
	private  CitiesRepositoriesImpl citiesRepositories;
	@Autowired
	private AlbumRepositoryImpl albumRepository;
=======
	private final CitiesRepositoriesImpl citiesRepositories;

	public CitiesController(CitiesRepositoriesImpl citiesRepositories) {
		this.citiesRepositories = citiesRepositories;
	}
>>>>>>> b0f62a90076af857b5045f6ffcc2648def32fc72

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

		City res = citiesRepositories.create(city);

		Album album = new Album();
		album.setAlbumName(cityName);
		album.setCity(city);
		Album resAlbum = albumRepository.create(album);
		System.out.println(resAlbum);
		return res;

	}

	@PutMapping("/update")
	public City updateCity(@RequestParam("cityId") Long cityId,
						 @RequestParam("cityName")String cityName,
	                     @RequestParam("geoLocation") String geoLocation,
	                     @RequestParam("history") String history,
	                     @RequestParam("weatherConditions") String weatherCondition,
	                     @RequestParam("population") Long population){
		City city = new City();
		city.setCityId(cityId);
		city.setCityName(cityName);
		city.setGeoLocation(geoLocation);
		city.setHistory(history);
		city.setWeatherConditions(weatherCondition);
		city.setPopulation(population);
		return citiesRepositories.update(city);

	}
}
