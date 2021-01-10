package com.planetwlaks.dynamicsinglepage.services;

import com.planetwlaks.dynamicsinglepage.models.ThingsTypes;
import com.planetwlaks.dynamicsinglepage.repositories.ThingsTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThingsTypesRepositoryImpl {

	@Autowired
	private ThingsTypesRepository thingsTypesRepository;


	public List<ThingsTypes> getAll() {
		return (List<ThingsTypes>) thingsTypesRepository.findAll();
	}

	public void create(ThingsTypes thingsTypes) {
		thingsTypesRepository.save(thingsTypes);
	}
}
