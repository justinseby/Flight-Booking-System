package com.example.Flight.service;

import java.util.List;

import com.example.Flight.entity.FlightEntity;
import com.example.Flight.model.AddNewFlight;
import com.example.Flight.model.FlightDTO;

public interface FlightService {
	 List<FlightDTO> getFlightDetails (String flightName);
	 AddNewFlight addFlight(AddNewFlight addNewFlight);
	 String delete(String flightName);
	 AddNewFlight updateFlight( AddNewFlight addNewFlight);
	 List<FlightEntity> getAllFlights();
}
