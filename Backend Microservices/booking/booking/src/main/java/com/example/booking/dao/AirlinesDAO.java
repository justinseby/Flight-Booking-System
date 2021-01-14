package com.example.booking.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.booking.entity.AirlinesEntity;

@Repository
public interface AirlinesDAO extends JpaRepository<AirlinesEntity, Integer> {
	
	List<AirlinesDAO> findByAirlineName(String airlineName);
	AirlinesEntity findByAirlineNameAndCity(String airlineName, String city);

}
