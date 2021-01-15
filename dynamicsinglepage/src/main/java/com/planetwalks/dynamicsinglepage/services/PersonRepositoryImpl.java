package com.planetwalks.dynamicsinglepage.services;

import com.planetwalks.dynamicsinglepage.models.Person;
import com.planetwalks.dynamicsinglepage.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonRepositoryImpl {

	@Autowired
	private PersonRepository personRepository;

	public Person create(Person person) {
		return personRepository.save(person);
	}

	public Person update(Person person) {
		return personRepository.save(person);
	}
}
