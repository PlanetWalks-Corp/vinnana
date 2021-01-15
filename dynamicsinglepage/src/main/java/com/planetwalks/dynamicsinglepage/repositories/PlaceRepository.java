package com.planetwalks.dynamicsinglepage.repositories;

import com.planetwalks.dynamicsinglepage.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
}
