package com.example.booking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.booking.entity.FlightEntity;

@Repository
@Transactional
public interface FlightDAO extends JpaRepository<FlightEntity, Integer> {
	FlightEntity findByFlightName(String flightName);
}
