package com.planetwlaks.dynamicsinglepage.services;

import com.planetwlaks.dynamicsinglepage.repositories.CitiesRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitiesRepositoriesImpl {

	@Autowired
	private final CitiesRepositories citiesRepositories ;

	public CitiesRepositoriesImpl(CitiesRepositories citiesRepositories) {
		this.citiesRepositories = citiesRepositories;
	}
}
