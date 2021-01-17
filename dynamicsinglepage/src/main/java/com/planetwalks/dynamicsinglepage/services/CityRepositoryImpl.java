package com.planetwalks.dynamicsinglepage.services;

import com.planetwalks.dynamicsinglepage.models.City;
import com.planetwalks.dynamicsinglepage.models.Place;
import com.planetwalks.dynamicsinglepage.repositories.CityRepository;
import com.planetwalks.dynamicsinglepage.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityRepositoryImpl {

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private PlaceRepository placeRepository;

	public List<City> getAll() {
		return (List<City>) cityRepository.findAll();
	}


	public City create(City city) {
		City savedInstance = cityRepository.findOneBySlug(city.getSlug()).get();
		if(savedInstance == null){
			savedInstance = cityRepository.save(city);
		}
		if(city.getPlaceList() != null) {
			for(Place place : city.getPlaceList()) {
//				Place savedPlace = placeRepository.findPlaceByPlaceNameAndCity(place.getPlaceName(), savedInstance).get();
//				if(savedPlace == null) {
					place.setCity(savedInstance);
					placeRepository.save(place);
				//}
			}
		}
		 return savedInstance;
	}

	public Optional<City> findByCityId(Long cityId){
		return cityRepository.findById(cityId);
	}

	public City update(City city) {
		return cityRepository.save(city);
	}

	public Optional<City> findBySlug(String slug) {
			return cityRepository.findOneBySlug(slug);
	}

}
