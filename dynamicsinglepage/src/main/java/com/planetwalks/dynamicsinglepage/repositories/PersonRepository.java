package com.planetwalks.dynamicsinglepage.repositories;

import com.planetwalks.dynamicsinglepage.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
