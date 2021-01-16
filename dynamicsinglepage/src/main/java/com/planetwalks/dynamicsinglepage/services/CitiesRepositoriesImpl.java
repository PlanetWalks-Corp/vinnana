package com.planetwalks.dynamicsinglepage.services;

import com.planetwalks.dynamicsinglepage.models.City;
import com.planetwalks.dynamicsinglepage.repositories.CitiesRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitiesRepositoriesImpl {

	@Autowired
	private CitiesRepositories citiesRepositories ;

	public List<City> getAll() {
		return (List<City>) citiesRepositories.findAll();
	}


	public City create(City city) {
		citiesRepositories.save(city);
		return city;
	}

	public Optional<City> findByCityId(Long cityId){
		return citiesRepositories.findById(cityId);
	}

	public City update(City city) {
		return citiesRepositories.save(city);
	}

		public Optional<City> findBySlug(String slug){
			return citiesRepositories.findBySlug(slug);
		}

}
