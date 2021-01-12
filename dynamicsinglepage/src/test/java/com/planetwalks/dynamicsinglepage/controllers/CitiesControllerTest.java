package com.planetwalks.dynamicsinglepage.controllers;

import com.planetwalks.dynamicsinglepage.models.Cities;
import com.planetwalks.dynamicsinglepage.services.CitiesRepositoriesImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class CitiesControllerTest {

	@Mock
	CitiesRepositoriesImpl citiesRepositories;

	Cities cities;

	@BeforeEach
	void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);

		cities = new Cities();
		cities.setCityId(200L);
		cities.setCityName("jalandhar");
		cities.setHistory("It has a vast history");
		cities.setPopulation(200000L);
		cities.setGeoLocation("near jalandhar");
		cities.setWeatherConditions("mostly humid");
		cities.setAlbum(null);
		cities.setPersonList(null);
		cities.setPlaceList(null);
		cities.setFairList(null);
	}

	@Test
	void getCityById() {
		when(citiesRepositories.findByCityId(anyLong())).thenReturn(java.util.Optional.ofNullable(cities));
	}
}
