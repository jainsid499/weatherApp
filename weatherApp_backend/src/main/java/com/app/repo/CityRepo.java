package com.app.repo;

import com.app.model.city;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepo extends JpaRepository<city,Integer> {
}
