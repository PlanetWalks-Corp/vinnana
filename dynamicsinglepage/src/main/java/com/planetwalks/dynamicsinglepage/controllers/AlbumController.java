package com.planetwalks.dynamicsinglepage.controllers;

import com.planetwalks.dynamicsinglepage.models.Album;
import com.planetwalks.dynamicsinglepage.models.City;
import com.planetwalks.dynamicsinglepage.services.AlbumRepositoryImpl;
import com.planetwalks.dynamicsinglepage.services.CitiesRepositoriesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/album")
@CrossOrigin("*")
public class AlbumController {

	@Autowired
	private AlbumRepositoryImpl albumRepository;
	@Autowired
	private CitiesRepositoriesImpl citiesRepositories;

	@PostMapping("/save")
	public Album create(@RequestParam("albumName") String albumName,
	                    @RequestParam("cityId") Long cityId){
		Optional<City> city = citiesRepositories.findByCityId(cityId);
		City city1 = new City();
		city1.setCityId(city.get().getCityId());
		city1.setCityName(city.get().getCityName());
		city1.setPopulation(city.get().getPopulation());
		city1.setHistory(city.get().getHistory());
		city1.setWeatherConditions(city.get().getWeatherConditions());
		city1.setGeoLocation((city.get().getGeoLocation()));

		Album album = new Album();
		album.setAlbumName(albumName);
		album.setCity(city1);

		return albumRepository.create(album);

	}


}
