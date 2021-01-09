package com.planetwlaks.dynamicsinglepage.services;

import com.planetwlaks.dynamicsinglepage.models.FamousThings;
import com.planetwlaks.dynamicsinglepage.repositories.FamousThingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamousThingsRepositoryImpl {

	@Autowired
	private final FamousThingsRepository famousThingsRepository;

	public FamousThingsRepositoryImpl(FamousThingsRepository famousThingsRepository) {
		this.famousThingsRepository = famousThingsRepository;
	}

	public List<FamousThings> getCityId(Long cityId) {
		return famousThingsRepository.findByCityId(cityId);
	}

	public void create(FamousThings famousThings) {
		famousThingsRepository.save(famousThings);
	}
}
