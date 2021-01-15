package com.planetwalks.dynamicsinglepage.repositories;

import com.planetwalks.dynamicsinglepage.models.Fair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FairRepository extends JpaRepository<Fair, Long> {
}
