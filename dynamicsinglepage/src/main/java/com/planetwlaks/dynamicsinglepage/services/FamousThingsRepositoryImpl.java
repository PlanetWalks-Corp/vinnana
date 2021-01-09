package com.planetwlaks.dynamicsinglepage.services;

import com.planetwlaks.dynamicsinglepage.repositories.FamousThingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamousThingsRepositoryImpl {

	@Autowired
	private final FamousThingsRepository famousThingsRepository;

	public FamousThingsRepositoryImpl(FamousThingsRepository famousThingsRepository) {
		this.famousThingsRepository = famousThingsRepository;
	}
}
