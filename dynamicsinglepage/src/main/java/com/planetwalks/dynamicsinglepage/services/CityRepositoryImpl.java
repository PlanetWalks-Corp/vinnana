package com.planetwalks.dynamicsinglepage.services;

import com.planetwalks.dynamicsinglepage.models.City;
import com.planetwalks.dynamicsinglepage.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityRepositoryImpl {

	@Autowired
	private CityRepository cityRepository;

	public List<City> getAll() {
		return (List<City>) cityRepository.findAll();
	}


	public City create(City city) {
		cityRepository.save(city);
		return city;
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
