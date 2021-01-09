package com.planetwlaks.dynamicsinglepage.services;

import com.planetwlaks.dynamicsinglepage.models.Cities;
import com.planetwlaks.dynamicsinglepage.repositories.CitiesRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitiesRepositoriesImpl {

	@Autowired
	private final CitiesRepositories citiesRepositories ;

	public CitiesRepositoriesImpl(CitiesRepositories citiesRepositories) {
		this.citiesRepositories = citiesRepositories;
	}

	public List<Cities> getAll() {
		return (List<Cities>) citiesRepositories.findAll();
	}

	public void create(Cities city) {
		citiesRepositories.save(city);
	}
}
