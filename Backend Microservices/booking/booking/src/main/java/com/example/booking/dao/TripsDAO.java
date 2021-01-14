package com.example.booking.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.booking.entity.TripsEntity;

@Repository
@Transactional
public interface TripsDAO extends JpaRepository<TripsEntity, Integer> {

	TripsEntity findByFlightNameAndAirlineName(String flightName, String airlineName);
	TripsEntity findByTripId(Integer tripId);
	List<TripsEntity> findAllByFlightName(String flightName);
	
}

