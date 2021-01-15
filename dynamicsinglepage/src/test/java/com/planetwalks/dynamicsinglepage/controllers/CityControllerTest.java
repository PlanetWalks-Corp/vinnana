package com.planetwalks.dynamicsinglepage.controllers;

import com.planetwalks.dynamicsinglepage.models.City;
import com.planetwalks.dynamicsinglepage.services.CitiesRepositoriesImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class CityControllerTest {

	@Mock
	CitiesRepositoriesImpl citiesRepositories;

	City city;

	@BeforeEach
	void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);

		city = new City();
		city.setCityId(200L);
		city.setCityName("jalandhar");
		city.setHistory("It has a vast history");
		city.setPopulation(200000L);
		city.setGeoLocation("near jalandhar");
		city.setWeatherConditions("mostly humid");
		city.setAlbum(null);
		city.setPersonList(null);
		city.setPlaceList(null);
		city.setFairList(null);
	}

	@Test
	void getCityById() {
		when(citiesRepositories.findByCityId(anyLong())).thenReturn(java.util.Optional.ofNullable(city));
	}
}
