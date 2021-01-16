package com.planetwalks.dynamicsinglepage.services;

import com.planetwalks.dynamicsinglepage.models.Place;
import com.planetwalks.dynamicsinglepage.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceRepositoryImpl {

	@Autowired
	private PlaceRepository placeRepository;


	public Place create(Place place) {
		return placeRepository.save(place);
	}

	public Place update(Place place) {
		return placeRepository.save(place);
	}
}
