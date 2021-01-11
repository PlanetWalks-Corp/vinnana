package com.planetwalks.dynamicsinglepage.controllers;

import com.planetwalks.dynamicsinglepage.models.Cities;
import com.planetwalks.dynamicsinglepage.models.Person;
import com.planetwalks.dynamicsinglepage.services.CitiesRepositoriesImpl;
import com.planetwalks.dynamicsinglepage.services.PersonRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonRepositoryImpl personRepository;
	@Autowired
	private CitiesRepositoriesImpl citiesRepositories;


	@PostMapping("/save")
	public Person create(@RequestParam("firstName") String firstName,
	                     @RequestParam("lastName") String lastName,
	                     @RequestParam("description") String description,
	                     @RequestParam("profession") String profession,
	                     @RequestParam("imageName") String imageName,
	                     @RequestParam("dob") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate dob,
	                     @RequestParam("cityId") Long cityId){

		Optional<Cities> city = citiesRepositories.findByCityId(cityId);
		Cities city1 = new Cities();
		city1.setCityId(city.get().getCityId());
		city1.setCityName(city.get().getCityName());
		city1.setPopulation(city.get().getPopulation());
		city1.setHistory(city.get().getHistory());
		city1.setWeatherConditions(city.get().getWeatherConditions());
		city1.setGeoLocation((city.get().getGeoLocation()));

		int age = 0;
		LocalDate date = LocalDate.now();
		System.out.println(date);

		Period p = Period.between(dob, date);
		age = p.getYears();

		Person person = new Person();

		person.setPersonFirstName(firstName);
		person.setPersonLastName(lastName);
		person.setDescription(description);
		person.setProfession(profession);
		person.setImageName(imageName);
		person.setDob(dob);
		person.setAge(age);
		person.setCities(city1);
		return personRepository.create(person);



	}
}
