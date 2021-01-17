package com.planetwalks.dynamicsinglepage.services;

import com.planetwalks.dynamicsinglepage.models.*;
import com.planetwalks.dynamicsinglepage.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityRepositoryImpl {

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private PlaceRepository placeRepository;

	@Autowired
	private FairRepository fairRepository;

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private AlbumRepository albumRepository;

	public List<City> getAll() {
		return (List<City>) cityRepository.findAll();
	}


	public City create(City city) {
		return cityRepository.save(city);
//		City savedInstance = cityRepository.findOneBySlug(city.getSlug()).get();
//		if(savedInstance == null){
//			savedInstance = cityRepository.save(city);
//		}
//		if(city.getPlaceList() != null) {
//			for(Place place : city.getPlaceList()) {
////				Place savedPlace = placeRepository.findPlaceByPlaceNameAndCity(place.getPlaceName(), savedInstance).get();
////				if(savedPlace == null) {
//					place.setCity(savedInstance);
//					placeRepository.save(place);
//				//}
//			}
//		}
//		if(city.getFairList() != null) {
//			for(Fair fair : city.getFairList()) {
////				Fair savedFair = fairRepository.findFairByFairNameAndCity(fair.getFairName(), savedInstance).get();
////				if(savedFair == null) {
//					fair.setCity(savedInstance);
//					fairRepository.save(fair);
//				//}
//			}
//		}
//		if(city.getPersonList() != null) {
//			for(Person person : city.getPersonList()) {
////				Person savedPerson = personRepository.findPersonByPersonFirstNameAndCity(person.getPersonFirstName(), savedInstance).get();
////				if(savedPlace == null) {
//					person.setCity(savedInstance);
//					personRepository.save(person);
//				//}
//			}
//		}
//		if(city.getAlbum() != null) {
//			Album album = city.getAlbum();
////			Album savedAlbum = personRepository.findAlbumByAlbumNameAndCity(album.getAlbumName(), savedInstance).get();
////			if(savedPlace == null) {
//			album.setCity(savedInstance);
//			albumRepository.save(album);
//		//}
//		}
//
//		 return savedInstance;
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
