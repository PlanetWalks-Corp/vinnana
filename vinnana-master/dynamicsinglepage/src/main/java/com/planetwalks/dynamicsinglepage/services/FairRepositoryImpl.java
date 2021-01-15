package com.planetwalks.dynamicsinglepage.services;

import com.planetwalks.dynamicsinglepage.models.Fair;
import com.planetwalks.dynamicsinglepage.repositories.FairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FairRepositoryImpl {

	@Autowired
	private FairRepository fairRepository;


	public Fair create(Fair fair) {
		return fairRepository.save(fair);
	}
}
