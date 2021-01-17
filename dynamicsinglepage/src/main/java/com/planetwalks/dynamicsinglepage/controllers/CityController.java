package com.planetwalks.dynamicsinglepage.controllers;

import com.planetwalks.dynamicsinglepage.models.Album;
import com.planetwalks.dynamicsinglepage.models.City;
import com.planetwalks.dynamicsinglepage.services.AlbumRepositoryImpl;
import com.planetwalks.dynamicsinglepage.services.CityRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
@CrossOrigin("*")

public class CityController {
	@Autowired
	private CityRepositoryImpl cityRepository;
	@Autowired
	private AlbumRepositoryImpl albumRepository;

	public CityController() {

	}

	@GetMapping("")
	public List<City> getCities(){
		return cityRepository.getAll();
	}

	@GetMapping("/{cityId}")
	public City getCityById(@PathVariable String cityId){
		City city;
		try{

			Long long_identifier = Long.parseLong(cityId);
			city = this.cityRepository.findByCityId(long_identifier).get();
		}
			catch(Exception e){
			System.out.println("exception caught");
			city = this.cityRepository.findBySlug(cityId).get();

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
        city.setSlug(cityName);
		city.setGeoLocation(geoLocation);
		city.setHistory(history);
		city.setWeatherConditions(weatherCondition);
		city.setPopulation(population);

		City res = cityRepository.create(city);

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
		return cityRepository.update(city);

	}
}
