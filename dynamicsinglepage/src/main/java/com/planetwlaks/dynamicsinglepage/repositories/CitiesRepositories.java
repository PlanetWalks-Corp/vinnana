package com.planetwlaks.dynamicsinglepage.repositories;

import com.planetwlaks.dynamicsinglepage.models.Cities;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitiesRepositories extends CrudRepository<Cities, Long> {
}
