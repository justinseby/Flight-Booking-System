package com.example.Flight.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.Flight.entity.FlightEntity;

@Repository
@Transactional
public interface FlightDAO extends JpaRepository<FlightEntity, Integer> {
	FlightEntity findByFlightName(String flightName);
	FlightEntity findByFlightId(Integer flightId);
}

