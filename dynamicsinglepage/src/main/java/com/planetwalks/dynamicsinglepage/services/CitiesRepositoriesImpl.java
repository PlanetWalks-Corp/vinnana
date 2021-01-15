package com.planetwalks.dynamicsinglepage.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.planetwalks.dynamicsinglepage.models.Cities;
import com.planetwalks.dynamicsinglepage.repositories.CitiesRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service

public class CitiesRepositoriesImpl {

	@Autowired
	public CitiesRepositories citiesRepositories ;

	public List<Cities> getAll() {
		return (List<Cities>) citiesRepositories.findAll();
	}

	public Cities create(Cities city) {
		citiesRepositories.save(city);
		return city;
	}

	public Optional<Cities> findByCityId(Long cityId){
		return citiesRepositories.findById(cityId);
	}


}
