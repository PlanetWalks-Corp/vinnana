package com.planetwlaks.dynamicsinglepage.repositories;

import com.planetwlaks.dynamicsinglepage.models.FamousThings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamousThingsRepository extends CrudRepository<FamousThings, Long> {
}
