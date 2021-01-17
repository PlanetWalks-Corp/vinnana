package com.planetwalks.dynamicsinglepage.repositories;

import com.planetwalks.dynamicsinglepage.models.City;
import com.planetwalks.dynamicsinglepage.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    Optional<Place> findPlaceByPlaceNameAndCity(String placeName, City city);
}
